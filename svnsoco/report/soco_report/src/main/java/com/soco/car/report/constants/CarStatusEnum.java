/**
 * Project Name:SOCO_Report
 * File Name:CarStatusEnum.java
 * Package Name:com.soco.car.report.constants
 * Date:2018年7月6日下午4:05:54
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.constants;

/**
 * ClassName:CarStatusEnum <br/>
 * Reason: 车俩状态枚举 <br/>
 * Date: 2018年7月6日 下午4:05:54 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public enum CarStatusEnum {
	/**
	 * ts车不在线
	 */
	car_ts_offline(0),
	/**
	 * ts车在线
	 */
	car_ts_online(1), 
	/**
	 * tc车不在线
	 */
	car_tc_offline(2), 
	/**
	 * tc车在线
	 */
	car_tc_online(3), 
	/**
	 * cu车不在线
	 */
	car_cu_offline(4), 
	/**
	 * cu车在线
	 */
	car_cu_online(5);
	
	private Integer value;

	private CarStatusEnum(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
}
