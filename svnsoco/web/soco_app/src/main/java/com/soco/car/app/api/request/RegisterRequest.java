/**
 * Project Name:SOCO_APP
 * File Name:RegisterRequest.java
 * Package Name:com.soco.car.app.api.request
 * Date:2018年7月24日下午8:25:03
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.api.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ClassName:RegisterRequest <br/>
 * Reason: 注册请求 <br/>
 * Date: 2018年7月24日 下午8:25:03 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@ApiModel(value = "注册请求详情")
public class RegisterRequest implements Serializable {

	private static final long serialVersionUID = -1461169188354765768L;

	@ApiModelProperty(value = "国家代码", required = true, example = "CN")
	private String countryCode;

	@ApiModelProperty(value = "手机号码代码", required = true, example = "86")
	private String phoneCode;

	@ApiModelProperty(value = "用户邮箱", required = true, example = "1234567890@qq.com")
	private String email;

	@ApiModelProperty(value = "短信验证码", required = true, example = "123456")
	private String verificationCode;

	@ApiModelProperty(value = "手机号码", required = true, example = "17602109468")
	private String phone;
	
	@ApiModelProperty(value = "密码", required = true, example = "123456")
	private String password;

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterRequest [");
		if (countryCode != null) {
			builder.append("countryCode=");
			builder.append(countryCode);
			builder.append(", ");
		}
		if (phoneCode != null) {
			builder.append("phoneCode=");
			builder.append(phoneCode);
			builder.append(", ");
		}
		if (email != null) {
			builder.append("email=");
			builder.append(email);
			builder.append(", ");
		}
		if (verificationCode != null) {
			builder.append("verificationCode=");
			builder.append(verificationCode);
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
		}
		builder.append("]");
		return builder.toString();
	}

}
