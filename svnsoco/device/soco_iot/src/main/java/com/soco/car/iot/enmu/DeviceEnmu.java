/**
 * Project Name:SOCO_IOT
 * File Name:DeviceEnmu.java
 * Package Name:com.soco.car.iot.enmu
 * Date:2018年7月9日上午3:45:17
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.enmu;

/**
 * ClassName:DeviceEnmu <br/>
 * Reason: 车调用方法枚举类. <br/>
 * Date: 2018年7月9日 上午3:45:17 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public enum DeviceEnmu {
	
	/**
	 * 上传一次车辆状态 79 79 透传  2c c2
	 */
	uploadCarStatus("uploadCarStatus");

	private DeviceEnmu(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
