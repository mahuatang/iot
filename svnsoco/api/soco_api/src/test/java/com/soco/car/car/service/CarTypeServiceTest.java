/**
 * Project Name:SOCO_API
 * File Name:CarTypeServiceTest.java
 * Package Name:com.soco.car.car.service
 * Date:2018年6月13日下午5:18:51
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.car.service;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.soco.car.base.BaseTest;
import com.soco.car.car.api.CarTypeApi;
import com.soco.car.car.entity.CarType;

/**
 * ClassName:CarTypeServiceTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月13日 下午5:18:51 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class CarTypeServiceTest extends BaseTest {

	private static final Logger logger = LoggerFactory.getLogger(CarTypeServiceTest.class);

	@Autowired
	private CarTypeApi carTypeService;

	@Test
	public void testSave() throws Exception {
		CarType carType = new CarType();
		carType.setCarTypeCode("testCode1");
		carType.setCarTypeName("test111");
		try {
			carTypeService.save(carType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindByPage() throws Exception {
		PageInfo<CarType> result = carTypeService.findByPage(1, 10);
		List<CarType> list = result.getList();
		for (CarType c : list) {
			System.out.println(c);
		}

		System.out.println(result);
	}

	@Test
	public void testFindAll() throws Exception {
		List<CarType> list = carTypeService.findAll();
		System.out.println(list);
	}

	@Test
	public void testFindChildAll() throws Exception {
		List<String> list = carTypeService.findChildAll();
		System.out.println(list);
	}

	@Test
	public void testFindByDeviceNo() throws Exception {
		String deviceNo = "865067025347223";
		System.out.println(carTypeService.findByDeviceNo(deviceNo));
	}

}
