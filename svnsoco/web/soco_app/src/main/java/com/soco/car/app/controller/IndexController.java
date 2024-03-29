/**
 * Project Name:SOCO_Report
 * File Name:TrailDeviceSearchControll.java
 * Package Name:com.soco.car.report.controll
 * Date:2018年6月22日上午10:06:58
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.soco.car.app.annotation.SerializedField;
import com.soco.car.app.api.request.MobileLoginRequest;
import com.soco.car.app.api.request.RegisterRequest;
import com.soco.car.app.api.request.SetPasswordRequest;
import com.soco.car.app.api.response.BaseResponse;
import com.soco.car.app.handler.BaseResponseGenerator;
import com.soco.car.app.service.UserService;
import com.soco.car.user.api.SmsCountryApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

/**
 * ClassName:TrailDeviceSearchControll <br/>
 * Reason: APP入口相关接口服务. <br/>
 * Date: 2018年6月22日 上午10:06:58 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@RestController
@RequestMapping(value = "/rest/v1")
@Api(value = "/rest/v1", tags = { "登录相关接口服务" })
@Validated
public class IndexController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private UserService userService;

	@Reference
	private SmsCountryApi smsCountryApi;

	@ApiOperation("用户注册")
	@PostMapping("register")
	public BaseResponse register(@RequestBody RegisterRequest registerRequest) {
		return userService.register(registerRequest);
	}

	@ApiOperation("用户登录")
	@PostMapping("login")
	public BaseResponse login(@RequestBody MobileLoginRequest loginRequest) {
		return userService.login(loginRequest);
	}

	/**
	 * 
	 * sendRegisterCode: 发送注册验证码
	 *
	 * @author sunlangping
	 * @param countryCode
	 *            国家代码
	 * @param phone
	 *            手机号码
	 * @return
	 */
	@ApiOperation("发送注册验证码")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "phoneCode", value = "国家手机代码", required = true, dataType = "String", paramType = "path"),
			@ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "String", paramType = "path") })
	@PostMapping("sendRegisterCode/{phoneCode}/{phone}")
	public BaseResponse sendRegisterCode(@PathVariable String phoneCode, @PathVariable String phone) {
		return userService.sendRegisterCode(phoneCode, phone);
	}

	@ApiOperation("发送验证码修改密码")
	@PostMapping("sendModifyPasswordCode/{phoneCode}/{phone}")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "phoneCode", value = "国家手机代码", required = true, dataType = "String", paramType = "path"),
			@ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "String", paramType = "path") })
	public BaseResponse sendModifyPasswordCode(@PathVariable String phoneCode, @PathVariable String phone) {
		return userService.sendModifyPasswordCode(phoneCode, phone);
	}

	@ApiOperation("修改密码")
	@PostMapping("modifyPassword")
	public BaseResponse modifyPassword(@RequestBody RegisterRequest registerRequest) {
		return userService.modifyPassword(registerRequest);
	}

	/**
	 * 判断验证码是否正确
	 * 
	 * @param registerRequest
	 * @return
	 */
	@ApiOperation("检查验证码是否正确")
	@PostMapping("verifyCode")
	public BaseResponse verifyCode(@RequestBody RegisterRequest registerRequest) {
		return userService.verifyCode(registerRequest);
	}

	/**
	 * 更改用户密码，不作验证码校验
	 * 
	 * @param registerRequest
	 * @return
	 */
	@ApiOperation("设置密码")
	@PostMapping("setPassword")
	public BaseResponse setPassword(@RequestBody SetPasswordRequest setPasswordRequest) {
		return userService.modifyPasswordWithoutVerify(setPasswordRequest);
	}

	@ApiOperation("各个国家短信信息中详情")
	@PostMapping("countryList")
	@SerializedField(excludes = { "price" })
	public BaseResponse countryList() {
		return BaseResponseGenerator.genSuccessResult(smsCountryApi.findActiveCountry());
	}
}
