/**
 * Project Name:SOCO_API
 * File Name:CarTypeMappingApi.java
 * Package Name:com.soco.car.car.api
 * Date:2018年6月14日上午10:31:04
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.car.api;
/**
 * ClassName:CarTypeMappingApi <br/>
 * Reason:	 车型映射关系接口 <br/>
 * Date:     2018年6月14日 上午10:31:04 <br/>
 * @author   sunlangping
 * @version  
 * @see 	 
 */

import java.util.List;

import com.soco.car.car.entity.CarTypeMapping;

public interface CarTypeMappingApi {

	public List<CarTypeMapping> findByCarTypeCode(String carTypeCode);

	/**
	 * 
	 * batchSave: 批量插入数据
	 *
	 * @author sunlangping
	 * @param carTypeCode
	 *            TODO
	 * @param carTypeMappingList
	 */
	public void batchSave(String carTypeCode, List<CarTypeMapping> carTypeMappingList);

}
