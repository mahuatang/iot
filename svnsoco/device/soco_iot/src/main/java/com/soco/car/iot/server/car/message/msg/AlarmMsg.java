/**
 * Project Name:soco_iot
 * File Name:AlarmMsg.java
 * Package Name:com.soco.car.iot.message.car.msg
 * Date:2018年8月4日上午2:13:55
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.msg;

import java.util.Arrays;
import java.util.Date;

import com.soco.car.iot.server.car.message.Base7878Msg;

/**
 * ClassName:AlarmMsg <br/>
 * Reason: 报警包 <br/>
 * Date: 2018年8月4日 上午2:13:55 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class AlarmMsg extends Base7878Msg {

	/**
	 * 报警时间
	 */
	private Date alarmDate;
	/**
	 * GPS卫星数量
	 */
	private byte gpsCount;
	/**
	 * 纬度
	 */
	private double latitude;
	/**
	 * 经度
	 */
	private double longitude;
	/**
	 * 速度
	 */
	private byte speed;
	/**
	 * 航向、方向
	 */
	private byte[] orientation;
	/**
	 * LBS长度
	 */
	private byte lbsLength;
	/**
	 * 国家代码
	 */
	private short mcc;
	/**
	 * 移动网号码
	 */
	private byte mnc;
	/**
	 * 位置区码
	 */
	private short lac;
	/**
	 * 移动基站
	 */
	private String cellId;
	/**
	 * 终端信息
	 */
	private byte terminal;
	/**
	 * 电压等级
	 */
	private byte voltageLevel;
	/**
	 * GSM等级
	 */
	private byte gsmLevel;
	/**
	 * 报警与语言
	 */
	private byte[] alarmLanguge;


	public Date getAlarmDate() {
		return alarmDate;
	}

	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}

	public byte getGpsCount() {
		return gpsCount;
	}

	public void setGpsCount(byte gpsCount) {
		this.gpsCount = gpsCount;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public byte getSpeed() {
		return speed;
	}

	public void setSpeed(byte speed) {
		this.speed = speed;
	}

	public byte[] getOrientation() {
		return orientation;
	}

	public void setOrientation(byte[] orientation) {
		this.orientation = orientation;
	}

	public byte getLbsLength() {
		return lbsLength;
	}

	public void setLbsLength(byte lbsLength) {
		this.lbsLength = lbsLength;
	}

	public short getMcc() {
		return mcc;
	}

	public void setMcc(short mcc) {
		this.mcc = mcc;
	}

	public byte getMnc() {
		return mnc;
	}

	public void setMnc(byte mnc) {
		this.mnc = mnc;
	}

	public short getLac() {
		return lac;
	}

	public void setLac(short lac) {
		this.lac = lac;
	}

	public String getCellId() {
		return cellId;
	}

	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	public byte getTerminal() {
		return terminal;
	}

	public void setTerminal(byte terminal) {
		this.terminal = terminal;
	}

	public byte getVoltageLevel() {
		return voltageLevel;
	}

	public void setVoltageLevel(byte voltageLevel) {
		this.voltageLevel = voltageLevel;
	}

	public byte getGsmLevel() {
		return gsmLevel;
	}

	public void setGsmLevel(byte gsmLevel) {
		this.gsmLevel = gsmLevel;
	}

	public byte[] getAlarmLanguge() {
		return alarmLanguge;
	}

	public void setAlarmLanguge(byte[] alarmLanguge) {
		this.alarmLanguge = alarmLanguge;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AlarmMsg [");
		if (alarmDate != null) {
			builder.append("alarmDate=");
			builder.append(alarmDate);
			builder.append(", ");
		}
		builder.append("gpsCount=");
		builder.append(gpsCount);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", speed=");
		builder.append(speed);
		builder.append(", ");
		if (orientation != null) {
			builder.append("orientation=");
			builder.append(Arrays.toString(orientation));
			builder.append(", ");
		}
		builder.append("lbsLength=");
		builder.append(lbsLength);
		builder.append(", mcc=");
		builder.append(mcc);
		builder.append(", mnc=");
		builder.append(mnc);
		builder.append(", lac=");
		builder.append(lac);
		builder.append(", ");
		if (cellId != null) {
			builder.append("cellId=");
			builder.append(cellId);
			builder.append(", ");
		}
		builder.append("terminal=");
		builder.append(terminal);
		builder.append(", voltageLevel=");
		builder.append(voltageLevel);
		builder.append(", gsmLevel=");
		builder.append(gsmLevel);
		builder.append(", ");
		if (alarmLanguge != null) {
			builder.append("alarmLanguge=");
			builder.append(Arrays.toString(alarmLanguge));
			builder.append(", ");
		}
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}
		builder.append("]");
		return builder.toString();
	}

}
