/**
 * Project Name:SOCO_APP
 * File Name:LoginRequest.java
 * Package Name:com.soco.car.app.api.request
 * Date:2018年7月24日下午7:32:12
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.api.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ClassName:LoginRequest <br/>
 * Reason: 登录请求相关 <br/>
 * Date: 2018年7月24日 下午7:32:12 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@ApiModel(value = "登录请求详情")
public class MobileLoginRequest implements Serializable {

	private static final long serialVersionUID = 3115190446703525711L;
	/**
	 * 手机代码
	 */
	@ApiModelProperty(value = "手机代码", required = true, example = "86")
	private String phoneCode;
	/**
	 * 手机号码
	 */
	@ApiModelProperty(value = "手机号码", required = true, example = "17602109468")
	private String phone;
	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码", required = true, example = "123456")
	private String password;
	
	@ApiModelProperty(value = "纬度", required = true, example = "31.00")
	private Double lat;
	
	@ApiModelProperty(value = "经度", required = true, example = "131.00")
	private Double lng;
	/**
     * 手机的唯一标识
     */
	@ApiModelProperty(value = "手机的唯一标识MAC地址等", required = true, example = "a123456789")
    private String phoneToken;

    /**
     * 手机型号
     */
	@ApiModelProperty(value = "手机型号", required = true, example = "HUAWEI Meta")
    private String phoneType;

    /**
     * 系统类型android或IOS
     */
	@ApiModelProperty(value = "手机型号", required = true, example = "android")
    private String systemName;

    /**
     * 系统版本
     */
	@ApiModelProperty(value = "系统版本", required = true, example = "8.0.0")
    private String version;

    /**
     * 应用版本名称
     */
	@ApiModelProperty(value = "应用版本名称", required = true, example = "3.3.0")
    private String versionName;

    /**
     * 应用版本号
     */
	@ApiModelProperty(value = "应用版本内部版本号", required = true, example = "26")
    private String versionNo;

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

	public String getPhoneToken() {
		return phoneToken;
	}

	public void setPhoneToken(String phoneToken) {
		this.phoneToken = phoneToken;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileLoginRequest [");
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
		if (lat != null) {
			builder.append("lat=");
			builder.append(lat);
			builder.append(", ");
		}
		if (lng != null) {
			builder.append("lng=");
			builder.append(lng);
			builder.append(", ");
		}
		if (phoneToken != null) {
			builder.append("phoneToken=");
			builder.append(phoneToken);
			builder.append(", ");
		}
		if (phoneType != null) {
			builder.append("phoneType=");
			builder.append(phoneType);
			builder.append(", ");
		}
		if (systemName != null) {
			builder.append("systemName=");
			builder.append(systemName);
			builder.append(", ");
		}
		if (version != null) {
			builder.append("version=");
			builder.append(version);
			builder.append(", ");
		}
		if (versionName != null) {
			builder.append("versionName=");
			builder.append(versionName);
			builder.append(", ");
		}
		if (versionNo != null) {
			builder.append("versionNo=");
			builder.append(versionNo);
		}
		builder.append("]");
		return builder.toString();
	}
    
}
