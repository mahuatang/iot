/**
 * Project Name:SOCO_Report
 * File Name:LogIterceptor.java
 * Package Name:com.soco.car.report.interceptor
 * Date:2018年7月3日下午4:36:44
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName:LogIterceptor <br/>
 * Reason: 日志拦截器. <br/>
 * Date: 2018年7月3日 下午4:36:44 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class LogIterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(LogIterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("afterCompletion request:{},reponse:{}", request, response);
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle request:{},reponse:{}", request, response);
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandle request:{},reponse:{}", request, response);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
