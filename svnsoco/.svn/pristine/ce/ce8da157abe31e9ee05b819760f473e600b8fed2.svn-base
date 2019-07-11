/**
 * Project Name:SOCO_APP
 * File Name:I18nController.java
 * Package Name:com.soco.car.app.controller
 * Date:2018年7月23日上午10:17:21
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.service;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

/**
 * ClassName:I18nController <br/>
 * Reason: 用户返回值国际化. <br/>
 * Date: 2018年7月23日 上午10:17:21 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class I18nService {
	private static final Logger logger = LoggerFactory.getLogger(I18nService.class);

	private MessageSource messageSource;
	@Value("${spring.messages.basename}")
	private String basename;

	@Value("${spring.messages.cache-seconds}")
	private long cacheMillis;

	@Value("${spring.messages.encoding}")
	private String encoding;

	@Value("${default.return.language}")
	private String defaultReturnLanguage;
	/**
	 * 初始化
	 * 
	 * @return
	 */
	private MessageSource initMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(basename);
		messageSource.setDefaultEncoding(encoding);
		messageSource.setCacheMillis(cacheMillis);
		return messageSource;
	}

	/**
	 * 设置当前的返回信息
	 * 
	 * @param request
	 * @param code
	 * @return
	 */
	public String getMessage(String code) {
		if (messageSource == null) {
			messageSource = initMessageSource();
		}
		String lauage = defaultReturnLanguage;
		// 默认没有就是请求地区的语言
		Locale locale = null;
		if ("en-US".equals(lauage)) {
			locale = Locale.ENGLISH;
		} else if ("zh-CN".equals(lauage)) {
			locale = Locale.CHINA;
		} else {
			locale = Locale.CHINA;
		}
		String result = null;
		try {
			result = messageSource.getMessage(code, null, locale);
		} catch (NoSuchMessageException e) {
			logger.error("无法找到国际化的错误消息,消息代码为:{},错误描述详情:{}",code,e.getMessage());
		}
		if (result == null) {
			return code;
		}
		return result;
	}
}
