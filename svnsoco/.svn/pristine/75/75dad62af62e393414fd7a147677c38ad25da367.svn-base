/**
 * Project Name:SOCO_API
 * File Name:CarTypeApi.java
 * Package Name:com.soco.car.car.api
 * Date:2018年6月13日下午5:33:50
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.car.api;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.soco.car.car.entity.CarType;

/**
 * 
 * ClassName: CarTypeApi <br/>
 * Function: 车型管理接口 <br/>
 * date: 2018年6月13日 下午5:34:31 <br/>
 *
 * @author sunlangping
 * @version
 */
public interface CarTypeApi {

	public void save(CarType carType);

	public PageInfo<CarType> findByPage(int pageNo, int pageSize);

	public List<CarType> findAll();

	public CarType findByKey(String carTypeCode);

	/**
	 * 
	 * findChildAll:查询所有分类子类
	 *
	 * @author sunlangping
	 * @return
	 */
	public List<String> findChildAll();

	/**
	 * 
	 * findByDeviceNo:根据设备编号返回他的车型大类详情
	 *
	 * @author sunlangping
	 * @param deviceNo
	 * @return
	 */
	public CarType findByDeviceNo(String deviceNo);
}
