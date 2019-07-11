/**
 * Project Name:soco_iot
 * File Name:I18nServiceTest.java
 * Package Name:com.soco.car.iot.common.service
 * Date:2018年8月11日下午2:27:06
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.common.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soco.car.iot.base.BaseTest;

/**
 * ClassName:I18nServiceTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年8月11日 下午2:27:06 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class I18nServiceTest extends BaseTest {

	@Autowired
	private I18nService i18nService;

//	@Autowired
//	private MyTokenCache mytokenCache;

	@Test
	public void testGetMessage() throws Exception {
		String code = "push.battery.charging.overvoltage";
		String response = i18nService.getMessage(code);
		System.out.println(response);
	}

//	@Test
//	public void testMytokenCache() throws Exception {
//		System.out.println(mytokenCache);
//	}
}
