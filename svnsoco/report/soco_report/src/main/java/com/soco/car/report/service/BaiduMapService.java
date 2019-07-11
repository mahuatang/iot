/**
 * Project Name:SOCO_Report
 * File Name:BaiduMapService.java
 * Package Name:com.soco.car.report.service
 * Date:2018年6月22日下午3:19:29
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.service;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.hualinfor.soco.util.GsonUtils;
import com.soco.car.report.api.response.BaiduGeoReponse;
import com.soco.car.report.constants.SOCOReportConstant;

/**
 * ClassName:BaiduMapService <br/>
 * Reason: 百度地图相关接口实现类. <br/>
 * Date: 2018年6月22日 下午3:19:29 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class BaiduMapService {

	private static final Logger logger = LoggerFactory.getLogger(BaiduMapService.class);

	@Value("${baidu.map.api.ak}")
	private String baiduMapApiAK;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 
	 * getGeoInfo: 获取百度地址位置详情信息
	 *
	 * @author sunlangping
	 * @param geo
	 * @return
	 */
	public BaiduGeoReponse getGeoInfo(String geo) {
		BaiduGeoReponse baiduGeoReponse=null;
		try {
			String url = MessageFormat.format(SOCOReportConstant.HTTP_BAIDU_GEO_URL, geo, baiduMapApiAK);
			String geoStr = restTemplate.getForObject(url, String.class);
			if (StringUtils.isEmpty(geoStr)) {
				return null;
			}
			baiduGeoReponse = GsonUtils.fromJson(geoStr, BaiduGeoReponse.class);
			if (baiduGeoReponse.getStatus() == SOCOReportConstant.BAIDU_API_SUCESS) {
				return baiduGeoReponse;
			} else {
				logger.warn("百度地图调用出错参数为:{}", baiduGeoReponse);
				return baiduGeoReponse;
			}
		} catch (RestClientException e) {
			logger.error("请求百度地图API出错，出错方法getGeoInfo,参数为{},错误描述{}", geo,e.getMessage());
		}
		return baiduGeoReponse;
	}

	/**
	 * 
	 * getGeoInfo: 获取百度地址位置详情信息
	 *
	 * @author sunlangping
	 * @param geo
	 * @return
	 */
	public BaiduGeoReponse getLntLat(String city, String area) {
		String url = MessageFormat.format(SOCOReportConstant.HTTP_BAIDU_LNG_LAT_URL, city, area, baiduMapApiAK);
		BaiduGeoReponse baiduGeoReponse = null;
		try {
			String geoStr = restTemplate.getForObject(url, String.class);
			if (StringUtils.isEmpty(geoStr)) {
				return null;
			}
			baiduGeoReponse = GsonUtils.fromJson(geoStr, BaiduGeoReponse.class);
			if (baiduGeoReponse.getStatus() == SOCOReportConstant.BAIDU_API_SUCESS) {
				return baiduGeoReponse;
			} else {
				logger.warn("百度地图调用出错参数为:{}", baiduGeoReponse);
				return baiduGeoReponse;
			}
		} catch (RestClientException e) {
			logger.error("请求百度地图API出错，出错方法getLntLat,参数城市{},区域{},错误描述:", city, area, e.getMessage());
		}
		return baiduGeoReponse;
	}
}
