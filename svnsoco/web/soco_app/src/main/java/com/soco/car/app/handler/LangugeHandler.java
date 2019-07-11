/**
 * Project Name:SOCO_APP
 * File Name:LangugeHandle.java
 * Package Name:com.soco.car.app.controller
 * Date:2018年7月23日上午11:34:33
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.handler;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.soco.car.app.annotation.SerializedField;
import com.soco.car.app.api.response.BaseResponse;
import com.soco.car.app.service.I18nService;
import com.soco.car.app.utils.Helper;

/**
 * ClassName:LangugeHandle <br/>
 * Reason: 语言返回值拦截器. <br/>
 * Date: 2018年7月23日 上午11:34:33 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@ControllerAdvice
public class LangugeHandler implements ResponseBodyAdvice<Object> {

	private final static Logger logger = LoggerFactory.getLogger(LangugeHandler.class);

	/**
	 * 包含项
	 */
	private String[] includes = {};
	/**
	 * 排除项
	 */
	private String[] excludes = {};

	@Autowired
	private I18nService i18n;

	/**
	 * 返回之前业务逻辑处理
	 * 
	 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice#beforeBodyWrite(java.lang.Object,
	 *      org.springframework.core.MethodParameter,
	 *      org.springframework.http.MediaType, java.lang.Class,
	 *      org.springframework.http.server.ServerHttpRequest,
	 *      org.springframework.http.server.ServerHttpResponse)
	 */
	@Override
	public Object beforeBodyWrite(Object response, MethodParameter methodParameter, MediaType mediaType, Class Classz,
			ServerHttpRequest httpRequest, ServerHttpResponse httpResponse) {
		if (response instanceof BaseResponse) {
			BaseResponse baseResponse = (BaseResponse) response;
			if (logger.isDebugEnabled()) {
				logger.debug("response:{}", baseResponse);
			}
			if (baseResponse != null) {
				// 将错误代码转换成国际化消息内容处理
				baseResponse.setMessage(i18n.getMessage(baseResponse.getMessage()));
			}
			Object o = baseResponse.getData();
			if (o == null) {
				return baseResponse;
			}
			if (methodParameter.getMethod().isAnnotationPresent(SerializedField.class)) {
				// 获取注解配置的包含和去除字段
				SerializedField serializedField = methodParameter.getMethodAnnotation(SerializedField.class);
				includes = serializedField.includes();
				excludes = serializedField.excludes();
				excludes = Arrays.copyOf(serializedField.excludes(), serializedField.excludes().length + 1);
				//默认排除此字段
				excludes[excludes.length - 1] = "serialVersionUID";
				Object retObj = null;
				if (o instanceof List) {
					// List
					List list = (List) o;
					retObj = handleList(list);
				} else {
					// Single Object
					retObj = handleSingleObject(o);
				}
				if (retObj != null) {
					baseResponse.setData(retObj);
				}
			}
		}

		return response;
	}

	/**
	 * 判断拦截哪些
	 * 
	 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice#supports(org.springframework.core.MethodParameter,
	 *      java.lang.Class)
	 */
	@Override
	public boolean supports(MethodParameter methodParameter, Class classz) {
		return true;
	}

	/**
	 * 处理返回值是单个enity对象
	 *
	 * @param o
	 * @return
	 */
	private Object handleSingleObject(Object o) {
		Map<String, Object> map = new HashMap<String, Object>();

		Field[] fields = o.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				// 如果未配置表示全部的都返回
				if (includes.length == 0 && excludes.length == 0) {
					// if (null != field.get(o)) {
					map.put(field.getName(), field.get(o));
					// }
				} else if (includes.length > 0) {
					// 有限考虑包含字段
					if (Helper.isStringInArray(field.getName(), includes)) {
						// if (null != field.get(o)) {
						map.put(field.getName(), field.get(o));
						// }
					}
				} else {
					// 去除字段
					if (excludes.length > 0) {
						if (!Helper.isStringInArray(field.getName(), excludes)) {
							// if (null != field.get(o)) {
							map.put(field.getName(), field.get(o));
							// }
						}
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
		return map;
	}

	/**
	 * 处理返回值是列表
	 *
	 * @param list
	 * @return
	 */
	private List handleList(List list) {
		List retList = new ArrayList();
		for (Object o : list) {
			Map map = (Map) handleSingleObject(o);
			retList.add(map);
		}
		return retList;
	}

}
