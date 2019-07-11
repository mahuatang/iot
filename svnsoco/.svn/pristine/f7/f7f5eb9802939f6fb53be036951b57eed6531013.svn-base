/**
 * Project Name:SOCO_Report
 * File Name:QueryNearByRequest.java
 * Package Name:com.soco.car.report.api.request
 * Date:2018年6月26日上午11:43:30
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.api.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * ClassName:QueryNearByRequest <br/>
 * Reason: 查询附近的车辆信息 <br/>
 * Date: 2018年6月26日 上午11:43:30 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class QueryNearByRequest extends BaseRequest implements Serializable {
	
	private static final long serialVersionUID = 8985754085513053748L;
	/**
	 * 纬度
	 */
	@ApiModelProperty(value = "纬度", required = true, example = "31.236176")
	private Double latitude;
	/**
	 * 经度
	 */
	@ApiModelProperty(value = "经度", readOnly = true, example = "121.471341")
	private Double longitude;
	/**
	 * 查询的距离
	 */
	@ApiModelProperty(value = "查询的距离单位米,非必传默认附近100KM", example = "100")
	private Double distance = 1000*100d;
	
	@ApiModelProperty(value = "查询最近××分钟数据,默认查询一个小时内数据", example = "60")
	private Integer minute;	

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

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Integer getMinute() {
		return minute;
	}

	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryNearByRequest [latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", distance=");
		builder.append(distance);
		builder.append("]");
		return builder.toString();
	}

}
