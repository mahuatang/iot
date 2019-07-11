/**
 * Project Name:SOCO_IOT
 * File Name:LoginMsg.java
 * Package Name:com.soco.car.iot.message.car
 * Date:2018年7月10日下午9:15:54
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.msg;

import java.util.Arrays;
import java.util.Date;

import com.soco.car.iot.server.car.message.Base7878Msg;

/**
 * ClassName:LoginMsg <br/>
 * Reason: GPS消息包 <br/>
 * Date: 2018年7月10日 下午9:15:54 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class GpsMsg extends Base7878Msg {

	private static final long serialVersionUID = -2763916744203816271L;
	/**
	 * 日期与时间
	 */
	private Date date;
	/**
	 * gps卫星数
	 */
	private byte gps;
	/**
	 * 纬度
	 */
	private Double latitude;
	/**
	 * 经度
	 */
	private Double longitude;
	/**
	 * 速度
	 */
	private byte sleep;
	/**
	 * 航向及状态
	 */
	private byte[] orientationState;
	/**
	 * 国家代号
	 */
	private Short mcc;
	/**
	 * 移动网号码
	 */
	private byte mnc;
	/**
	 * 位置区码
	 */
	private Short lac;
	/**
	 * 移动基站
	 */
	private String cellId;
	/**
	 * acc
	 */
	private byte acc;
	/**
	 * 数据上报模式 0x00 定时上报 0x01 定距上报 0x02 拐点上传 0x03 ACC 状态改变上传 0x04
	 * 从运动变为静止状态后，补传最后一个定位点 0x05 网络断开重连后，上报之前最后一个有效上传点 0X06 上报模式：星历更新强制上传 GPS 点 0X07
	 * 上报模式：按键上传定位点 0X08 上报模式：开机上报位置信息 0X09 上报模式：未使用 0X0A 上报模式：设备静止后上报最后的经纬度，但时间更新
	 * 0X0B WIFI 解析经纬度上传包 0X0C 上报模式： LJDW（立即定位）指令上报 0X0D 上报模式：设备静止后上报最后的经纬度 0X0E
	 * 上报模式： GPSDUP 上传（下静止状态定时上传）
	 */
	private byte dataReportModel;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte getGps() {
		return gps;
	}

	public void setGps(byte gps) {
		this.gps = gps;
	}

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

	public byte getSleep() {
		return sleep;
	}

	public void setSleep(byte sleep) {
		this.sleep = sleep;
	}

	public byte[] getOrientationState() {
		return orientationState;
	}

	public void setOrientationState(byte[] orientationState) {
		this.orientationState = orientationState;
	}

	public Short getMcc() {
		return mcc;
	}

	public void setMcc(Short mcc) {
		this.mcc = mcc;
	}

	public byte getMnc() {
		return mnc;
	}

	public void setMnc(byte mnc) {
		this.mnc = mnc;
	}

	public Short getLac() {
		return lac;
	}

	public void setLac(Short lac) {
		this.lac = lac;
	}

	public String getCellId() {
		return cellId;
	}

	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	public byte getAcc() {
		return acc;
	}

	public void setAcc(byte acc) {
		this.acc = acc;
	}

	public byte getDataReportModel() {
		return dataReportModel;
	}

	public void setDataReportModel(byte dataReportModel) {
		this.dataReportModel = dataReportModel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GpsMsg [");
		if (date != null) {
			builder.append("date=");
			builder.append(date);
			builder.append(", ");
		}
		builder.append("gps=");
		builder.append(gps);
		builder.append(", ");
		if (latitude != null) {
			builder.append("latitude=");
			builder.append(latitude);
			builder.append(", ");
		}
		if (longitude != null) {
			builder.append("longitude=");
			builder.append(longitude);
			builder.append(", ");
		}
		builder.append("sleep=");
		builder.append(sleep);
		builder.append(", ");
		if (orientationState != null) {
			builder.append("orientationState=");
			builder.append(Arrays.toString(orientationState));
			builder.append(", ");
		}
		if (mcc != null) {
			builder.append("mcc=");
			builder.append(mcc);
			builder.append(", ");
		}
		builder.append("mnc=");
		builder.append(mnc);
		builder.append(", ");
		if (lac != null) {
			builder.append("lac=");
			builder.append(lac);
			builder.append(", ");
		}
		if (cellId != null) {
			builder.append("cellId=");
			builder.append(cellId);
			builder.append(", ");
		}
		builder.append("acc=");
		builder.append(acc);
		builder.append(", dataReportModel=");
		builder.append(dataReportModel);
		builder.append(", ");
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}
		builder.append("]");
		return builder.toString();
	}


}
