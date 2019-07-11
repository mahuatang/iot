/**
 * Project Name:soco_iot
 * File Name:JpushConfig.java
 * Package Name:com.soco.car.iot.config
 * Date:2018年8月11日下午5:29:40
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;

/**
 * ClassName:JpushConfig <br/>
 * Reason: 极光推送配置中心 <br/>
 * Date: 2018年8月11日 下午5:29:40 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Configuration
public class JpushConfig {

	@Value("${jg.master.secret}")
	private String masterSecret;

	@Value("${jg.app.key}")
	private String appKey;

	@Bean
	public JPushClient initJPushClient() {
		return new JPushClient(masterSecret, appKey, null, ClientConfig.getInstance());
	}
}
