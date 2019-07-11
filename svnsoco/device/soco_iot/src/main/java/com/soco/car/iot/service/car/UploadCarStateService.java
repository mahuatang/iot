/**
 * Project Name:SOCO_IOT
 * File Name:LoginService.java
 * Package Name:com.soco.car.iot.service.car
 * Date:2018年7月12日下午2:55:18
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.service.car;

import org.springframework.stereotype.Service;

import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.server.car.message.msg.UploadCarStateMsg;

import io.netty.channel.Channel;

/**
 * ClassName:LoginService <br/>
 * Reason: 登录中后续的业务处理类. <br/>
 * Date: 2018年7月12日 下午2:55:18 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class UploadCarStateService extends AbstractCarBaseService {

	/**
	 * 
	 * 处理登录操作相关业务
	 * 
	 * @see com.soco.car.iot.service.car.ICarService#processBusiness(io.netty.channel.Channel,
	 *      com.soco.car.iot.server.car.message.BaseMsg)
	 */
	@Override
	public void processBusiness(Channel channel, BaseMsg baseMsg) {
		UploadCarStateMsg msg = (UploadCarStateMsg) baseMsg;
	}

}
