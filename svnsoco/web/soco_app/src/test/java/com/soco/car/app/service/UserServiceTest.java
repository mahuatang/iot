/**
 * Project Name:SOCO_APP
 * File Name:UserServiceTest.java
 * Package Name:com.soco.car.app.service
 * Date:2018年7月24日下午1:52:16
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.soco.car.app.api.request.MobileLoginRequest;
import com.soco.car.app.api.request.RegisterRequest;
import com.soco.car.app.base.BaseTest;

/**
 * ClassName:UserServiceTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月24日 下午1:52:16 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class UserServiceTest extends BaseTest {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void testRegister() throws Exception {
		String phone = "17602109468";
		RegisterRequest user = new RegisterRequest();
		user.setPhone(phone);
		System.out.println(userService.register(user));
	}

	@Test
	public void testLogin() throws Exception {
		String phone = "17602109468";
		MobileLoginRequest user = new MobileLoginRequest();
		user.setPhone(phone);
		user.setPassword("123456");
		System.out.println(userService.login(user));
	}

	@Test
	public void testSaveCodeCache() throws Exception {
	}

	@Test
	public void testModifyUser() throws Exception {
	}

}
