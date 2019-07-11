/**
 * Project Name:soco_app
 * File Name:AliSmsConfig.java
 * Package Name:com.soco.car.app.config
 * Date:2018年7月30日下午3:12:48
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * ClassName:AliSmsConfig <br/>
 * Reason: 阿里短信配置中心 <br/>
 * Date: 2018年7月30日 下午3:12:48 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Configuration
public class AliSmsConfig {
	/**
	 * 产品名称:云通信短信API产品,开发者无需替换
	 */
	static final String product = "Dysmsapi";
	/**
	 * 产品域名,开发者无需替换
	 */
	static final String domain = "dysmsapi.aliyuncs.com";

	@Value("${ali.sms.accessKeyId}")
	private String accessKeyId;
	@Value("${ali.sms.accessKeySecret}")
	private String accessKeySecret;

	@Bean
	public IAcsClient createAcsClient() throws ClientException {
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);
		return acsClient;
	}
}
