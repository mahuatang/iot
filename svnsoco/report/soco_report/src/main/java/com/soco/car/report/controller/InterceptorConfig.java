/**
 * Project Name:SOCO_Report
 * File Name:InterceptorConfig.java
 * Package Name:com.soco.car.report.controller
 * Date:2018年7月3日下午4:29:18
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.soco.car.report.interceptor.LogIterceptor;

/**
 * ClassName:InterceptorConfig <br/>
 * Reason: 配置拦截器. <br/>
 * Date: 2018年7月3日 下午4:29:18 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new LogIterceptor()).addPathPatterns("/**").excludePathPatterns("/login/index")
//				.excludePathPatterns("/login/login");
		registry.addInterceptor(new LogIterceptor()).addPathPatterns("/**").excludePathPatterns("/login/index")
		.excludePathPatterns("/login/login");
	}
}
