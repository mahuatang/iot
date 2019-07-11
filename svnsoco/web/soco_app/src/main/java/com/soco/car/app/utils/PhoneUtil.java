package com.soco.car.app.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class PhoneUtil {
	private static final Logger logger = LoggerFactory.getLogger(PhoneUtil.class);
	
	public static PhoneNumberUtil phoneUtil;
	static {
		phoneUtil = PhoneNumberUtil.getInstance();
	}

	/**
	 * 验证手机号码的合法性,支持国际化
	 * 
	 * @param phoneCode
	 * @param phoneNumber
	 * @return
	 */
	public static boolean isPhoneNumberValid(String phoneCode, String phoneNumber) {
		try {
			PhoneNumber pn = new PhoneNumber();
			pn.setCountryCode(Integer.parseInt(phoneCode));
			pn.setNationalNumber(Long.parseLong(phoneNumber));
			return phoneUtil.isValidNumber(pn);
		} catch (Exception e) {
			logger.error("isPhoneNumberValid NumberParseException was thrown: " + e.toString());
		}
		return false;
	}
}
