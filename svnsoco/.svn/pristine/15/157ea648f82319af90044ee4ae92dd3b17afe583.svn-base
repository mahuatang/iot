/**
 * Project Name:soco_iot
 * File Name:AuthAnnotation.java
 * Package Name:com.soco.car.iot
 * Date:2018年8月2日下午4:02:37
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:AuthAnnotation <br/>
 * Reason: 权限检查拦截器,设备,手机,后台管理平台 <br/>
 * Date: 2018年8月2日 下午4:02:37 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthAnnotation {

	public enum Auth {
		/**
		 * 设备权限检查
		 */
		AUTH_DEVICE,
		/**
		 * APP权限检查
		 */
		AUTH_APP,
		/**
		 * 后台权限检查
		 */
		AUTH_PLAT
	}

	Auth value();
}
