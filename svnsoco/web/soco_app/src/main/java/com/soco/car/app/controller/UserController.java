/**
 * Project Name:SOCO_APP
 * File Name:UserController.java
 * Package Name:com.soco.car.app.controller
 * Date:2018年7月25日下午2:13:13
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soco.car.app.annotation.SerializedField;
import com.soco.car.app.api.request.UserDataRequest;
import com.soco.car.app.api.response.BaseResponse;
import com.soco.car.app.handler.BaseResponseGenerator;
import com.soco.car.app.service.UserService;

import io.swagger.annotations.Api;

/**
 * ClassName:UserController <br/>
 * Reason: 用户相关处理模块. <br/>
 * Date: 2018年7月25日 下午2:13:13 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@RestController
@RequestMapping(value = "/rest/v1/user")
@Api(value = "/rest/v1/user", tags = { "用户相关接口服务" })
public class UserController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

<<<<<<< .mine
	@ApiOperation("获取用户登录信息")
=======
	@SerializedField(excludes= {"password"})
>>>>>>> .r119
	@PostMapping("get")
	public BaseResponse get() {
		return BaseResponseGenerator.genSuccessResult(userService.getUserBindDevice(getUser()));
	}

	/**
	 * 
	 * refresh: 只有登录情况下刷新token才有效
	 *
	 * @author sunlangping
	 * @return
	 */
	@ApiOperation("刷新Token,只有登录情况下刷新token才有效")
	@PostMapping("refresh")
	public BaseResponse refresh() {
		return userService.refresh(getUser());
	}

	/**
	 * 
	 * loginout:退出登录
	 *
	 * @author sunlangping
	 * @return
	 */
	@ApiOperation("退出登录")
	@PostMapping("logout")
	public BaseResponse logout() {
		return userService.logout(getUser());
	}

	/**
	 * 
	 * moidfy:
	 *
	 * @author sunlangping
	 * @param userDataRequest
	 * @return
	 */
<<<<<<< .mine
	@ApiOperation("更新用户资料")
	@PostMapping("moidfy")
	public BaseResponse moidfy(@RequestBody UserDataRequest userDataRequest) {
		return userService.moidfyUser(getUser(), userDataRequest);
=======
	@PostMapping("modify")
	public BaseResponse modify(@RequestBody UserDataRequest userDataRequest) {
		return userService.modifyUser(getUser(), userDataRequest);
>>>>>>> .r119
	}

}
