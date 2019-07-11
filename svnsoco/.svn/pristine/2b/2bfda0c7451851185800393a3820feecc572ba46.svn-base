/**
 * Project Name:soco_app
 * File Name:SetPasswordRequest.java
 * Package Name:com.soco.car.app.api.request
 * Date:2018年8月17日上午11:28:22
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.api.request;
/**
 * ClassName:SetPasswordRequest <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年8月17日 上午11:28:22 <br/>
 * @author   sunlangping
 * @version  
 * @see 	 
 */

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SetPasswordRequest implements Serializable{
	
	private static final long serialVersionUID = -8689124361136028317L;

	@ApiModelProperty(value = "手机号码代码", required = true, example = "86")
	private String phoneCode;
	
	@ApiModelProperty(value = "手机号码", required = true, example = "17602109468")
	private String phone;
	
	@ApiModelProperty(value = "密码", required = true, example = "123456")
	private String password;
	
	@ApiModelProperty(value = "短信验证码", required = true, example = "123456")
	private String verificationCode;

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SetPasswordRequest [");
		if (phoneCode != null) {
			builder.append("phoneCode=");
			builder.append(phoneCode);
			builder.append(", ");
		}
		if (phone != null) {
			builder.append("phone=");
			builder.append(phone);
			builder.append(", ");
		}
		if (password != null) {
			builder.append("password=");
			builder.append(password);
			builder.append(", ");
		}
		if (verificationCode != null) {
			builder.append("verificationCode=");
			builder.append(verificationCode);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}

