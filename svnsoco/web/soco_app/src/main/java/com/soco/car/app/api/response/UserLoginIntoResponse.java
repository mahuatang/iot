/**
 * Project Name:soco_app
 * File Name:UserLoginIntoResponse.java
 * Package Name:com.soco.car.app.api.response
 * Date:2018年8月8日下午5:03:11
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.api.response;

import java.io.Serializable;

import com.soco.car.device.entity.Device;
import com.soco.car.device.entity.ext.DeviceBindExt;
import com.soco.car.user.entity.User;

/**
 * ClassName:UserLoginIntoResponse <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年8月8日 下午5:03:11 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class UserLoginIntoResponse implements Serializable {

	private static final long serialVersionUID = -6445344195440383585L;

	private String token;
	private User user;
	private DeviceBindExt device;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public DeviceBindExt getDevice() {
		return device;
	}

	public void setDevice(DeviceBindExt device) {
		this.device = device;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserLoginIntoResponse [");
		if (token != null) {
			builder.append("token=");
			builder.append(token);
			builder.append(", ");
		}
		if (user != null) {
			builder.append("user=");
			builder.append(user);
			builder.append(", ");
		}
		if (device != null) {
			builder.append("device=");
			builder.append(device);
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
