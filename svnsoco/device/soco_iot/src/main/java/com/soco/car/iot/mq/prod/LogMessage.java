/**
 * Project Name:SOCO_IOT
 * File Name:LogMessage.java
 * Package Name:com.soco.car.iot.mq.prod
 * Date:2018年7月12日下午3:04:47
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.mq.prod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.service.car.AbstractCarBaseService;

/**
 * ClassName:LogMessage <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月12日 下午3:04:47 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class LogMessage {

	private static final Logger logger = LoggerFactory.getLogger(AbstractCarBaseService.class);
	
	public void send(BaseMsg baseMsg) {
//		logger.info("send baseMsg...{}", baseMsg);
	}
}
