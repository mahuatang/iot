/**
 * Project Name:SOCO_JOB
 * File Name:Applicatoin.java
 * Package Name:com.soco.car.job
 * Date:2018年5月25日上午10:11:24
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

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
@EnableScheduling
public class SoCoReportApplicatoin {

	private static final Logger logger = LoggerFactory.getLogger(SoCoReportApplicatoin.class);

	public static void main(String[] args) throws IOException {
//		 SpringApplication.run(SoCoReportApplicatoin.class, args);
		ConfigurableApplicationContext context=new SpringApplicationBuilder(SoCoReportApplicatoin.class)
				.properties("spring.config.location=classpath:springboot.properties").run(args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver slr = new CookieLocaleResolver();
		slr.setCookieMaxAge(3600);
		slr.setCookieName("Language");// 设置存储的Cookie的name为Language
		return slr;
	}

	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			// 拦截器
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(new LocaleChangeInterceptor()).addPathPatterns("/**");
			}
		};
	}
}
