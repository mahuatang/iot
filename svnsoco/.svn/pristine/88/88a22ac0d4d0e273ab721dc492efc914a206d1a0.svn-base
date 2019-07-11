/**
 * Project Name:SOCO_APP
 * File Name:HandlerInterceptor.java
 * Package Name:com.soco.car.app.interceptor
 * Date:2018年7月23日下午4:50:17
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.soco.car.app.service.JwtService;

/**
 * LoginInterceptor <br/>
 * Reason: 登录拦截器 <br/>
 * Date: 2018年7月23日 下午4:50:17 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class LoginInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Autowired
	private JwtService jwtService;

	/**
	 * 在请求被处理之前调用
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getHeader("Authorization");
		if (logger.isDebugEnabled()) {
			logger.debug("preHandle..token:{}", token);
		}
		jwtService.validateToken(token);
		return true;
	}
}
