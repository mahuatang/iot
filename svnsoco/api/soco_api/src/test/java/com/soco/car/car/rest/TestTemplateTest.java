/**
 * Project Name:SOCO_API
 * File Name:TestTemplateTest.java
 * Package Name:com.soco.car.car.rest
 * Date:2018年6月20日下午1:46:46
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.car.rest;
/**
 * ClassName:TestTemplateTest <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月20日 下午1:46:46 <br/>
 * @author   sunlangping
 * @version  
 * @see 	 
 */

import org.junit.Test;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class TestTemplateTest {
	private RestTemplate resttemplate = new RestTemplate();
	private String http = "http://47.104.146.240:8080/SOCOTS01_Site/alsfoxShop/site/version/isUpgradeVersion?pv.versionNo=1";

	@Test
	public void sendTest() {
		resttemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		
		BaseMessage response = resttemplate.getForObject(http, BaseMessage.class);
		System.out.println(response);
	}
}
