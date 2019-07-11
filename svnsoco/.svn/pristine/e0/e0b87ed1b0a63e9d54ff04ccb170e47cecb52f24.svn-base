/**
 * Project Name:soco_iot
 * File Name:BaseResponse.java
 * Package Name:com.soco.car.iot.server.app.message.response
 * Date:2018年8月8日下午9:15:19
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.app.message.response;

import java.io.Serializable;

/**
 * ClassName:BaseResponse <br/>
 * Reason: tcp详情结果 <br/>
 * Date: 2018年8月8日 下午9:15:19 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class BaseResponseMsg<T> implements Serializable {

	private static final long serialVersionUID = -2114220766450351785L;

	/**
	 * 返回代码
	 */
	private String status;
	/**
	 * 返回描述
	 */
	private String message;
	/**
	 * 响应给前端的数据
	 */
	private T data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseResponse [");
		if (status != null) {
			builder.append("status=");
			builder.append(status);
			builder.append(", ");
		}
		if (message != null) {
			builder.append("message=");
			builder.append(message);
			builder.append(", ");
		}
		if (data != null) {
			builder.append("data=");
			builder.append(data);
		}
		builder.append("]");
		return builder.toString();
	}

}
