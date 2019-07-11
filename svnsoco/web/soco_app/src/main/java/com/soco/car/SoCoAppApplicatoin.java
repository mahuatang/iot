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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

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
public class SoCoAppApplicatoin {

	private static final Logger logger = LoggerFactory.getLogger(SoCoAppApplicatoin.class);

	public static void main(String[] args) throws IOException {
		// SpringApplication.run(SoCoReportApplicatoin.class, args);
		ConfigurableApplicationContext context = new SpringApplicationBuilder(SoCoAppApplicatoin.class)
				.properties("spring.config.location=classpath:springboot.properties").run(args);
	}
}