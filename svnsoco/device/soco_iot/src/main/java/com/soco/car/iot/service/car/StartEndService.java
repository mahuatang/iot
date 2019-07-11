/**
 * Project Name:soco_iot
 * File Name:StartEndService.java
 * Package Name:com.soco.car.iot.service.car
 * Date:2018年8月7日上午11:17:26
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.service.car;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Service;

import com.soco.car.iot.constants.SOCOIotConstant;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.server.car.message.msg.StartEndMsg;
import com.soco.car.iot.utils.ByteUtils;
import com.soco.car.iot.utils.GsonUtil;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

/**
 * ClassName:StartEndService <br/>
 * Reason: 电动车开启或结束<br/>
 * Date: 2018年8月7日 上午11:17:26 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class StartEndService extends AbstractCarBaseService {

	@Override
	public void processBusiness(Channel channel, BaseMsg baseMsg) {

		StartEndMsg msg = new StartEndMsg();
		msg.setDeviceNo("设备号");
		String gson = GsonUtil.GsonString(msg);
		byte[] response = null;
		try {
			response = gson.getBytes(SOCOIotConstant.default_charset_utf8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ByteBuf bf = Unpooled.copiedBuffer(ByteUtils.addAll(response, SOCOIotConstant.STOP_INDEX));
		if (channel.isOpen()) {
			channel.writeAndFlush(bf);
		}
	}

}
