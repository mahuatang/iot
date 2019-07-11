/**
 * Project Name:SOCO_APP
 * File Name:CacheExpireEnum.java
 * Package Name:com.soco.car.app.constants
 * Date:2018年7月24日下午8:52:27
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.constants;

/**
 * ClassName:CacheExpireEnum <br/>
 * Reason: redis缓存过期时间设置. <br/>
 * Date: 2018年7月24日 下午8:52:27 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public enum CacheExpireEnum {
	/**
	 * 5分钟过期
	 */
	minute_5(5),
	/**
	 * 30分钟过期
	 */
	minute_30(30);

	private int value;

	private CacheExpireEnum(Integer value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
