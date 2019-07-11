/**
 * Project Name:SOCO_IOT
 * File Name:GpsConvert.java
 * Package Name:com.soco.car.iot.message.car.convert
 * Date:2018年7月17日上午9:12:07
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.convert;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.soco.car.iot.annotation.AuthAnnotation;
import com.soco.car.iot.annotation.AuthAnnotation.Auth;
import com.soco.car.iot.constants.DeviceChannelContext;
import com.soco.car.iot.constants.SOCOIotConstant;
import com.soco.car.iot.server.car.message.AbstractMessageConverter;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.server.car.message.msg.UploadCarStateMsg;
import com.soco.car.iot.utils.ByteUtils;
import com.soco.car.iot.utils.CRC16;
import com.soco.car.iot.utils.Hex;

import io.netty.channel.Channel;

/**
 * ClassName:UploadCarStateConvert <br/>
 * Reason: 透传协议上传车辆状态信息 <br/>
 * Date: 2018年7月17日 上午9:12:07 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class UploadCarStateConvert extends AbstractMessageConverter {

	private static final Logger logger = LoggerFactory.getLogger(UploadCarStateConvert.class);

	private String msgType = "uploadCarState";

	@AuthAnnotation(value = Auth.AUTH_DEVICE)
	@Override
	public BaseMsg convert2Message(Channel channel, byte[] msg) {
		UploadCarStateMsg uploadCarStateMsg = new UploadCarStateMsg();
		String deviceNo = DeviceChannelContext.getAttrbute(channel);
		byte[] command = Arrays.copyOfRange(msg, 0, 2);
		byte[] contentLength = Arrays.copyOfRange(msg, 2, 4);
		byte[] protocol = Arrays.copyOfRange(msg, 4, 5);
		byte modelProtocol = Arrays.copyOfRange(msg, 5, 6)[0];
		byte[] passthroughContent = Arrays.copyOfRange(msg, 6, 34);
		byte[] messageSerialNumber = Arrays.copyOfRange(msg, 34, 36);
		byte[] checkCode = Arrays.copyOfRange(msg, 36, 38);
		// 透传协议头部
		byte[] childCommand = Arrays.copyOfRange(passthroughContent, 0, 2);
		byte[] childProtocol = Arrays.copyOfRange(passthroughContent, 2, 4);
		byte[] childContentLength = Arrays.copyOfRange(passthroughContent, 4, 6);
		// 透传协议中内容
		byte powerState = Arrays.copyOfRange(passthroughContent, 6, 7)[0];
		byte[] currentRideCircle = Arrays.copyOfRange(passthroughContent, 7, 9);
		byte[] sumRideCircle = Arrays.copyOfRange(passthroughContent, 9, 13);
		byte electric = Arrays.copyOfRange(passthroughContent, 13, 14)[0];
		byte voltage = Arrays.copyOfRange(passthroughContent, 14, 15)[0];
		byte temperature = Arrays.copyOfRange(passthroughContent, 15, 16)[0];
		byte uploadRate = Arrays.copyOfRange(passthroughContent, 16, 17)[0];
		byte move = Arrays.copyOfRange(passthroughContent, 17, 18)[0];
		byte[] default1 = Arrays.copyOfRange(passthroughContent, 18, 22);
		byte default2 = Arrays.copyOfRange(passthroughContent, 22, 23)[0];
		byte[] endurance = Arrays.copyOfRange(passthroughContent, 23, 25);
		byte lock = Arrays.copyOfRange(passthroughContent, 25, 26)[0];

		uploadCarStateMsg.setPowerState(powerState);
		uploadCarStateMsg.setCurrentRideCircle(ByteUtils.byte2ToShort(currentRideCircle));
		uploadCarStateMsg.setSumRideCircle(ByteUtils.byte4ToInt(sumRideCircle));
		uploadCarStateMsg.setElectric(electric);
		uploadCarStateMsg.setVoltage(voltage);
		uploadCarStateMsg.setTemperature(temperature);
		uploadCarStateMsg.setUploadRate(uploadRate);
		uploadCarStateMsg.setMove(move);
		uploadCarStateMsg.setDefault_1(ByteUtils.byte4ToInt(default1));
		uploadCarStateMsg.setDefault_2(default2);
		uploadCarStateMsg.setEndurance(ByteUtils.byte2ToShort(endurance));
		uploadCarStateMsg.setLock(lock);
		uploadCarStateMsg.setRequestContent(msg);
		uploadCarStateMsg.setMsgType(msgType);
		uploadCarStateMsg.setDeviceNo(deviceNo);

		byte[] pc = ByteUtils.addAll(childCommand, childProtocol, new byte[] { 0x00, 0x03 }, new byte[] { 0x00 });
		byte[] childCheckCode = CRC16.crc16Bytes(pc);
		pc = ByteUtils.addAll(pc, childCheckCode);
		byte[] responseContent = ByteUtils.addAll(protocol, new byte[] { modelProtocol }, pc, messageSerialNumber);
		byte[] check = CRC16.crc16Bytes7878(responseContent);
		byte[] len = ByteUtils.shortToByte2((short) ByteUtils.addAll(responseContent, check).length);
		uploadCarStateMsg.setResponseContent(ByteUtils.addAll(command, len, responseContent, check, SOCOIotConstant.STOP_INDEX));
		uploadCarStateMsg.setRequestContent(msg);
		return uploadCarStateMsg;
	}

	/**
	 * 
	 * 透传协议公共处理类
	 * 
	 * @see com.soco.car.iot.server.car.message.MessageConverter#supportProcotol()
	 */
	@Override
	public byte supportProcotol() {
		return (byte) 0x32;
	}

}
