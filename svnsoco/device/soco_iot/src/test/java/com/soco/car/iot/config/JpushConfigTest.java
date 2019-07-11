/**
 * Project Name:soco_iot
 * File Name:JpushConfigTest.java
 * Package Name:com.soco.car.iot.config
 * Date:2018年8月11日下午6:34:15
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soco.car.iot.base.BaseTest;

import cn.jpush.api.JPushClient;

/**
 * ClassName:JpushConfigTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年8月11日 下午6:34:15 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class JpushConfigTest extends BaseTest {

	@Autowired
	private JPushClient jPushClient;

	@Test
	public void testInitJPushClient() throws Exception {
		System.out.println(jPushClient);
	}

}
