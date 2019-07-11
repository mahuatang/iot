/**
 * Project Name:soco_api
 * File Name:SmsCountryServiceTest.java
 * Package Name:com.soco.car.user.service
 * Date:2018年7月30日下午5:40:05
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.user.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soco.car.base.BaseTest;
import com.soco.car.user.entity.SmsCountry;

/**
 * ClassName:SmsCountryServiceTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月30日 下午5:40:05 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class SmsCountryServiceTest extends BaseTest {

	@Autowired
	private SmsCountryService smsCountryService;

	@Test
	public void testFindActiveCountry() throws Exception {
		List<SmsCountry> list = smsCountryService.findActiveCountry();
		for (SmsCountry s : list) {
			System.out.println(s);
		}
	}

	@Test
	public void testFindAll() throws Exception {
		List<SmsCountry> list = smsCountryService.findAll();
		for (SmsCountry s : list) {
			System.out.println(s);
		}
	}

}
