/**
 * Project Name:soco_app
 * File Name:UserDataRequest.java
 * Package Name:com.soco.car.app.api.request
 * Date:2018年8月1日下午1:53:56
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.api.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * ClassName:UserDataRequest <br/>
 * Reason: 用户资料请求对象 <br/>
 * Date: 2018年8月1日 下午1:53:56 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class UserDataRequest implements Serializable {

	private static final long serialVersionUID = -131917790482025221L;

	@ApiModelProperty(value = "用户头像", required = true, example = "/***/***/****/***.jpg")
	private String userAvatar;

	@ApiModelProperty(value = "昵称", required = true, example = "SOCO")
	private String userName;

	@ApiModelProperty(value = "性别", required = true, notes = "1男,0女", example = "1")
	private Integer sex;

	@ApiModelProperty(value = "行业", required = true, example = "自由职业")
	private String industry;

	@ApiModelProperty(value = "个性签名", required = true, example = "骑行天下！！！")
	private String userDesc;
	
	@ApiModelProperty(value = "用户地址", required = true, example = "上海市青浦区移动智地")
	private String address;
	
	@ApiModelProperty(value = "邮箱", required = true, example = "sun_lp@supersoco.com")
	private String email;

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDataRequest [");
		if (userAvatar != null) {
			builder.append("userAvatar=");
			builder.append(userAvatar);
			builder.append(", ");
		}
		if (userName != null) {
			builder.append("userName=");
			builder.append(userName);
			builder.append(", ");
		}
		if (sex != null) {
			builder.append("sex=");
			builder.append(sex);
			builder.append(", ");
		}
		if (industry != null) {
			builder.append("industry=");
			builder.append(industry);
			builder.append(", ");
		}
		if (userDesc != null) {
			builder.append("userDesc=");
			builder.append(userDesc);
			builder.append(", ");
		}
		if (address != null) {
			builder.append("address=");
			builder.append(address);
			builder.append(", ");
		}
		if (email != null) {
			builder.append("email=");
			builder.append(email);
		}
		builder.append("]");
		return builder.toString();
	}

}
