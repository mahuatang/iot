/**
 * Project Name:SOCO_IOT
 * File Name:SpringUtil.java
 * Package Name:com.soco.car.iot.service
 * Date:2018年7月12日下午3:27:28
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ClassName:SpringUtil <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月12日 下午3:27:28 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Component
public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringUtil.applicationContext == null) {
			SpringUtil.applicationContext = applicationContext;
		}
	}

	/**
	 * 
	 * getApplicationContext: 获取applicationContext
	 *
	 * @author sunlangping
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 
	 * getBean: 通过name获取 Bean.
	 *
	 * @author sunlangping
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

	/**
	 * 
	 * getBean: 通过class获取Bean.
	 *
	 * @author sunlangping
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

}
