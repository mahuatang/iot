/**
 * Project Name:soco_iot
 * File Name:VehicleCheckupMsg.java
 * Package Name:com.soco.car.iot.message.car.msg
 * Date:2018年8月4日上午10:31:15
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.msg;

import java.util.Arrays;

import com.soco.car.iot.server.car.message.Base7979Msg;

/**
 * ClassName:VehicleCheckupMsg <br/>
 * Reason: 整车体检上传报文. <br/>
 * Date: 2018年8月4日 上午10:31:15 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class VehicleCheckupMsg extends Base7979Msg {

	private static final long serialVersionUID = 4538289508352417511L;
	/**
	 * 电池状态 8字节
	 */
	private byte[] batteryStatus;
	/**
	 * 控制器状态 2字节
	 */
	private byte[] controlStatus;
	/**
	 * 动力系统状态 7字节
	 */
	private byte[] dynamicalStatus;
	/**
	 * 显示系统 2字
	 */
	private byte[] viewStatus;
	/**
	 * 校验码
	 */
	private byte[] checkCode2cc2;
	/**
	 * 0x00 正常， 0x01 过压， 0x02 通讯故障
	 */
	private byte batteryCommunication;
	/**
	 * 0x00 正常， 0x02 充电过流
	 */
	private byte batteryOvercharging;
	/**
	 * 0x00 正常， 0x03 放电过流
	 */
	private byte batteryDischarge;
	/**
	 * 0x00 正常， 0x04 短路
	 */
	private byte batteryShortOut;
	/**
	 * 0x00 正常， 0x05 充电高温
	 */
	private byte batteryHigh;
	/**
	 * 0x00 正常， 0x06 充电低温
	 */
	private byte batteryLow;
	/**
	 * 0x00 正常， 0x07 欠压
	 */
	private byte batteryUndervoltage;
	/**
	 * 0x00 正常， 0x08 放电低温
	 */
	private byte batteryDischargeTemperature;

	/**
	 * 0x00 读取 0x01 主动上传
	 */
	private byte controlMode;
	/**
	 * 0x00 正常 0x0b 功率管故障
	 */
	private byte dynamicalCommunication;
	/**
	 * 0x00 正常 0x0c 过流故障
	 */
	private byte dynamicalOvercurrent;
	/**
	 * 0x00 正常 0x0d 过温故障
	 */
	private byte dynamicalThermal;
	/**
	 * 0x00 正常 0x0e 霍尔故障
	 */
	private byte dynamicalHall;
	/**
	 * 0x00 正常 0x0f 欠压故障
	 */
	private byte dynamicalUndervoltage;
	/**
	 * 0x00 正常 0x10 堵转故障
	 */
	private byte dynamicalLockedRotor;
	/**
	 * 0x00 正常 0x11 转把故障
	 */
	private byte dynamicalShifters;
	/**
	 * 0x00 表示正常 0x12 环境温度
	 */
	private byte viewCommunication;
	/**
	 * 0x00 表示正常 0x13 表示仪表自检故障
	 */
	private byte viewDashBoard;

	public byte[] getBatteryStatus() {
		return batteryStatus;
	}

	public void setBatteryStatus(byte[] batteryStatus) {
		this.batteryStatus = batteryStatus;
	}

	public byte[] getControlStatus() {
		return controlStatus;
	}

	public void setControlStatus(byte[] controlStatus) {
		this.controlStatus = controlStatus;
	}

	public byte[] getDynamicalStatus() {
		return dynamicalStatus;
	}

	public void setDynamicalStatus(byte[] dynamicalStatus) {
		this.dynamicalStatus = dynamicalStatus;
	}

	public byte[] getViewStatus() {
		return viewStatus;
	}

	public void setViewStatus(byte[] viewStatus) {
		this.viewStatus = viewStatus;
	}

	public byte getBatteryCommunication() {
		return batteryCommunication;
	}

	public void setBatteryCommunication(byte batteryCommunication) {
		this.batteryCommunication = batteryCommunication;
	}

	public byte getBatteryOvercharging() {
		return batteryOvercharging;
	}

	public void setBatteryOvercharging(byte batteryOvercharging) {
		this.batteryOvercharging = batteryOvercharging;
	}

	public byte getBatteryDischarge() {
		return batteryDischarge;
	}

	public void setBatteryDischarge(byte batteryDischarge) {
		this.batteryDischarge = batteryDischarge;
	}

	public byte getBatteryShortOut() {
		return batteryShortOut;
	}

	public void setBatteryShortOut(byte batteryShortOut) {
		this.batteryShortOut = batteryShortOut;
	}

	public byte getBatteryHigh() {
		return batteryHigh;
	}

	public void setBatteryHigh(byte batteryHigh) {
		this.batteryHigh = batteryHigh;
	}

	public byte getBatteryLow() {
		return batteryLow;
	}

	public void setBatteryLow(byte batteryLow) {
		this.batteryLow = batteryLow;
	}

	public byte getBatteryUndervoltage() {
		return batteryUndervoltage;
	}

	public void setBatteryUndervoltage(byte batteryUndervoltage) {
		this.batteryUndervoltage = batteryUndervoltage;
	}

	public byte getBatteryDischargeTemperature() {
		return batteryDischargeTemperature;
	}

	public void setBatteryDischargeTemperature(byte batteryDischargeTemperature) {
		this.batteryDischargeTemperature = batteryDischargeTemperature;
	}

	public byte getControlMode() {
		return controlMode;
	}

	public void setControlMode(byte controlMode) {
		this.controlMode = controlMode;
	}

	public byte getDynamicalCommunication() {
		return dynamicalCommunication;
	}

	public void setDynamicalCommunication(byte dynamicalCommunication) {
		this.dynamicalCommunication = dynamicalCommunication;
	}

	public byte getDynamicalOvercurrent() {
		return dynamicalOvercurrent;
	}

	public void setDynamicalOvercurrent(byte dynamicalOvercurrent) {
		this.dynamicalOvercurrent = dynamicalOvercurrent;
	}

	public byte getDynamicalThermal() {
		return dynamicalThermal;
	}

	public void setDynamicalThermal(byte dynamicalThermal) {
		this.dynamicalThermal = dynamicalThermal;
	}

	public byte getDynamicalHall() {
		return dynamicalHall;
	}

	public void setDynamicalHall(byte dynamicalHall) {
		this.dynamicalHall = dynamicalHall;
	}

	public byte getDynamicalUndervoltage() {
		return dynamicalUndervoltage;
	}

	public void setDynamicalUndervoltage(byte dynamicalUndervoltage) {
		this.dynamicalUndervoltage = dynamicalUndervoltage;
	}

	public byte getDynamicalLockedRotor() {
		return dynamicalLockedRotor;
	}

	public void setDynamicalLockedRotor(byte dynamicalLockedRotor) {
		this.dynamicalLockedRotor = dynamicalLockedRotor;
	}

	public byte getDynamicalShifters() {
		return dynamicalShifters;
	}

	public void setDynamicalShifters(byte dynamicalShifters) {
		this.dynamicalShifters = dynamicalShifters;
	}

	public byte getViewCommunication() {
		return viewCommunication;
	}

	public void setViewCommunication(byte viewCommunication) {
		this.viewCommunication = viewCommunication;
	}

	public byte getViewDashBoard() {
		return viewDashBoard;
	}

	public void setViewDashBoard(byte viewDashBoard) {
		this.viewDashBoard = viewDashBoard;
	}

	public byte[] getCheckCode2cc2() {
		return checkCode2cc2;
	}

	public void setCheckCode2cc2(byte[] checkCode2cc2) {
		this.checkCode2cc2 = checkCode2cc2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleCheckupMsg [");
		if (batteryStatus != null) {
			builder.append("batteryStatus=");
			builder.append(Arrays.toString(batteryStatus));
			builder.append(", ");
		}
		if (controlStatus != null) {
			builder.append("controlStatus=");
			builder.append(Arrays.toString(controlStatus));
			builder.append(", ");
		}
		if (dynamicalStatus != null) {
			builder.append("dynamicalStatus=");
			builder.append(Arrays.toString(dynamicalStatus));
			builder.append(", ");
		}
		if (viewStatus != null) {
			builder.append("viewStatus=");
			builder.append(Arrays.toString(viewStatus));
			builder.append(", ");
		}
		if (checkCode2cc2 != null) {
			builder.append("checkCode2cc2=");
			builder.append(Arrays.toString(checkCode2cc2));
			builder.append(", ");
		}
		builder.append("batteryCommunication=");
		builder.append(batteryCommunication);
		builder.append(", batteryOvercharging=");
		builder.append(batteryOvercharging);
		builder.append(", batteryDischarge=");
		builder.append(batteryDischarge);
		builder.append(", batteryShortOut=");
		builder.append(batteryShortOut);
		builder.append(", batteryHigh=");
		builder.append(batteryHigh);
		builder.append(", batteryLow=");
		builder.append(batteryLow);
		builder.append(", batteryUndervoltage=");
		builder.append(batteryUndervoltage);
		builder.append(", batteryDischargeTemperature=");
		builder.append(batteryDischargeTemperature);
		builder.append(", controlMode=");
		builder.append(controlMode);
		builder.append(", dynamicalCommunication=");
		builder.append(dynamicalCommunication);
		builder.append(", dynamicalOvercurrent=");
		builder.append(dynamicalOvercurrent);
		builder.append(", dynamicalThermal=");
		builder.append(dynamicalThermal);
		builder.append(", dynamicalHall=");
		builder.append(dynamicalHall);
		builder.append(", dynamicalUndervoltage=");
		builder.append(dynamicalUndervoltage);
		builder.append(", dynamicalLockedRotor=");
		builder.append(dynamicalLockedRotor);
		builder.append(", dynamicalShifters=");
		builder.append(dynamicalShifters);
		builder.append(", viewCommunication=");
		builder.append(viewCommunication);
		builder.append(", viewDashBoard=");
		builder.append(viewDashBoard);
		builder.append(", ");
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}
		builder.append("]");
		return builder.toString();
	}

}
