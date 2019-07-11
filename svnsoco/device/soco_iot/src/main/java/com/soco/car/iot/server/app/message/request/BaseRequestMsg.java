/**
 * Project Name:soco_iot
 * File Name:BaseJsonMsg.java
 * Package Name:com.soco.car.iot.server.app.message
 * Date:2018年8月8日下午3:36:31
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.app.message.request;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName:BaseJsonMsg <br/>
 * Reason: json转换类 <br/>
 * Date: 2018年8月8日 下午3:36:31 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class BaseRequestMsg implements Serializable {

	private static final long serialVersionUID = -4332060660732822656L;

	/**
	 * 消息类型
	 */
	private String msgType;
	/**
	 * 设备号（多设备情况下需处理,不推荐服务器端处理此类高并发数据）
	 */
	private String deviceNo;
	/**
	 * 消息创建时间
	 */
	private Date msgTime;
	
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public Date getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseJsonMsg [");
		if (msgType != null) {
			builder.append("msgType=");
			builder.append(msgType);
			builder.append(", ");
		}
		if (deviceNo != null) {
			builder.append("deviceNo=");
			builder.append(deviceNo);
			builder.append(", ");
		}
		if (msgTime != null) {
			builder.append("msgTime=");
			builder.append(msgTime);
		}
		builder.append("]");
		return builder.toString();
	}

}
