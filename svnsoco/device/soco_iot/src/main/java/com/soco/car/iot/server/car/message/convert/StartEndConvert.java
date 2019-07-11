/**
 * Project Name:soco_iot
 * File Name:StartEndMsg.java
 * Package Name:com.soco.car.iot.message.car.msg
 * Date:2018年8月4日上午11:42:09
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.convert;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.soco.car.iot.constants.DeviceChannelContext;
import com.soco.car.iot.server.car.message.AbstractMessageConverter;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.server.car.message.msg.StartEndMsg;
import com.soco.car.iot.utils.ByteUtils;

import io.netty.channel.Channel;

/**
 * ClassName:StartEndMsg <br/>
 * Reason: 车俩启动或结束报文. <br/>
 * Date: 2018年8月4日 上午11:42:09 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class StartEndConvert extends AbstractMessageConverter {

	private String msgType = "startEnd";

	@Override
	public BaseMsg convert2Message(Channel channel, byte[] msg) {
		StartEndMsg startEnd = new StartEndMsg();
		String deviceNo = DeviceChannelContext.getAttrbute(channel);
		byte[] command = Arrays.copyOfRange(msg, 0, 2);
		byte[] contentLength = Arrays.copyOfRange(msg, 2, 4);
		byte[] protocol = Arrays.copyOfRange(msg, 4, 5);
		byte modelProtocol = Arrays.copyOfRange(msg, 5, 6)[0];
		// 透传协议内容
		byte[] passthroughContent = Arrays.copyOfRange(msg, 6, 21);
		byte[] messageSerialNumber = Arrays.copyOfRange(msg, 21, 23);
		byte[] checkCode = Arrays.copyOfRange(msg, 23, 25);
		// 透传协议头部
		byte[] childCommand = Arrays.copyOfRange(passthroughContent, 0, 2);
		byte[] childProtocol = Arrays.copyOfRange(passthroughContent, 2, 4);
		byte[] childContentLength = Arrays.copyOfRange(passthroughContent, 4, 6);

		byte start = Arrays.copyOfRange(passthroughContent, 6, 7)[0];
		byte[] accumulativeRim = Arrays.copyOfRange(passthroughContent, 7, 11);

		byte[] electricQuantity = Arrays.copyOfRange(passthroughContent, 11, 13);

		startEnd.setStart(start);
		startEnd.setAccumulativeRim(ByteUtils.byte4ToInt(accumulativeRim));
		startEnd.setElectricQuantity(ByteUtils.byte2ToShort(electricQuantity));

		startEnd.setDeviceNo(deviceNo);
		startEnd.setMsgType(msgType);

		startEnd.setRequestContent(msg);
		
		
		return startEnd;
	}

	@Override
	public byte supportProcotol() {
		return 0x36;
	}

}
