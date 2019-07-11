/**
 * Project Name:SOCO_Report
 * File Name:BaseResponse.java
 * Package Name:com.soco.car.report.api.response
 * Date:2018年6月22日上午10:08:37
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.api.response;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;

/**
 * ClassName:BaseResponse <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月22日 上午10:08:37 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@ApiModel(description = "返回响应数据")
public class BaseResponse<T> implements Serializable {

	private static final long serialVersionUID = -2890457021495215848L;
	/**
	 * 返回代码
	 */
	@ApiModelProperty(value = "状态码")
	private String status;
	/**
	 * 返回描述
	 */
	@ApiModelProperty(value = "返回描述")
	private String message;

	@ApiModelProperty(value = "返回的数据")
	private T data;

	public BaseResponse() {
		super();
	}

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

	public BaseResponse(String status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public static <T> BaseResponse<T> newInstance() {
		return new BaseResponse<>();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseResponse [status=");
		builder.append(status);
		builder.append(", message=");
		builder.append(message);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}

}
