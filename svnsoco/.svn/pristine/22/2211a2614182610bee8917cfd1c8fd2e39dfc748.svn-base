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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ClassName:Applicatoin <br/>
 * Reason: 项目初始化 <br/>
 * Date: 2018年5月25日 上午10:11:24 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableTransactionManagement
public class SoCoApiApplicatoinTest {

	private static final Logger logger = LoggerFactory.getLogger(SoCoApiApplicatoin.class);

	public static void main(String[] args) {
		SpringApplication.run(SoCoApiApplicatoinTest.class, args);
	}
}
