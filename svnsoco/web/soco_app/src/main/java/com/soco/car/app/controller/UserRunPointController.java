/**
 * Project Name:soco_app
 * File Name:UserRunPointController.java
 * Package Name:com.soco.car.app.controller
 * Date:2018年7月31日下午4:54:06
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.soco.car.app.api.request.BaseRequest;
import com.soco.car.app.api.response.BaseResponse;
import com.soco.car.app.constants.ResponseMessageEnum;
import com.soco.car.app.constants.SOCOAppConstant;
import com.soco.car.app.handler.BaseResponseGenerator;
import com.soco.car.app.service.UserService;
import com.soco.car.device.api.DeviceApi;
import com.soco.car.user.api.UserApi;

import io.swagger.annotations.Api;

/**
 * ClassName:UserRunPointController <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月31日 下午4:54:06 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@RestController
@RequestMapping(value = "/rest/v1/userRunPoint")
@Api(value = "/rest/v1/userRunPoint", tags = { "用户骑行轨迹相关" })
public class UserRunPointController extends BaseController {

	@Autowired
	private UserService userService;

	@Reference
	private UserApi userApi;

	@Reference
	private DeviceApi deviceApi;

	@ApiOperation("查询历史轨迹")
	@PostMapping("list")
	public BaseResponse list(@RequestBody BaseRequest baseRequest) {
		return BaseResponseGenerator.genSuccessResult(
				userApi.findRunHistryList(getUser().getUserId(), baseRequest.getPageNum(), baseRequest.getPageSize()));
	}
	
	/**
	 * 
	 * sw:
	 *
	 * @author sunlangping
	 * @param historyLocusSwitch
	 * @return
	 */
	@ApiOperation("查询用户历史定位信息")
	@PostMapping("sw/{historyLocusSwitch}")
	public BaseResponse sw(@PathVariable Integer historyLocusSwitch) {
		if (historyLocusSwitch != SOCOAppConstant.DELETE_FLAG_Y
				&& historyLocusSwitch != SOCOAppConstant.DELETE_FLAG_N) {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.params_error.getValue());
		}
		return userService.historyLocusSwitch(getUser(), historyLocusSwitch);
	}

	@ApiOperation("删除轨迹列表(逻辑删除)")
	@PostMapping("removeIds/{pointIds}")
	public BaseResponse removeIds(@PathVariable String pointIds) {
		if (StringUtils.isNotEmpty(pointIds)) {
			deviceApi.removePointIds(pointIds);
		}
		return BaseResponseGenerator.genSuccessResult(null);
	}

	@ApiOperation("根据用户id删除用户轨迹")
	@PostMapping("remove")
	public BaseResponse remove() {
		deviceApi.removeUserRunPointByUserId(getUser().getUserId());
		return BaseResponseGenerator.genSuccessResult(null);
	}
}
