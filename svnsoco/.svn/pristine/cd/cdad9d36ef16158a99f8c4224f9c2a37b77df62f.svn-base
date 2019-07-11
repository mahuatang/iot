/**
 * Project Name:SOCO_IOT
 * File Name:BaseMsg.java
 * Package Name:com.soco.car.iot.message
 * Date:2018年7月9日上午3:28:11
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message;
/**
 * ClassName:BaseMsg <br/>
 * Reason:	 所有类基础消息 <br/>
 * Date:     2018年7月9日 上午3:28:11 <br/>
 * @author   sunlangping
 * @version  
 * @see 	 
 */

import java.io.Serializable;
import java.util.Arrays;

import com.soco.car.iot.utils.Hex;

/**
 * 
 * ClassName: BaseMsg <br/>
 * Function: 所有消息的基础类 <br/>
 * date: 2018年7月9日 上午3:29:09 <br/>
 *
 * @author sunlangping
 * @version
 */
public class BaseMsg implements Serializable {

	private static final long serialVersionUID = 2889224488668672727L;
	/**
	 * 设备ID
	 */

	private String deviceNo;
	/**
	 * 消息类型
	 */
	private String msgType;
	/**
	 * 请求的token
	 */
	private String token;
	/**
	 * 请求的报文内容,校验位检查与日志记录需要用到
	 */
	private byte[] requestContent;
	/**
	 * 返回的报文内容,校验位检查与日志记录需要用到
	 */
	private byte[] responseContent;
	/**
	 * 是否有认证通过,默认全部认证通过.拦截器验证是否有认证,如果无认证则将hasAuth设置为false
	 */
	private Boolean hasAuth = true;

	public BaseMsg() {
		super();
	}

	public BaseMsg(Boolean hasAuth) {
		super();
		this.hasAuth = hasAuth;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public byte[] getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(byte[] requestContent) {
		this.requestContent = requestContent;
	}

	public byte[] getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(byte[] responseContent) {
		this.responseContent = responseContent;
	}

	public Boolean getHasAuth() {
		return hasAuth;
	}

	public void setHasAuth(Boolean hasAuth) {
		this.hasAuth = hasAuth;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseMsg [");
		if (deviceNo != null) {
			builder.append("deviceNo=");
			builder.append(deviceNo);
			builder.append(", ");
		}
		if (msgType != null) {
			builder.append("msgType=");
			builder.append(msgType);
			builder.append(", ");
		}
		if (token != null) {
			builder.append("token=");
			builder.append(token);
			builder.append(", ");
		}
		if (requestContent != null) {
			builder.append("requestContent=");
			builder.append(Hex.encodeHexStr(requestContent));
			builder.append(", ");
		}
		if (responseContent != null) {
			builder.append("responseContent=");
			builder.append(Hex.encodeHexStr(responseContent));
			builder.append(", ");
		}
		if (hasAuth != null) {
			builder.append("hasAuth=");
			builder.append(hasAuth);
		}
		builder.append("]");
		return builder.toString();
	}

}
