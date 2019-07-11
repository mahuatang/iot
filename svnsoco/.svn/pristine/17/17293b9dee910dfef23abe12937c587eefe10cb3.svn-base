/**
 * Project Name:soco_app
 * File Name:AliSmsServiceTest.java
 * Package Name:com.soco.car.app.sdk.ali.sms
 * Date:2018年8月11日下午3:39:35
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.sdk.ali.sms;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soco.car.app.base.BaseTest;
import com.soco.car.app.constants.AliSmsTemplateEnum;

/**
 * ClassName:AliSmsServiceTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年8月11日 下午3:39:35 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class AliSmsServiceTest extends BaseTest {

	@Autowired
	private AliSmsService aliSmsService;

	@Test
	public void testSendSms() throws Exception {
		String phoneCode="86";
		String phone="17602109468";
		Map<String, String> variableMap = new HashMap<>();
		variableMap.put("code", "123456");
		aliSmsService.sendSms(phoneCode, phone, AliSmsTemplateEnum.register_account_zh.getValue(), variableMap);
	}

}
