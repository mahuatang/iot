/**
 * Project Name:SOCO_IOT
 * File Name:LoginMsg.java
 * Package Name:com.soco.car.iot.message.car
 * Date:2018年7月10日下午9:15:54
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.msg;

import java.util.Arrays;

import com.soco.car.iot.server.car.message.Base7878Msg;

/**
 * ClassName:LoginMsg <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月10日 下午9:15:54 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class LoginMsg extends Base7878Msg {

	private static final long serialVersionUID = -2421817783475269303L;
	/**
	 * 设备号
	 */
	private String deviceNo;
	/**
	 * 设备类型
	 */
	private Short deviceType;

	/**
	 * 时区语言
	 */
	private Short timezone;

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public Short getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Short deviceType) {
		this.deviceType = deviceType;
	}

	public Short getTimezone() {
		return timezone;
	}

	public void setTimezone(Short timezone) {
		this.timezone = timezone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginMsg [");
		if (deviceNo != null) {
			builder.append("deviceNo=");
			builder.append(deviceNo);
			builder.append(", ");
		}
		if (deviceType != null) {
			builder.append("deviceType=");
			builder.append(deviceType);
			builder.append(", ");
		}
		if (timezone != null) {
			builder.append("timezone=");
			builder.append(timezone);
			builder.append(", ");
		}
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}
		builder.append("]");
		return builder.toString();
	}

}
