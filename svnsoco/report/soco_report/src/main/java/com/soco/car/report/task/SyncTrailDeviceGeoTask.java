/**
 * Project Name:SOCO_Report
 * File Name:SyncTrailDeviceGeoTask.java
 * Package Name:com.soco.car.report.task
 * Date:2018年6月22日下午4:55:54
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.task;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.soco.car.car.api.CarTypeApi;
import com.soco.car.car.entity.CarType;
import com.soco.car.report.api.domain.AddressComponentDomain;
import com.soco.car.report.api.response.BaiduGeoReponse;
import com.soco.car.report.index.TrailDeviceIndex;
import com.soco.car.report.service.BaiduMapService;
import com.soco.car.report.service.TrailDeviceService;

/**
 * ClassName:SyncTrailDeviceGeoTask <br/>
 * Reason: 同步用户地址详情数据任务. <br/>
 * Date: 2018年6月22日 下午4:55:54 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Component
public class SyncTrailDeviceGeoTask {

	private static final Logger logger = LoggerFactory.getLogger(SyncTrailDeviceGeoTask.class);
	@Autowired
	private TrailDeviceService trailDeviceService;
	@Autowired
	private BaiduMapService baiduMapService;
	
	/**
	 * 因配额问题每日只有6000次为免费，次同步数据目前暂定只使用3页，每页为1000条数据。（最大调用为30000次）
	 */
	@Value("${max.remote.page.baidu.api}")
	private Integer maxRemotePageBaiduApi = 30;
	
	@Reference
	private CarTypeApi carTypeApi;

	/**
	 * 
	 * run: 每次凌晨执行，确认用户地址详情信息
	 *
	 * @author sunlangping
	 */
	@Scheduled(cron = "${sync.trail.device.geo.task.cron}")
	public void run() {
		long begin = System.currentTimeMillis();
		
		logger.info("SyncTrailDeviceGeoTask 同步开始");
		int pageNum = 1;
		int pageSize = 1000;
		Page<TrailDeviceIndex> page = null;
		do {
			page = trailDeviceService.findByPage(pageNum, pageSize);
			List<TrailDeviceIndex> trailDeviceList = page.getContent();
			if (CollectionUtils.isEmpty(trailDeviceList)) {
				break;
			}
			fullAreaInfoData(trailDeviceList);
			pageNum++;
			//百度接口有限制使用次数，故设置超过最大分页的使用次数停止调用接口
			if (pageNum > maxRemotePageBaiduApi) {
				break;
			}
		} while (page.hasNext() || page == null);
		long end = System.currentTimeMillis();
		logger.info("SyncTrailDeviceGeoTask 同步结束,一共耗时{}秒", ((end - begin)) / 1000);
	}

	/**
	 * 
	 * fullData: 填充用户的地址信息详情
	 *
	 * @author sunlangping
	 * @param trailDeviceList
	 */
	private void fullAreaInfoData(List<TrailDeviceIndex> trailDeviceList) {
		if (CollectionUtils.isEmpty(trailDeviceList)) {
			return;
		}
		for (TrailDeviceIndex t : trailDeviceList) {
			try {
				//防止百度地图拒绝服务所以休眠20毫秒
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e) {
				logger.error("方法名:fullAreaInfoData,错误描述为{} ", e.getMessage());
			}
			String geo = t.getGeo().getLat() + "," + t.getGeo().getLon();
			BaiduGeoReponse baiduGeoReponse = baiduMapService.getGeoInfo(geo);
			if (null == baiduGeoReponse || baiduGeoReponse.getStatus() != 0) {
				logger.warn("请求百度地图出现异常，请求参数为:{},返回参数为:{}", geo, baiduGeoReponse);
				continue;
			}
			if (null != baiduGeoReponse.getResult() && null != baiduGeoReponse.getResult().getAddressComponent()) {
				AddressComponentDomain addressComponentDomain = baiduGeoReponse.getResult().getAddressComponent();
				t.setCountry(addressComponentDomain.getCountry());
				t.setProvince(addressComponentDomain.getProvince());
				t.setCity(addressComponentDomain.getCity());
				t.setDistrict(addressComponentDomain.getDistrict());
			}
			fullCarTypeInfo(t);
		}
		trailDeviceService.batchSave(trailDeviceList);
	}
	/**
	 * 
	 * fullCarTypeInfo: 填充车型信息
	 *
	 * @author sunlangping
	 * @param t
	 */
	private void fullCarTypeInfo(TrailDeviceIndex t) {
		if (t == null || StringUtils.isEmpty(t.getDeviceNo())) {
			return;
		}
		CarType carType = carTypeApi.findByDeviceNo(t.getDeviceNo());
		if (carType == null) {
			return;
		}
		t.setCarType(carType.getCarTypeCode());
	}
}
