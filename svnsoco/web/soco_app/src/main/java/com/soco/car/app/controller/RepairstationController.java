package com.soco.car.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.soco.car.app.api.request.NearByLocationRequest;
import com.soco.car.app.api.response.BaseResponse;
import com.soco.car.app.handler.BaseResponseGenerator;
import com.soco.car.user.api.RepairstationApi;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/rest/v1/repairstation")
@Api(value = "/rest/v1/repairstation", tags = { "网点服务相关接口" })
public class RepairstationController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserbinddeviceController.class);

	@Reference
	private RepairstationApi repairstationApi;

	/**
	 * 根据地区名称查询维修站列表
	 * 
	 * @param repairProvinceRequest
	 * @return
	 */
	@PostMapping("nearby")
	public BaseResponse nearby(@RequestBody NearByLocationRequest nearByLocationRequest) {
		// 默认搜索附近500公里的
		if (nearByLocationRequest.getDistance() == null) {
			nearByLocationRequest.setDistance(500);
		}
		return BaseResponseGenerator.genSuccessResult(repairstationApi.nearbyList(nearByLocationRequest.getCurrLng(),
				nearByLocationRequest.getCurrLat(), nearByLocationRequest.getDistance(),
				nearByLocationRequest.getPageNum(), nearByLocationRequest.getPageSize()));
	}
}
