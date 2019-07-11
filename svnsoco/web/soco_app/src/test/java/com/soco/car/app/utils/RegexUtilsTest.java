/**
 * Project Name:soco_app
 * File Name:RegexUtilsTest.java
 * Package Name:com.soco.car.app.utils
 * Date:2018年8月16日下午10:25:42
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.utils;

import org.junit.Test;

/**
 * ClassName:RegexUtilsTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年8月16日 下午10:25:42 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class RegexUtilsTest {

	@Test
	public void testCheckEmail() throws Exception {
		String email = "paco_sun@qq.com";
		System.out.println(RegexUtils.checkEmail(email));
	}

}
