/**
 * Project Name:SOCO_Report
 * File Name:Test.java
 * Package Name:com.soco.car.report.index
 * Date:2018年6月21日下午2:37:12
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.index;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

/**
 * ClassName:Test <br/>
 * Reason: 设备轨迹索引N. <br/>
 * Date: 2018年6月21日 下午2:37:12 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Document(indexName = "soco", type = "trail_device")
public class TrailDeviceIndex implements Serializable {

	private static final long serialVersionUID = 6738492532943076580L;

	/**
	 * 设备号唯一键
	 */
	@Id
	private String deviceNo;

	@GeoPointField
	private GeoPoint geo;
	/**
	 * 续航
	 */
	private Integer endurance;
	/**
	 * 电量
	 */
	private Integer nowElec;
	/**
	 * 上锁状态 1上锁 0解锁
	 */
	private Integer lock;
	/**
	 * 是否骑行 1：骑行 0：未骑行
	 */
	private Integer isStartup;
	/**
	 * 骑行的用户
	 */
	private Integer userId;
	/**
	 * gsm信号
	 */
	private Integer gsm;
	/**
	 * 索引创建时间
	 */
	private Date createTime;
	/**
	 * 索引更新时间
	 */
	private Date modifyTime;
	/**
	 * 轨迹产生的时间 使用轨迹创建的时间
	 */
	private Date trailTime;

	/**
	 * 国家
	 */
	@Field(type = FieldType.Keyword)
	private String country;
	/**
	 * 省份
	 */
	@Field(type = FieldType.Keyword)
	private String province;
	/**
	 * 城市
	 */
	@Field(type = FieldType.Keyword)
	private String city;
	/**
	 * 地区
	 */
	@Field(type = FieldType.Keyword)
	private String district;
	/**
	 * 车型分类
	 */
	@Field(type = FieldType.Keyword)
	private String carType;

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public GeoPoint getGeo() {
		return geo;
	}

	public void setGeo(GeoPoint geo) {
		this.geo = geo;
	}

	public Integer getEndurance() {
		return endurance;
	}

	public void setEndurance(Integer endurance) {
		this.endurance = endurance;
	}

	public Integer getNowElec() {
		return nowElec;
	}

	public void setNowElec(Integer nowElec) {
		this.nowElec = nowElec;
	}

	public Integer getLock() {
		return lock;
	}

	public void setLock(Integer lock) {
		this.lock = lock;
	}

	public Integer getIsStartup() {
		return isStartup;
	}

	public void setIsStartup(Integer isStartup) {
		this.isStartup = isStartup;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGsm() {
		return gsm;
	}

	public void setGsm(Integer gsm) {
		this.gsm = gsm;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getTrailTime() {
		return trailTime;
	}

	public void setTrailTime(Date trailTime) {
		this.trailTime = trailTime;
	}

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

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TrailDeviceIndex [deviceNo=");
		builder.append(deviceNo);
		builder.append(", geo=");
		builder.append(geo);
		builder.append(", endurance=");
		builder.append(endurance);
		builder.append(", nowElec=");
		builder.append(nowElec);
		builder.append(", lock=");
		builder.append(lock);
		builder.append(", isStartup=");
		builder.append(isStartup);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", gsm=");
		builder.append(gsm);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", modifyTime=");
		builder.append(modifyTime);
		builder.append(", trailTime=");
		builder.append(trailTime);
		builder.append(", country=");
		builder.append(country);
		builder.append(", province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", district=");
		builder.append(district);
		builder.append(", carType=");
		builder.append(carType);
		builder.append("]");
		return builder.toString();
	}

}
