/**
 * Project Name:SOCO_Report
 * File Name:RestTemplateConfig.java
 * Package Name:com.soco.car.report.config
 * Date:2018年6月22日下午3:31:57
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:RestTemplateConfig <br/>
 * Reason: restTemplate 初始化配置中心 <br/>
 * Date: 2018年6月22日 下午3:31:57 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

}
