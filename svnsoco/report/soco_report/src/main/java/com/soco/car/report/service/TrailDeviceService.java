/**
 * Project Name:SOCO_Report
 * File Name:TrailDeviceService.java
 * Package Name:com.soco.car.report.service
 * Date:2018年6月22日上午9:48:46
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.InternalTerms;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms.Bucket;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.soco.car.report.api.domain.AreaInfoDomain;
import com.soco.car.report.api.domain.GeoDomain;
import com.soco.car.report.api.request.QueryAreaRequest;
import com.soco.car.report.api.request.QueryNearByRequest;
import com.soco.car.report.api.response.BaiduGeoReponse;
import com.soco.car.report.api.response.BaseResponse;
import com.soco.car.report.api.response.QueryAreaResponse;
import com.soco.car.report.constants.CarStatusEnum;
import com.soco.car.report.constants.SOCOReportConstant;
import com.soco.car.report.handler.BaseResponseGenerator;
import com.soco.car.report.index.TrailDeviceIndex;
import com.soco.car.report.repository.TrailDeviceRepository;
import com.soco.car.report.utils.CoordinateUtil;
import com.soco.car.report.utils.GeoUtil;
import com.soco.car.report.utils.Gps;

/**
 * ClassName:TrailDeviceService <br/>
 * Reason: 设备轨迹相关服务. <br/>
 * Date: 2018年6月22日 上午9:48:46 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class TrailDeviceService {

	private static final Logger logger = LoggerFactory.getLogger(TrailDeviceService.class);

	@Autowired
	private TrailDeviceRepository trailDeviceRepository;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Autowired
	private BaiduMapService baiduMapService;

	/**
	 * 
	 * searchNearBy:搜索附近的车相关信息
	 *
	 * @author sunlangping
	 * @param queryNearByRequest
	 * @return
	 */
	public List<GeoDomain> searchNearBy(QueryNearByRequest queryNearByRequest) {
		Double latitude = queryNearByRequest.getLatitude();
		Double longitude = queryNearByRequest.getLongitude();
		Double distance = queryNearByRequest.getDistance();
		if (distance == null) {
			distance = SOCOReportConstant.DEFAULT_NEAR_BY_DISTANCE;
		}
		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
		Calendar from = Calendar.getInstance();
		// 搜索最近骑行的车俩数据，目前单位为分钟
		if (null != queryNearByRequest.getMinute()) {
			from.add(Calendar.MINUTE, -queryNearByRequest.getMinute());
			boolQuery.must(QueryBuilders.rangeQuery("trailTime").gte(from.getTime().getTime()));
		}

		// 距离搜索过滤单位为米
		GeoDistanceQueryBuilder geofilter = QueryBuilders.geoDistanceQuery("geo").point(latitude, longitude)
				.distance(distance, DistanceUnit.METERS);
		// geofilter.filter(new GeoDistanceQueryBuilder("geo").point(new
		// GeoPoint(latitude, longitude))
		// .distance(distance, DistanceUnit.KILOMETERS));
		// 距离排序
		GeoDistanceSortBuilder geoSortBuilder = SortBuilders.geoDistanceSort("geo", latitude, longitude);
		geoSortBuilder.order(SortOrder.ASC);

		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withPageable(PageRequest.of(queryNearByRequest.getPageNum() - 1, queryNearByRequest.getPageSize()))
				.withQuery(boolQuery).withFilter(geofilter).withSort(geoSortBuilder).build();

		Page<TrailDeviceIndex> page = elasticsearchTemplate.queryForPage(searchQuery, TrailDeviceIndex.class);
		List<GeoDomain> geoDomainList = new ArrayList<>();
		page.getContent().forEach(t -> {
			GeoDomain geoDomain = new GeoDomain();
			geoDomain.setDeviceNo(t.getDeviceNo());
			if (null != t.getGeo()) {
				// 火星系坐标转换成高德坐标
				Gps gps = CoordinateUtil.gps84_To_Gcj02(t.getGeo().getLat(), t.getGeo().getLon());
				String[] lngLat = new String[] { gps.getWgLon() + "", gps.getWgLat() + "" };
				geoDomain.setLnglat(lngLat);
				geoDomain.setIsStart(t.getIsStartup());
				geoDomain.setNowElec(t.getNowElec());
				// 计算两点之间的距离
				double d = GeoUtil.getDistanceOfMeter(latitude, longitude, gps.getWgLat(), gps.getWgLon());
				geoDomain.setDistance(d);
				fullUIStyle(t, geoDomain);
				geoDomainList.add(geoDomain);
			}
		});
		return geoDomainList;
	}

	/**
	 * 
	 * fullUIStyle: 用于界面UI渲染显示车的风格样式
	 *
	 * @author sunlangping
	 * @param t
	 * @param geoDomain
	 */
	private void fullUIStyle(TrailDeviceIndex t, GeoDomain geoDomain) {
		if (t.getCarType() != null && t.getCarType().startsWith(SOCOReportConstant.CAR_TYPE_PREFIX_CU)) {
			geoDomain.setStyle(
					isStart(t) ? CarStatusEnum.car_cu_online.getValue() : CarStatusEnum.car_cu_offline.getValue());
		} else if (t.getCarType() != null && t.getCarType().startsWith(SOCOReportConstant.CAR_TYPE_PREFIX_TC)) {
			geoDomain.setStyle(
					isStart(t) ? CarStatusEnum.car_tc_online.getValue() : CarStatusEnum.car_tc_offline.getValue());
		} else {
			geoDomain.setStyle(
					isStart(t) ? CarStatusEnum.car_ts_online.getValue() : CarStatusEnum.car_ts_offline.getValue());
		}

	}

	/**
	 * 
	 * isStart: 是否骑行中状态判断
	 *
	 * @author sunlangping
	 * @param t
	 * @return
	 */
	private boolean isStart(TrailDeviceIndex t) {
		boolean flag = false;
		if (null != t.getIsStartup() && SOCOReportConstant.IS_START == t.getIsStartup()) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 
	 * findByPage: 后期用于处理用于填充数据失效不准的问题
	 *
	 * @author sunlangping
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page<TrailDeviceIndex> findByPage(int pageNum, Integer pageSize) {

		// List<SortBuilder> sorts = new ArrayList<SortBuilder>();

		// BoolQueryBuilder querys = QueryBuilders.boolQuery();
		// 高版本不支持文本类型排列，如需支持，必须手动开启设置
		// FieldSortBuilder fieldSortBuilder = SortBuilders.fieldSort("district");
		// querys.mustNot(QueryBuilders.existsQuery("district"));
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(PageRequest.of(pageNum - 1, pageSize))
				// .withQuery(querys)
				// .withSort(fieldSortBuilder)
				.build();
		searchQuery.addSort(new Sort(Direction.DESC, "modifyTime"));

		 Page<TrailDeviceIndex> page = elasticsearchTemplate.queryForPage(searchQuery,
		 TrailDeviceIndex.class);
//		Page<TrailDeviceIndex> page = elasticsearchTemplate.startScroll(20000, searchQuery, TrailDeviceIndex.class);
//		Page<TrailDeviceIndex> page = elasticsearchTemplate.startScroll(20000, searchQuery, TrailDeviceIndex.class,new SearchResultMapper() {
//
//			@Override
//			public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
//				return null;
//			}
//		});
		return page;
	}

	public void batchSave(List<TrailDeviceIndex> trailDeviceIndexList) {
		trailDeviceRepository.saveAll(trailDeviceIndexList);
	}

	/**
	 * 
	 * searchAreaInfo: 根据不同参数，聚合各类省市区数据返回
	 *
	 * @author sunlangping
	 */
	public BaseResponse<QueryAreaResponse> searchAreaInfo(QueryAreaRequest queryAreaRequest) {

		Integer areaType = queryAreaRequest.getAreaType();
		QueryAreaResponse response = new QueryAreaResponse();
		List<AreaInfoDomain> areaInfoDomainList = new ArrayList<AreaInfoDomain>();

		BaiduGeoReponse baiduGeoReponse = null;
		if (null != queryAreaRequest.getLatitude() && queryAreaRequest.getLongitude() != null) {
			String geo = queryAreaRequest.getLatitude() + "," + queryAreaRequest.getLongitude();
			baiduGeoReponse = baiduMapService.getGeoInfo(geo);
		}
		if (null == baiduGeoReponse || baiduGeoReponse.getResult() == null
				|| baiduGeoReponse.getResult().getAddressComponent() == null) {
			return BaseResponseGenerator.genErrorResult(SOCOReportConstant.ERROR_CODE_400,
					MessageFormat.format("请求参数不正确,请求过来的经纬度获取不到省市级信息,参数为{0}", queryAreaRequest));
		}

		NativeSearchQuery searchQuery = buildQuery(areaType, baiduGeoReponse);
		Aggregations agg = (Aggregations) elasticsearchTemplate.query(searchQuery, new ResultsExtractor() {
			@Override
			public Object extract(SearchResponse response) {
				return response.getAggregations();
			}
		});
		Map<String, Aggregation> reponseMap = agg.asMap();
		int total = 0;
		for (String s : reponseMap.keySet()) {
			InternalTerms a = (InternalTerms) reponseMap.get(s);
			List<Bucket> list = a.getBuckets();
			for (Terms.Bucket b : list) {
				AreaInfoDomain areaInfo = new AreaInfoDomain();
				areaInfo.setSize(b.getDocCount());
				areaInfo.setAreaName(b.getKeyAsString());
				if (StringUtils.isNotEmpty(b.getKeyAsString())
						&& StringUtils.isNotEmpty(baiduGeoReponse.getResult().getAddressComponent().getCity())) {
					total += b.getDocCount();
					fullLatLngData(baiduGeoReponse, b, areaInfo);
				}
				areaInfoDomainList.add(areaInfo);
				logger.info("key:{},value{}", b.getKeyAsString(), +b.getDocCount());
			}
		}
		response.setTotal(total);
		response.setAreaType(queryAreaRequest.getAreaType());
		response.setAreaInfoList(areaInfoDomainList);
		return BaseResponseGenerator.genSuccessResult(response);
	}

	/**
	 * 
	 * fullLatLngData:填充返回的经纬度相关信息
	 *
	 * @author sunlangping
	 * @param baiduGeoReponse
	 * @param b
	 */
	private void fullLatLngData(BaiduGeoReponse baiduGeoReponse, Terms.Bucket b, AreaInfoDomain areaInfo) {
		BaiduGeoReponse lngLatResponse = baiduMapService
				.getLntLat(baiduGeoReponse.getResult().getAddressComponent().getCity(), b.getKeyAsString());
		if (null == lngLatResponse || lngLatResponse.getResult() == null
				|| lngLatResponse.getResult().getLocation() == null) {
			return;
		}
		Gps gps = CoordinateUtil.bdToGaoDe(lngLatResponse.getResult().getLocation().getLat(),
				lngLatResponse.getResult().getLocation().getLng());
		areaInfo.setLatitude(gps.getWgLat());
		areaInfo.setLongitude(gps.getWgLon());
	}

	/**
	 * 
	 * buildQuery:根据条件动态构建查询参数
	 *
	 * @author sunlangping
	 * @param queryAreaRequest
	 * @param areaType
	 * @return
	 */
	private NativeSearchQuery buildQuery(Integer areaType, BaiduGeoReponse baiduGeoReponse) {
		BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
		NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
		if (areaType == SOCOReportConstant.AREA_COUNTRY) {
			searchQuery.addAggregation(AggregationBuilders.terms("countrys").field("country")
					.size(SOCOReportConstant.DEFAULT_AGGREGATION_SIZE));
		} else if (areaType == SOCOReportConstant.AREA_PROVINCE) {
			queryBuilder.must(
					QueryBuilders.termQuery("country", baiduGeoReponse.getResult().getAddressComponent().getCountry()));
			searchQuery.addAggregation(AggregationBuilders.terms("provinces").field("province")
					.size(SOCOReportConstant.DEFAULT_AGGREGATION_SIZE));
		} else if (areaType == SOCOReportConstant.AREA_CITY) {
			queryBuilder.must(QueryBuilders.termQuery("province",
					baiduGeoReponse.getResult().getAddressComponent().getProvince()));
			searchQuery.addAggregation(
					AggregationBuilders.terms("citys").field("city").size(SOCOReportConstant.DEFAULT_AGGREGATION_SIZE));
		} else if (areaType == SOCOReportConstant.AREA_DISTRICT) {
			queryBuilder
					.must(QueryBuilders.termQuery("city", baiduGeoReponse.getResult().getAddressComponent().getCity()));
			searchQuery.addAggregation(AggregationBuilders.terms("districts").field("district")
					.size(SOCOReportConstant.DEFAULT_AGGREGATION_SIZE));
		} else if (areaType == SOCOReportConstant.AREA_ALL_DISTRICT) {
//			queryBuilder
//					.must(QueryBuilders.termQuery("city", baiduGeoReponse.getResult().getAddressComponent().getCity()));
			searchQuery.addAggregation(AggregationBuilders.terms("districts").field("district")
					.size(SOCOReportConstant.DEFAULT_AGGREGATION_SIZE));
		}
		return searchQuery;
	}
}
