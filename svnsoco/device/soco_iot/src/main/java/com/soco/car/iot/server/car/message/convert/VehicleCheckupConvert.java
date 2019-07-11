/**
 * Project Name:soco_iot
 * File Name:VehicleCheckupConvert.java
 * Package Name:com.soco.car.iot.message.car.convert
 * Date:2018年8月4日上午11:38:59
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.convert;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.soco.car.iot.constants.DeviceChannelContext;
import com.soco.car.iot.server.car.message.AbstractMessageConverter;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.server.car.message.msg.VehicleCheckupMsg;

import io.netty.channel.Channel;

/**
 * ClassName:VehicleCheckupConvert <br/>
 * Reason: 车俩体检报文 <br/>
 * Date: 2018年8月4日 上午11:38:59 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class VehicleCheckupConvert extends AbstractMessageConverter {

	private String msgType = "vehicleCheckup";

	@Override
	public BaseMsg convert2Message(Channel channel, byte[] msg) {
		VehicleCheckupMsg vehicleCheckup = new VehicleCheckupMsg();
		String deviceNo = DeviceChannelContext.getAttrbute(channel);
		byte[] command = Arrays.copyOfRange(msg, 0, 2);
		byte[] contentLength = Arrays.copyOfRange(msg, 2, 4);
		byte[] protocol = Arrays.copyOfRange(msg, 4, 5);
		byte modelProtocol = Arrays.copyOfRange(msg, 5, 6)[0];
		// 透传协议内容
		byte[] passthroughContent = Arrays.copyOfRange(msg, 6, 33);
		byte[] messageSerialNumber = Arrays.copyOfRange(msg, 33, 35);
		byte[] checkCode = Arrays.copyOfRange(msg, 36, 38);
		// 透传协议头部
		byte[] childCommand = Arrays.copyOfRange(passthroughContent, 0, 2);
		byte[] childProtocol = Arrays.copyOfRange(passthroughContent, 2, 4);
		byte[] childContentLength = Arrays.copyOfRange(passthroughContent, 4, 6);
		// 透传协议内容
		// 电池相关故障相关
		byte[] batteryStatus = Arrays.copyOfRange(passthroughContent, 6, 14);
		// 中控系统故障相关
		byte[] controlStatus = Arrays.copyOfRange(passthroughContent, 14, 16);
		// 动力系统故障相关
		byte[] dynamicalStatus = Arrays.copyOfRange(passthroughContent, 16, 23);
		// 显示系统故障相关
		byte[] viewStatus = Arrays.copyOfRange(passthroughContent, 23, 25);

		byte batteryCommunication = Arrays.copyOfRange(batteryStatus, 0, 1)[0];
		byte batteryOvercharging = Arrays.copyOfRange(batteryStatus, 1, 2)[0];
		byte batteryDischarge = Arrays.copyOfRange(batteryStatus, 2, 3)[0];
		byte batteryShortOut = Arrays.copyOfRange(batteryStatus, 3, 4)[0];
		byte batteryHigh = Arrays.copyOfRange(batteryStatus, 4, 5)[0];
		byte batteryLow = Arrays.copyOfRange(batteryStatus, 5, 6)[0];
		byte batteryUndervoltage = Arrays.copyOfRange(batteryStatus, 6, 7)[0];
		byte batteryDischargeTemperature = Arrays.copyOfRange(batteryStatus, 7, 8)[0];

		vehicleCheckup.setBatteryCommunication(batteryCommunication);
		vehicleCheckup.setBatteryOvercharging(batteryOvercharging);
		vehicleCheckup.setBatteryDischarge(batteryDischarge);
		vehicleCheckup.setBatteryShortOut(batteryShortOut);
		vehicleCheckup.setBatteryHigh(batteryHigh);
		vehicleCheckup.setBatteryLow(batteryLow);
		vehicleCheckup.setBatteryUndervoltage(batteryUndervoltage);
		vehicleCheckup.setBatteryDischargeTemperature(batteryDischargeTemperature);

		byte controlMode = Arrays.copyOfRange(controlStatus, 0, 1)[0];
		vehicleCheckup.setControlMode(controlMode);

		byte dynamicalCommunication = Arrays.copyOfRange(dynamicalStatus, 0, 1)[0];
		byte dynamicalOvercurrent = Arrays.copyOfRange(dynamicalStatus, 1, 2)[0];
		byte dynamicalThermal = Arrays.copyOfRange(dynamicalStatus, 2, 3)[0];
		byte dynamicalHall = Arrays.copyOfRange(dynamicalStatus, 3, 4)[0];
		byte dynamicalUndervoltage = Arrays.copyOfRange(dynamicalStatus, 4, 5)[0];
		byte dynamicalLockedRotor = Arrays.copyOfRange(dynamicalStatus, 5, 6)[0];
		byte dynamicalShifters = Arrays.copyOfRange(dynamicalStatus, 6, 7)[0];

		vehicleCheckup.setDynamicalCommunication(dynamicalCommunication);
		vehicleCheckup.setDynamicalOvercurrent(dynamicalOvercurrent);
		vehicleCheckup.setDynamicalThermal(dynamicalThermal);
		vehicleCheckup.setDynamicalHall(dynamicalHall);
		vehicleCheckup.setDynamicalUndervoltage(dynamicalUndervoltage);
		vehicleCheckup.setDynamicalLockedRotor(dynamicalLockedRotor);
		vehicleCheckup.setDynamicalShifters(dynamicalShifters);

		byte viewCommunication = Arrays.copyOfRange(viewStatus, 0, 1)[0];
		byte viewDashBoard = Arrays.copyOfRange(viewStatus, 1, 2)[0];

		vehicleCheckup.setViewCommunication(viewCommunication);
		vehicleCheckup.setViewDashBoard(viewDashBoard);

		vehicleCheckup.setBatteryStatus(batteryStatus);
		vehicleCheckup.setControlStatus(controlStatus);
		vehicleCheckup.setDynamicalStatus(dynamicalStatus);
		vehicleCheckup.setViewStatus(viewStatus);
		vehicleCheckup.setRequestContent(msg);
		vehicleCheckup.setMsgType(msgType);
		vehicleCheckup.setDeviceNo(deviceNo);

		vehicleCheckup.setRequestContent(msg);
		return vehicleCheckup;
	}

	@Override
	public byte supportProcotol() {
		return 0x33;
	}

}
