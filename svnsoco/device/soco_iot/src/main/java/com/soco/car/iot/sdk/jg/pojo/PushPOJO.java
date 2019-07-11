/**
 * Project Name:soco_iot
 * File Name:PushPOJO.java
 * Package Name:com.soco.car.iot.sdk.jg.pojo
 * Date:2018年8月11日下午7:27:23
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.sdk.jg.pojo;

import java.io.Serializable;

/**
 * ClassName:PushPOJO <br/>
 * Reason: 推送对象 <br/>
 * Date: 2018年8月11日 下午7:27:23 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class PushPOJO implements Serializable {

	private static final long serialVersionUID = 4786933383804912327L;
	/**
	 * 系统版本
	 */
	private String systemName;
	/**
	 * 推送人标识
	 */
	private Long audience;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 设备号
	 */
	private String deviceNo;
	/**
	 * 是否推送推送,1推送 0不推送
	 */
	private Integer isWarnPush;
	

	public Long getAudience() {
		return audience;
	}

	public void setAudience(Long audience) {
		this.audience = audience;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public Integer getIsWarnPush() {
		return isWarnPush;
	}

	public void setIsWarnPush(Integer isWarnPush) {
		this.isWarnPush = isWarnPush;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PushPOJO [");
		if (systemName != null) {
			builder.append("systemName=");
			builder.append(systemName);
			builder.append(", ");
		}
		if (audience != null) {
			builder.append("audience=");
			builder.append(audience);
			builder.append(", ");
		}
		if (title != null) {
			builder.append("title=");
			builder.append(title);
			builder.append(", ");
		}
		if (content != null) {
			builder.append("content=");
			builder.append(content);
			builder.append(", ");
		}
		if (deviceNo != null) {
			builder.append("deviceNo=");
			builder.append(deviceNo);
		}
		builder.append("]");
		return builder.toString();
	}

}
