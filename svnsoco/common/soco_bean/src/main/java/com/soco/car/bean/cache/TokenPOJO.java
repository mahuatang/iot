/**
 * Project Name:SOCO_APP
 * File Name:UserPOJO.java
 * Package Name:com.soco.car.app.pojo
 * Date:2018年7月24日下午9:01:47
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.bean.cache;

import com.soco.car.user.entity.User;

/**
 * ClassName:UserPOJO <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月24日 下午9:01:47 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class TokenPOJO extends User {

	private static final long serialVersionUID = -3080583148255120435L;

	/**
	 * 手机号码
	 */
	private String account;

	private String token;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TokenPOJO [");
		if (account != null) {
			builder.append("account=");
			builder.append(account);
			builder.append(", ");
		}
		if (token != null) {
			builder.append("token=");
			builder.append(token);
		}
		builder.append("]");
		return builder.toString();
	}

}
