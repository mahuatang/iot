/**
 * Project Name:soco_api
 * File Name:UserbinddeviceServiceTest.java
 * Package Name:com.soco.car.user.service
 * Date:2018年8月9日下午7:45:31
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.user.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.soco.car.base.BaseTest;
import com.soco.car.device.entity.ext.DeviceBindExt;

/**
 * ClassName:UserbinddeviceServiceTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年8月9日 下午7:45:31 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class UserBindDeviceServiceTest extends BaseTest {

	@Autowired
	private UserbinddeviceService userBindDeviceService;

	@Test
	public void testCheckUserBindDevice() throws Exception {
		Long userId = 13483l;
		boolean flag = userBindDeviceService.checkUserBindDevice(userId);
		System.out.println(flag);
	}

	@Test
	public void testQueryUserBindDeviceByPage() throws Exception {
		Long userId = 13492l;
		int pageNum = 1;
		int pageSize = 10;
		PageInfo<DeviceBindExt> page = userBindDeviceService.queryUserBindDeviceByPage(userId, pageNum, pageSize);
		System.out.println(page);
		List<DeviceBindExt> list = page.getList();
		for (DeviceBindExt e : list) {
			System.out.println(e);
		}
	}

	@Test
	public void ak() throws Exception {
		Long userId = 13483l;
		String deviceNo = "865067021512622";
		userBindDeviceService.bindDevice(userId, deviceNo);
	}

	@Test
	public void testQueryDeviceInfoByUserId() throws Exception {
		Long userId = 13492l;
		DeviceBindExt ext = userBindDeviceService.queryDeviceInfoByUserId(userId);
		System.out.println(ext);
	}

}
