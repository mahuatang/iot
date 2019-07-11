/**
 * Project Name:SOCO_API
 * File Name:CarTypeMapperTest.java
 * Package Name:com.soco.car.car.dao
 * Date:2018年6月12日下午5:33:18
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.car.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soco.car.base.BaseTest;
import com.soco.car.car.entity.CarType;

/**
 * ClassName:CarTypeMapperTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月12日 下午5:33:18 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class CarTypeMapperTest extends BaseTest {

	@Autowired
	private CarTypeMapper carTypeMapper;

	@Test
	public void testInsertSelective() throws Exception {
		CarType carType = new CarType();
		carType.setCarTypeCode("testCode4");
		carType.setCreateTime(new Date());
		carType.setUpdateTime(new Date());
		carTypeMapper.insertSelective(carType);
	}

}
