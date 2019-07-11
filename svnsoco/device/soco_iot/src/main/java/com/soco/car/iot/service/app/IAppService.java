/**
 * Project Name:soco_iot
 * File Name:IAppService.java
 * Package Name:com.soco.car.iot.service.app
 * Date:2018年8月8日下午3:57:06
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.service.app;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soco.car.iot.constants.SOCOIotConstant;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.utils.ByteUtils;
import com.soco.car.iot.utils.CRC16;
import com.soco.car.iot.utils.Hex;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

/**
 * ClassName:IAppService <br/>
 * Reason: APP请求公共接口服务. <br/>
 * Date: 2018年8月8日 下午3:57:06 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public interface IAppService {

	public BaseMsg exec(Channel channel, BaseMsg baseMsg);

	/**
	 * 
	 * passthroughAgreementResponse: 7979协议透传调用公共接口
	 *
	 * @author sunlangping
	 * @param channel
	 *            透传的通道
	 * @param requestBody
	 *            透传的具体内容
	 * @return TODO
	 */
	public default boolean passthroughAgreementResponse(Channel channel, byte[] requestBody) {
		boolean flag = false;
		byte[] command = new byte[] { 0x79, 0x79 };
		byte[] protocol = new byte[] { (byte) 0x9B };
		byte[] modelprotocel = new byte[] { 0x02 };
		byte[] ser = new byte[] { 00, 00 };
		byte[] checkLength = ByteUtils.addAll(protocol, modelprotocel, requestBody, ser);
		byte[] length = ByteUtils.addAll(ByteUtils.shortToByte2((short) (checkLength.length + 2)));
		byte[] checkCode = CRC16.crc16Bytes7878(ByteUtils.addAll(length, checkLength));
		byte[] requestContent = ByteUtils.addAll(command, length, checkLength, checkCode, new byte[] { 0x0d, 0x0a });
		try {
			if (null != channel && channel.isActive() && requestContent != null) {
				// ByteBuf bf = Unpooled.copiedBuffer(baseMsg);
				ByteBuf bf = Unpooled.buffer(requestContent.length);
				bf.writeBytes(requestContent);
				if (channel.isOpen()) {
					channel.writeAndFlush(bf);
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return flag;
	}

	public default boolean response(Channel channel, String responseJson) {
		boolean flag = false;
		byte[] requestContent;
		try {
			requestContent = responseJson.getBytes(SOCOIotConstant.default_charset_utf8);
			requestContent = ByteUtils.addAll(requestContent, SOCOIotConstant.STOP_INDEX);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage());
		}
		ByteBuf bf = Unpooled.buffer(requestContent.length);
		bf.writeBytes(requestContent);
		if (channel.isOpen()) {
			channel.writeAndFlush(bf);
			flag = true;
		}
		return flag;
	}
}
