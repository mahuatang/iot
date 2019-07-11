/**
 * Project Name:soco_iot
 * File Name:AppVehicleCheckupService.java
 * Package Name:com.soco.car.iot.service.app
 * Date:2018年8月8日下午3:57:49
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.service.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.soco.car.iot.annotation.AuthAnnotation;
import com.soco.car.iot.annotation.AuthAnnotation.Auth;
import com.soco.car.iot.constants.AppChannelContext;
import com.soco.car.iot.constants.DeviceChannelContext;
import com.soco.car.iot.server.car.message.BaseMsg;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

/**
 * ClassName:AppVehicleCheckupService <br/>
 * Reason: APP体检服务 <br/>
 * Date: 2018年8月8日 下午3:57:49 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class AppVehicleCheckupService implements IAppService {

	private static final Logger logger = LoggerFactory.getLogger(AppVehicleCheckupService.class);

	@AuthAnnotation(Auth.AUTH_APP)
	@Override
	public BaseMsg exec(Channel channel, BaseMsg baseMsg) {
		BaseMsg msg = new BaseMsg();
		String account = AppChannelContext.getAttrbute(channel);
		Channel deviceChannel = DeviceChannelContext.getDevice(baseMsg.getDeviceNo());
		// 请求中控
		byte[] requestBody = new byte[] { 0x2c, (byte) 0xc2, 0x00, 0x33, 0x00, 0x03, 0x00, (byte) 0xeb, (byte) 0x8b };
		boolean isSend = passthroughAgreementResponse(deviceChannel, requestBody);
		if (!isSend) {
			logger.warn("体检转发到设备失败,请求手机号为:{},请求参数为:{}", account, baseMsg);
		}
		return msg;
	}
}
