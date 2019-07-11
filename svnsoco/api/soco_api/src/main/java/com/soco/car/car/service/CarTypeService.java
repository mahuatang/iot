/**
 * Project Name:SOCO_API
 * File Name:CarTypeService.java
 * Package Name:com.soco.car.car.service
 * Date:2018年6月13日下午5:16:10
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.car.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soco.car.car.api.CarTypeApi;
import com.soco.car.car.dao.CarTypeMapper;
import com.soco.car.car.entity.CarType;
import com.soco.car.car.entity.CarTypeExample;
import com.soco.car.common.dsl.DataSourceKey;
import com.soco.car.common.dsl.TargetDataSource;

/**
 * ClassName:CarTypeService <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月13日 下午5:16:10 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service(interfaceClass = CarTypeApi.class)
public class CarTypeService implements CarTypeApi {

	private static final Logger logger = LoggerFactory.getLogger(CarTypeService.class);

	@Autowired
	private CarTypeMapper carTypeMapper;

	@TargetDataSource(dataSourceKey = DataSourceKey.MASTER)
	@Transactional
	public void save(CarType carType) {
		String carTypeCode = carType.getCarTypeCode();
		CarType c = carTypeMapper.selectByPrimaryKey(carTypeCode);
		if (c == null) {
			carType.setCreateTime(new Date());
			carTypeMapper.insertSelective(carType);
		} else {
			carType.setUpdateTime(new Date());
			carTypeMapper.updateByPrimaryKeySelective(carType);
		}
	}

	@Override
	public PageInfo<CarType> findByPage(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
//		PageInfo<CarType> result=new PageInfo<CarType>(carTypeMapper.findByPage());
		CarTypeExample example=new CarTypeExample();
		PageInfo<CarType> reuslt=new PageInfo<CarType>(carTypeMapper.selectByExample(example));
		return reuslt;
	}

	@Override
	public List<CarType> findAll() {
		CarTypeExample example=new CarTypeExample();
		return carTypeMapper.selectByExample(example);
	}

	@Override
	public CarType findByKey(String carTypeCode) {
		return carTypeMapper.selectByPrimaryKey(carTypeCode);
	}

	@Override
	public List<String> findChildAll() {
		return carTypeMapper.findChildAll();
	}
	@Override
	public CarType findByDeviceNo(String deviceNo) {
		return carTypeMapper.findByDeviceNo(deviceNo);
	}
}
