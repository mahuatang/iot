/**
 * Project Name:SOCO_Report
 * File Name:Swagger2.java
 * Package Name:com.soco.car.report.config
 * Date:2018年6月25日下午4:03:50
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ClassName:Swagger2 <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月25日 下午4:03:50 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Value("${swagger2.isShow}")
	private boolean isShow;
	
	@Bean
	public Docket createRestApi() {
		ApiSelectorBuilder api=new Docket(DocumentationType.SWAGGER_2)
		.apiInfo(apiInfo())
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.soco.car.report.controller")); // 以扫描包的方式
		//生产环境全部隐藏掉
		if(isShow) {
			api.paths(PathSelectors.any());
		}else {
			api.paths(PathSelectors.none());
		}
		return api.build();
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiInfo())
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.soco.car.report.controller")) // 以扫描包的方式
//				.paths(PathSelectors.any())
//				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.contact(new Contact("Paco.Sun", "http://www.supersoco.com", "sunlangping8888@163.com"))
				.title("报表相关接口RESTful API").version("1.0").description("标准restful api接口").build();
	}
}
