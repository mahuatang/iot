/**
 * Project Name:SOCO_IOT
 * File Name:AutoTimeMsg.java
 * Package Name:com.soco.car.iot.message.car.msg
 * Date:2018年7月16日下午8:56:21
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.msg;

import java.util.Arrays;
import java.util.Date;

import com.soco.car.iot.server.car.message.Base7878Msg;

/**
 * ClassName:AutoTimeMsg <br/>
 * Reason: 自动校时包. <br/>
 * Date: 2018年7月16日 下午8:56:21 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class AutoTimeMsg extends Base7878Msg {

	private static final long serialVersionUID = -5581498387845655988L;
	
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AutoTimeMsg [");
		if (date != null) {
			builder.append("date=");
			builder.append(date);
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
