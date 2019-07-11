/**
 * Project Name:SOCO_JOB
 * File Name:Applicatoin.java
 * Package Name:com.soco.car.job
 * Date:2018年5月25日上午10:11:24
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.soco.car.iot.server.NettyServerI;

/**
 * ClassName:Applicatoin <br/>
 * Reason: 项目初始化 <br/>
 * Date: 2018年5月25日 上午10:11:24 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@SpringBootApplication
public class SoCoIOTApplicatoin {

	private static final Logger logger = LoggerFactory.getLogger(SoCoIOTApplicatoin.class);

	public static void main(String[] args) throws IOException {
		// SpringApplication.run(SoCoReportApplicatoin.class, args);
		ConfigurableApplicationContext context = new SpringApplicationBuilder(SoCoIOTApplicatoin.class)
				.properties("spring.config.location=classpath:springboot.properties").run(args);
		Map<String, NettyServerI> nettyServiceMap = context.getBeansOfType(NettyServerI.class);
		nettyServiceMap.forEach((k, v) -> {
			new Thread(() -> {
				v.start();
			}).start();
		});
		logger.info("start all server end ....");
	}
}
