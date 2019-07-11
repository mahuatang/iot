/**
 * Project Name:SOCO_API
 * File Name:UserServiceTest.java
 * Package Name:com.soco.car.user.service
 * Date:2018年7月24日上午11:34:40
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.user.service;

import java.util.List;

import com.soco.car.user.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.soco.car.base.BaseTest;
import com.soco.car.user.entity.UserRunPoint;

/**
 * ClassName:UserServiceTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月24日 上午11:34:40 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class UserServiceTest extends BaseTest {

	@Autowired
	private UserService userService;

	@Test
	public void testFindByAccount() throws Exception {
		String account = "86";
		User user = userService.findByAccount(account);
		System.out.println(user);
	}

	@Test
	public void testFindRunHistryList() throws Exception {
		Long userId = 123l;
		PageInfo<UserRunPoint> result = userService.findRunHistryList(userId, 1, 10);
		List<UserRunPoint> list = result.getList();
		list.forEach(l -> {
			System.out.println(l);
		});
	}

	@Test
	public void testFindByDeviceNo() throws Exception {
		String deviceNo = "865067021512622";
		User user = userService.findBindByDeviceNo(deviceNo);
		System.out.println(user);
	}

}
