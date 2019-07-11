/**
 * Project Name:SOCO_IOT
 * File Name:HeartbeatMsg.java
 * Package Name:com.soco.car.iot.message.car
 * Date:2018年7月9日下午4:05:39
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.msg;

import java.util.Arrays;

import com.soco.car.iot.server.car.message.Base7878Msg;
import com.soco.car.iot.utils.Hex;

/**
 * ClassName:HeartbeatMsg <br/>
 * Reason: 心跳包. <br/>
 * Date: 2018年7月9日 下午4:05:39 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class HeartbeatMsg extends Base7878Msg {

	private static final long serialVersionUID = 8529212440446296604L;
	/**
	 * 终端信息
	 */
	private byte terminal;
	/**
	 * 电压等级
	 */
	private byte voltageLevel;
	/**
	 * GSM信号强度
	 */
	private byte gsm;
	/**
	 * 语言扩展
	 */
	private byte[] languge;
	/**
	 * 终端信息防御状态 1:设防 0:撤防
	 */
	private byte terminalDefenseStatus;
	/**
	 * 1:ACC高 0:ACC低
	 */
	private byte terminalAcc;
	/**
	 * 1:已接电源充电 0:未接电源充电
	 */
	private byte terminalPowerStatus;
	/**
	 * 1:GPS已定位 0:GPS未定位
	 */
	private byte terminalGpsStatus;
	/**
	 * 1:油电断开 0:油电接通
	 */
	private byte terminalElectricityStatus;

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

	public byte getGsm() {
		return gsm;
	}

	public void setGsm(byte gsm) {
		this.gsm = gsm;
	}

	public byte[] getLanguge() {
		return languge;
	}

	public void setLanguge(byte[] languge) {
		this.languge = languge;
	}

	public byte getTerminalDefenseStatus() {
		return terminalDefenseStatus;
	}

	public void setTerminalDefenseStatus(byte terminalDefenseStatus) {
		this.terminalDefenseStatus = terminalDefenseStatus;
	}

	public byte getTerminalAcc() {
		return terminalAcc;
	}

	public void setTerminalAcc(byte terminalAcc) {
		this.terminalAcc = terminalAcc;
	}

	public byte getTerminalPowerStatus() {
		return terminalPowerStatus;
	}

	public void setTerminalPowerStatus(byte terminalPowerStatus) {
		this.terminalPowerStatus = terminalPowerStatus;
	}

	public byte getTerminalGpsStatus() {
		return terminalGpsStatus;
	}

	public void setTerminalGpsStatus(byte terminalGpsStatus) {
		this.terminalGpsStatus = terminalGpsStatus;
	}

	public byte getTerminalElectricityStatus() {
		return terminalElectricityStatus;
	}

	public void setTerminalElectricityStatus(byte terminalElectricityStatus) {
		this.terminalElectricityStatus = terminalElectricityStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HeartbeatMsg [terminal=");
		builder.append(terminal);
		builder.append(", voltageLevel=");
		builder.append(voltageLevel);
		builder.append(", gsm=");
		builder.append(gsm);
		builder.append(", ");
		if (languge != null) {
			builder.append("languge=");
			builder.append(Arrays.toString(languge));
			builder.append(", ");
		}
		builder.append("terminalDefenseStatus=");
		builder.append(terminalDefenseStatus);
		builder.append(", terminalAcc=");
		builder.append(terminalAcc);
		builder.append(", terminalPowerStatus=");
		builder.append(terminalPowerStatus);
		builder.append(", terminalGpsStatus=");
		builder.append(terminalGpsStatus);
		builder.append(", terminalElectricityStatus=");
		builder.append(terminalElectricityStatus);
		builder.append(", ");
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}
		builder.append("]");
		return builder.toString();
	}

}
