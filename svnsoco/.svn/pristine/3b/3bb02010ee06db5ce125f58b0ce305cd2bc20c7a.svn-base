/**
 * Project Name:SOCO_Report
 * File Name:Swagger2.java
 * Package Name:com.soco.car.report.config
 * Date:2018年6月25日下午4:03:50
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
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
		List<ApiKey> apiKeyList=new ArrayList<>();
		
		apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
		ApiSelectorBuilder api = new Docket(DocumentationType.SWAGGER_2)
				.securitySchemes(apiKeyList)
				.securityContexts(securityContexts())
//				.globalOperationParameters(pars)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.soco.car.app.controller")); // 以扫描包的方式
		// 生产环境全部隐藏掉
		if (isShow) {
			api.paths(PathSelectors.any());
		} else {
			api.paths(PathSelectors.none());
		}
		return api.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.contact(new Contact("Paco.Sun", "http://www.supersoco.com", "sunlangping8888@163.com"))
				.title("APP相关接口RESTful API").version("1.0").description("标准restful api接口").build();
	}
	private List<SecurityContext> securityContexts() {
		List<SecurityContext> securityContextList=new ArrayList<>();
		SecurityContext securityContext=SecurityContext.builder()
        .securityReferences(defaultAuth())
        .forPaths(PathSelectors.regex("^(?!auth).*$"))
        .build();
		securityContextList.add(securityContext);
		return securityContextList;
    }

	private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferenceList=new ArrayList<>();
        securityReferenceList.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferenceList;
    }
}
