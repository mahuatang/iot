/**
 * Project Name:soco_iot
 * File Name:AlarmService.java
 * Package Name:com.soco.car.iot.service.car
 * Date:2018年8月4日上午2:42:56
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.service.car;

import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.server.car.message.msg.AlarmMsg;

import io.netty.channel.Channel;

/**
 * ClassName:AlarmService <br/>
 * Reason: 报警包业务处理 <br/>
 * Date: 2018年8月4日 上午2:42:56 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class AlarmService extends AbstractCarBaseService {

	@Override
	public void processBusiness(Channel channel, BaseMsg baseMsg) {
		AlarmMsg msg = (AlarmMsg) baseMsg;
		
	}

}
