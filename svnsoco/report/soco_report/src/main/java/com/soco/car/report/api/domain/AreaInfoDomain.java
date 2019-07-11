/**
 * Project Name:SOCO_Report
 * File Name:AreaInfoDomain.java
 * Package Name:com.soco.car.report.api.domain
 * Date:2018年6月25日下午2:38:06
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.api.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ClassName:AreaInfoDomain <br/>
 * Reason: 各个区域详情 <br/>
 * Date: 2018年6月25日 下午2:38:06 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@ApiModel(description = "车俩区域内详情")
public class AreaInfoDomain implements Serializable {

	private static final long serialVersionUID = -7250482481900267729L;

	/**
	 * 纬度
	 */
	@ApiModelProperty(value="纬度")
	private Double latitude;
	/**
	 * 经度
	 */
	@ApiModelProperty(value="经度")
	private Double longitude;
	/**
	 * 总数
	 */
	@ApiModelProperty(value="总数")
	private Long size;
	/**
	 * 名称
	 */
	@ApiModelProperty(value="区域名称")
	private String areaName;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AreaInfoDomain [latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", size=");
		builder.append(size);
		builder.append(", areaName=");
		builder.append(areaName);
		builder.append("]");
		return builder.toString();
	}


}
