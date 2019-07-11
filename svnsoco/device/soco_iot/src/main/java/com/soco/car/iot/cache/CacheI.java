/**
 * Project Name:SOCO_APP
 * File Name:CacheI.java
 * Package Name:com.soco.car.app.cache
 * Date:2018年7月24日下午8:57:12
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.cache;

import java.util.List;

/**
 * ClassName:CacheI <br/>
 * Reason: 缓存接口类 <br/>
 * Date: 2018年7月24日 下午8:57:12 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public interface CacheI<T> {

	public default void save(T t) {

	}

	public default void save(T t, int expire) {

	}

	public default void remove(String key) {

	}

	public default T get(String key) {
		return null;
	}

	public default List<T> getIds(List<String> ids) {
		return null;
	}
}
