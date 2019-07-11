/**
 * Project Name:SOCO_IOT
 * File Name:HeartbeatService.java
 * Package Name:com.soco.car.iot.service.car
 * Date:2018年7月16日下午7:10:33
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.service.car;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.soco.car.bean.cache.DeviceCachePOJO;
import com.soco.car.iot.constants.DeviceChannelContext;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.utils.ByteUtils;
import com.soco.car.iot.utils.Hex;

import io.netty.channel.Channel;

/**
 * ClassName:HeartbeatService <br/>
 * Reason: KKS心跳包,目前无业务处理 <br/>
 * Date: 2018年7月16日 下午7:10:33 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class HeartbeatService extends AbstractCarBaseService {

	private final static Logger logger = LoggerFactory.getLogger(HeartbeatService.class);

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, DeviceCachePOJO> deviceCacheTemplate;

	@Override
	public void processBusiness(Channel channel, BaseMsg baseMsg) {
		String deviceNo = "0868120197538942";
		Channel deviceChannel = DeviceChannelContext.getDevice(deviceNo);
		// HeartbeatMsg heartbeatMsg = (HeartbeatMsg) baseMsg;
		// String deviceNo = DeviceChannelContext.getAttrbute(channel);
		// DeviceCache cache = (DeviceCache)
		// deviceCacheTemplate.opsForHash().get(SOCOIotConstant.DEVICE_HASH, deviceNo);
		// int gms = heartbeatMsg.getGsm();
		// int voltage = heartbeatMsg.getVoltageLevel();
		// cache.setGsm(gms);
		// cache.setVoltage(voltage);
		// deviceCacheTemplate.opsForHash().put(SOCOIotConstant.DEVICE_HASH, deviceNo,
		// cache);

		// byte[] dispatchContent = new byte[] { 0x79, 0x79, 0x00, 0x0f, (byte) 0x9b,
		// 0x02, 0x2c, (byte) 0xc2, 0x00, 0x33,
		// 0x00, 0x03, 0x01, (byte) 0xfb, (byte) 0xaa, 0x00, 0x00, 0x1e, 0x7b, 0x0d,
		// 0x0a };

		byte[] dispatchContent = new byte[] { 0x79, 0x79, 0x00, 0x0f, (byte) 0x9b, 0x02, 0x2c, (byte) 0xc2, 0x00, 0x33,
				0x00, 0x03, 0x00, (byte) 0xeb, (byte) 0x8b, 0x00, 0x00, (byte) 0x8f, 0x79, 0x0d, 0x0a };
		logger.info("deviceChannel:{},content:{}", channel, ByteUtils.splitBlank(Hex.encodeHexStr(dispatchContent)));
	}

}
