/**
 * Project Name:SOCO_IOT
 * File Name:PlatServer.java
 * Package Name:com.soco.car.iot.server
 * Date:2018年7月9日下午7:33:26
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.plat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.soco.car.SoCoIOTApplicatoin;
import com.soco.car.iot.server.NettyServerI;

/**
 * ClassName:PlatServer <br/>
 * Reason: 后台相关业务 <br/>
 * Date: 2018年7月9日 下午7:33:26 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class PlatServer implements NettyServerI {

	private static final Logger logger = LoggerFactory.getLogger(SoCoIOTApplicatoin.class);

	@Override
	public void start() {
		logger.info("PlatServer Start...");
	}

}
