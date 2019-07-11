/**
 * Project Name:SOCO_JOB
 * File Name:Applicatoin.java
 * Package Name:com.soco.car.job
 * Date:2018年5月25日上午10:11:24
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * ClassName: SoCoApiApplicatoin <br/>
 * Function: 项目初始化. <br/>
 * date: 2018年7月23日 下午7:49:36 <br/>
 *
 * @author sunlangping
 * @version
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableTransactionManagement
public class SoCoApiApplicatoin {

	private static final Logger logger = LoggerFactory.getLogger(SoCoApiApplicatoin.class);

	public static void main(String[] args) {
		// SpringApplication.run(SoCoApiApplicatoin.class, args);
		new SpringApplicationBuilder(SoCoApiApplicatoin.class)
				.properties("spring.config.location=classpath:springboot.properties").run(args);
	}
}
