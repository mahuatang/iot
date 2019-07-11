/**
 * Project Name:SOCO_Report
 * File Name:TrailDeviceSearchControll.java
 * Package Name:com.soco.car.report.controll
 * Date:2018年6月22日上午10:06:58
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soco.car.report.api.domain.GeoDomain;
import com.soco.car.report.api.request.QueryAreaRequest;
import com.soco.car.report.api.request.QueryNearByRequest;
import com.soco.car.report.api.response.BaseResponse;
import com.soco.car.report.api.response.QueryAreaResponse;
import com.soco.car.report.handler.BaseResponseGenerator;
import com.soco.car.report.service.TrailDeviceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * ClassName:TrailDeviceSearchControll <br/>
 * Reason: 与轨迹相关统计接口统一入口. <br/>
 * Date: 2018年6月22日 上午10:06:58 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
//支持跨域访问
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rest/trailDevice")
@Api(value = "/rest/trailDevice", tags = { "与轨迹相关统计接口统一入口" })
public class TrailDeviceControll {

	private static final Logger logger = LoggerFactory.getLogger(TrailDeviceControll.class);

	@Autowired
	private TrailDeviceService trailDeviceService;

	@ApiOperation(value = "根据经纬度获取附近的车辆信息", notes = "经纬度为必传参数，默认最大获取1000条数据")
	@ApiResponses(value = { 
			@ApiResponse(code = 405, message = "Invalid input", response = GeoDomain.class)})
	@RequestMapping(method = { RequestMethod.POST}, path = "/searchNearBy")
	public BaseResponse<List<GeoDomain>> searchNearBy(@RequestBody QueryNearByRequest queryNearByRequest) {
		return BaseResponseGenerator.genSuccessResult(trailDeviceService.searchNearBy(queryNearByRequest));
	}

	@ApiOperation(value = "根据参数获取省市级车俩统计详情", notes = "根据区域残烛,经纬度参数类型为必传参数")
	@ApiResponses(value = { 
			@ApiResponse(code = 405, message = "Invalid input", response = QueryAreaResponse.class)})
	@RequestMapping(method = { RequestMethod.POST }, path = "/searchAreaInfo")
	public BaseResponse<QueryAreaResponse> searchAreaInfo(@RequestBody QueryAreaRequest queryAreaRequest) {
		return trailDeviceService.searchAreaInfo(queryAreaRequest);
	}

}
