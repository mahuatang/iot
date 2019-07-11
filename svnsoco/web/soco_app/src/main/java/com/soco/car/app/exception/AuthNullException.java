/**
 * Project Name:SOCO_APP
 * File Name:AuthException.java
 * Package Name:com.soco.car.app.exception
 * Date:2018年7月23日下午4:22:24
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.exception;

/**
 * ClassName:AuthException <br/>
 * Reason: 认证错误异常通用处理类. <br/>
 * Date: 2018年7月23日 下午4:22:24 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class AuthNullException extends RuntimeException {

	private static final long serialVersionUID = -5997462532200758869L;

	public AuthNullException() {
		super();
	}

	public AuthNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AuthNullException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthNullException(String message) {
		super(message);
	}

	public AuthNullException(Throwable cause) {
		super(cause);
	}

}
