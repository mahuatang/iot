/**
 * Project Name:soco_iot
 * File Name:GpsService.java
 * Package Name:com.soco.car.iot.service.car
 * Date:2018年8月2日下午9:48:42
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.service.car;

import org.springframework.stereotype.Service;

import com.soco.car.iot.server.car.message.BaseMsg;

import io.netty.channel.Channel;

/**
 * ClassName:GpsService <br/>
 * Reason: GPS上传服务. <br/>
 * Date: 2018年8月2日 下午9:48:42 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class GpsService extends AbstractCarBaseService {

	@Override
	public void processBusiness(Channel channel, BaseMsg baseMsg) {

	}

}
