/**
 * Project Name:soco_app
 * File Name:AccountUtil.java
 * Package Name:com.soco.car.app.utils
 * Date:2018年8月9日下午5:21:21
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

/**
 * ClassName:AccountUtil <br/>
 * Reason: 账户相关工具类. <br/>
 * Date: 2018年8月9日 下午5:21:21 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class AccountUtil {
	/**
	 * 中文语言代码列表
	 */
	private static String[] chinesePhoneCode = new String[] { "86" };

	/**
	 * 
	 * isChinese: 手机代码，判断是否是中文
	 *
	 * @author sunlangping
	 * @param phoneCode	手机代码
	 * @return
	 */
	public static boolean isChinese(String phoneCode) {
		Assert.isTrue(StringUtils.isNotEmpty(phoneCode), "手机代码不能为空！");
		boolean flag = false;
		for (String s : chinesePhoneCode) {
			if (s.equals(phoneCode)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * 
	 * getPhoneNumber: 账号解析手机号
	 *
	 * @author sunlangping	
	 * @param account		账户
	 * @return
	 */
	public static String getPhoneNumber(String account) {
		if (StringUtils.isEmpty(account) || account.indexOf("_") < 0) {
			throw new RuntimeException("手机号码不正确");
		}
		String[] strs = account.split("_");
		return strs[1];
	}

	/**
	 * 
	 * getPhoneCode: 获取手机代码
	 *
	 * @author sunlangping
	 * @param account		账户
	 * @return
	 */
	public static String getPhoneCode(String account) {
		if (StringUtils.isEmpty(account) || account.indexOf("_") < 0) {
			throw new RuntimeException("手机号码不正确");
		}
		String[] strs = account.split("_");
		return strs[0];
	}

	/**
	 * 
	 * combAccount: 将国家代码，手机号码组合成一个账户
	 *
	 * @author sunlangping
	 * @param phoneCode		手机代码
	 * @param phone			手机号码
	 * @return
	 */
	public static String combAccount(String phoneCode, String phone) {
		if (StringUtils.isEmpty(phoneCode) || StringUtils.isEmpty(phone)) {
			throw new RuntimeException("手机号码不正确");
		}
		return phoneCode + "_" + phone;
	}

	/**
	 * 
	 * isEmailAccount:判断是否邮箱帐号
	 *
	 * @author sunlangping
	 * @param account	账号
	 * @return
	 */
	public static boolean isEmailAccount(String account) {
		if (StringUtils.isEmpty(account)) {
			throw new RuntimeException("账号不能为空");
		}
		return account.indexOf("@") > -1;
	}
}
