/**
 * Project Name:SOCO_APP
 * File Name:TemplateEnum.java
 * Package Name:com.soco.car.app.constants
 * Date:2018年7月24日下午4:03:49
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.constants;

/**
 * ClassName:TemplateEnum <br/>
 * Reason: 短信模板 <br/>
 * Date: 2018年7月24日 下午4:03:49 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public enum AliSmsTemplateEnum {
	/**
	 * 注册帐号密码 英文
	 */
	register_account_en("register_account", "SMS_140731724"),
	/**
	 * 修改密码 英文
	 */
	modify_password_en("modify_password", "SMS_140721693"),
	/**
	 * 注册帐号密码 这噢乖问
	 */
	register_account_zh("register_account", "SMS_140860072"),
	/**
	 * 修改密码 中文
	 */
	modify_password_zh("modify_password", "SMS_140875059"),
	/**
	 * 英文签名
	 */
	sign_name_en("sign_name_en","SUPERSOCO"),
	/**
	 * 中文签名
	 */
	sign_name_zh("sign_name_zh","速珂智能");

	private String key;
	private String value;

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}

	private AliSmsTemplateEnum(String key, String value) {
		this.value = value;
	}
}
