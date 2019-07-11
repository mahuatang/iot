/**
 * Project Name:SOCO_Report
 * File Name:AddressComponentDomain.java
 * Package Name:com.soco.car.report.api.domain
 * Date:2018年6月22日下午4:25:59
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.api.domain;

import java.io.Serializable;

/**
 * ClassName:AddressComponentDomain <br/>
 * Reason: 地址组成的详情. <br/>
 * Date: 2018年6月22日 下午4:25:59 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class AddressComponentDomain implements Serializable{
	
	private static final long serialVersionUID = -3201661445285908073L;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 地区
	 */
	private String district;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddressComponentDomain [country=");
		builder.append(country);
		builder.append(", province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", district=");
		builder.append(district);
		builder.append("]");
		return builder.toString();
	}
	
	
}
