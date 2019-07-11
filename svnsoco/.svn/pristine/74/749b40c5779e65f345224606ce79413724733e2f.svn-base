/**
 * Project Name:SOCO_Report
 * File Name:GeoDomain.java
 * Package Name:com.soco.car.report.api.domain
 * Date:2018年6月22日上午10:38:17
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.api.domain;

import java.io.Serializable;
import java.util.Arrays;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ClassName:GeoDomain <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月22日 上午10:38:17 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@ApiModel(description = "经纬度详情")
public class GeoDomain implements Serializable {

	private static final long serialVersionUID = -3803463031967727000L;

	@ApiModelProperty(value = "经纬度数组")
	private String[] lnglat;
	@ApiModelProperty(value = "设备编号")
	private String deviceNo;

	@ApiModelProperty(value = "当前距离单位(米)")
	private Double distance;

	@ApiModelProperty(value = "是否骑行 1:骑行,0:未骑行")
	private Integer isStart;
	@ApiModelProperty(value = "当前车俩电量信息")
	private Integer nowElec;

	@ApiModelProperty(value = "车俩对应的样式信息 0:ts车不在线,1:ts车在线,2:tc车不在线,3:tc车在线,4:cu车不在线,5:cu车在线")
	private Integer style;

	public String[] getLnglat() {
		return lnglat;
	}

	public void setLnglat(String[] lnglat) {
		this.lnglat = lnglat;
	}

	//
	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Integer getIsStart() {
		return isStart;
	}

	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}

	public Integer getNowElec() {
		return nowElec;
	}

	public void setNowElec(Integer nowElec) {
		this.nowElec = nowElec;
	}

	public Integer getStyle() {
		return style;
	}

	public void setStyle(Integer style) {
		this.style = style;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeoDomain [lnglat=");
		builder.append(Arrays.toString(lnglat));
		builder.append(", deviceNo=");
		builder.append(deviceNo);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", isStart=");
		builder.append(isStart);
		builder.append(", nowElec=");
		builder.append(nowElec);
		builder.append("]");
		return builder.toString();
	}

}
