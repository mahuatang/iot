/**
 * Project Name:soco_app
 * File Name:Helper.java
 * Package Name:com.soco.car.app.utils
 * Date:2018年7月30日下午7:18:03
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.utils;

/**
 * ClassName:Helper <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月30日 下午7:18:03 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class Helper {

	public static boolean isStringInArray(String str, String[] array) {
		for (String val : array) {
			if (str.equals(val)) {
				return true;
			}
		}
		return false;
	}
}