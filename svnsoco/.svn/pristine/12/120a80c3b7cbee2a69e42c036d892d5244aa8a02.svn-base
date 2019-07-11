/**
 * Project Name:SOCO_APP
 * File Name:UserService.java
 * Package Name:com.soco.car.app.service
 * Date:2018年7月24日下午1:25:50
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.service;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.soco.car.app.api.request.MobileLoginRequest;
import com.soco.car.app.api.request.RegisterRequest;
import com.soco.car.app.api.request.SetPasswordRequest;
import com.soco.car.app.api.request.UserDataRequest;
import com.soco.car.app.api.response.BaseResponse;
import com.soco.car.app.api.response.UserLoginIntoResponse;
import com.soco.car.app.cache.CodeCache;
import com.soco.car.app.cache.TokenCache;
import com.soco.car.app.constants.AliSmsTemplateEnum;
import com.soco.car.app.constants.ResponseMessageEnum;
import com.soco.car.app.constants.SOCOAppConstant;
import com.soco.car.app.handler.BaseResponseGenerator;
import com.soco.car.app.sdk.ali.sms.AliSmsService;
import com.soco.car.app.utils.AccountUtil;
import com.soco.car.app.utils.PhoneUtil;
import com.soco.car.app.utils.RandomUtil;
import com.soco.car.app.utils.RandomUtils;
import com.soco.car.app.utils.RegexUtils;
import com.soco.car.bean.cache.CodePOJO;
import com.soco.car.bean.cache.TokenPOJO;
import com.soco.car.device.api.DeviceApi;
import com.soco.car.device.entity.ext.DeviceBindExt;
import com.soco.car.user.api.UserApi;
import com.soco.car.user.api.UserbinddeviceApi;
import com.soco.car.user.entity.PhoneVersion;
import com.soco.car.user.entity.User;

/**
 * ClassName:UserService <br/>
 * Reason: 用户相关服务. <br/>
 * Date: 2018年7月24日 下午1:25:50 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Reference
	private UserApi userApi;

	@Reference
	public DeviceApi deviceApi;

	@Reference
	public UserbinddeviceApi userbinddeviceApi;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private TokenCache tokenCache;

	@Autowired
	private AliSmsService aliSmsService;

	@Autowired
	private CodeCache codeCache;

	/**
	 * 
	 * register:注册
	 *
	 * @author sunlangping
	 * @param registerRequest
	 * @return
	 */
	public BaseResponse register(RegisterRequest registerRequest) {
		if(!PhoneUtil.isPhoneNumberValid(registerRequest.getPhoneCode(),registerRequest.getPhone())) {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.phone_format_error.getValue());
		}
		BaseResponse result = vaildateCode(registerRequest.getPhoneCode(), registerRequest.getPhone(),
				registerRequest.getVerificationCode());
		if (null != result) {
			return result;
		}
		String account = AccountUtil.combAccount(registerRequest.getPhoneCode(), registerRequest.getPhone());
		User u = userApi.findByAccount(account);
		if (u != null) {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.register_account_exist.getValue());
		}
		if (StringUtils.isNotEmpty(registerRequest.getEmail())) {
			if (!RegexUtils.checkEmail(registerRequest.getEmail())) {
				return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
						ResponseMessageEnum.email_format_error.getValue());
			}
		}
		
		User user = new User();
		user.setUserName(registerRequest.getPhone());
		user.setAccount(account);
		user.setRgsTime(new Date());
		user.setPassword(DigestUtils.md5Hex(registerRequest.getPassword()));
		user.setCountryCode(registerRequest.getCountryCode());
		user.setEmail(registerRequest.getEmail());
		String img = MessageFormat.format("{0}.png", RandomUtils.random1_10());
		// 注册时展示默认随机头像
		user.setUserAvatar("resource/upload/img/portrait/" + img);
		// user.set
		userApi.save(user);
		codeCache.remove(account);
		return BaseResponseGenerator.genSuccessResult(u);
	}

	/**
	 * 
	 * vaildateCode:通用验证代码模块
	 *
	 * @author sunlangping
	 * @param phoneCode
	 *            TODO
	 * @param phone
	 * @param code
	 * @return
	 */
	public BaseResponse vaildateCode(String phoneCode, String phone, String code) {
		String account = AccountUtil.combAccount(phoneCode, phone);
		CodePOJO codePOJO = codeCache.get(account);
		if (codePOJO == null) {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.verification_code_expire.getValue());
		}
		if (!StringUtils.equals(codePOJO.getCode(), code)) {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.verification_code_error.getValue());
		}
		return null;
	}

	/**
	 * 
	 * login:登录
	 *
	 * @author sunlangping
	 * @param loginRequest
	 * @return
	 */
	public BaseResponse login(MobileLoginRequest loginRequest) {
		if(!PhoneUtil.isPhoneNumberValid(loginRequest.getPhoneCode(),loginRequest.getPhone())) {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.phone_format_error.getValue());
		}
		String account = AccountUtil.combAccount(loginRequest.getPhoneCode(), loginRequest.getPhone());
		User u = userApi.findByAccount(account);
		if (u == null) {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.register_account_failure.getValue());
		}

		String md5Pwd = DigestUtils.md5Hex(loginRequest.getPassword());
		if (!StringUtils.equals(md5Pwd, u.getPassword())) {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.register_account_failure.getValue());
		}
		String token = jwtService.generateToken(account, u);
		u.setLastLoginTime(new Date());
		u.setSignLoginMark(token);
		u.setLat(loginRequest.getLat());
		u.setLng(loginRequest.getLng());
		userApi.save(u);
		saveLoginLog(loginRequest, u);
		// Long userId = u.getUserId();
		// UserLoginIntoResponse response = getUserBindDevice(userId);
		// response.setToken(token);
		// saveLoginLog(loginRequest, u);
		return BaseResponseGenerator.genSuccessResult(token);
	}

	/**
	 * 
	 * saveLoginLog:查询登录日志
	 *
	 * @author sunlangping
	 */
	private void saveLoginLog(MobileLoginRequest loginRequest, User user) {
		PhoneVersion phoneVersion = new PhoneVersion();
		phoneVersion.setUserId(user.getUserId());
		phoneVersion.setPhoneToken(loginRequest.getPhoneToken());
		phoneVersion.setPhoneType(loginRequest.getPhoneType());
		phoneVersion.setSystemName(loginRequest.getSystemName());
		phoneVersion.setUseTime(new Date());
		phoneVersion.setVersionName(loginRequest.getVersionName());
		phoneVersion.setVersionNo(loginRequest.getVersionNo());
		phoneVersion.setVersion(loginRequest.getVersion());
		userApi.savePhoneVersion(phoneVersion);
	}

	/**
	 * 获取用户信息和其绑定的设备
	 * 
	 * @param userId
	 * @return
	 */
	public UserLoginIntoResponse getUserBindDevice(TokenPOJO tokenPOJO) {
		User user = userApi.findByAccount(tokenPOJO.getAccount());
		DeviceBindExt destDevice = null;
		if (user != null) {
			destDevice=userbinddeviceApi.queryDeviceInfoByUserId(tokenPOJO.getUserId());
		}

		UserLoginIntoResponse response = new UserLoginIntoResponse();
		user.setPassword(null);
		response.setUser(user);
		response.setDevice(destDevice);
		return response;
	}

	/**
	 * 
	 * refresh:刷新token
	 *
	 * @author sunlangping
	 * @param tokenPOJO
	 *            TODO
	 * @return
	 */
	public BaseResponse refresh(TokenPOJO tokenPOJO) {
		String newToken = jwtService.generateToken(tokenPOJO.getAccount(), null);
		return BaseResponseGenerator.genSuccessResult(newToken);
	}

	public BaseResponse logout(TokenPOJO tokenPOJO) {
		tokenCache.remove(tokenPOJO.getAccount());
		return BaseResponseGenerator.genSuccessResult(null);
	}

	public BaseResponse sendRegisterCode(String phoneCode, String phone) {
		String templateId = null;
		if (AccountUtil.isChinese(phoneCode)) {
			templateId = AliSmsTemplateEnum.register_account_zh.getValue();
		} else {
			templateId = AliSmsTemplateEnum.register_account_en.getValue();
		}
		return sendCode(phoneCode, phone, templateId, true);
	}

	public BaseResponse sendModifyPasswordCode(String phoneCode, String phone) {
		String templateId = null;
		if (AccountUtil.isChinese(phoneCode)) {
			templateId = AliSmsTemplateEnum.modify_password_zh.getValue();
		} else {
			templateId = AliSmsTemplateEnum.modify_password_en.getValue();
		}
		return sendCode(phoneCode, phone, templateId, false);
	}

	public BaseResponse modifyPassword(RegisterRequest registerRequest) {
		BaseResponse result = vaildateCode(registerRequest.getPhoneCode(), registerRequest.getPhone(),
				registerRequest.getVerificationCode());
		if (result != null) {
			return result;
		}
		String account = AccountUtil.combAccount(registerRequest.getPhoneCode(), registerRequest.getPhone());
		User user = userApi.findByAccount(account);
		if (user == null) {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.register_account_not_exist.getValue());
		}
		user.setPassword(DigestUtils.md5Hex(registerRequest.getPassword()));
		user.setUpdateTime(new Date());
		userApi.save(user);
		codeCache.remove(account);
		return BaseResponseGenerator.genSuccessResult(null);
	}

	/**
	 * 
	 * sendCode:发送验证码
	 *
	 * @author sunlangping
	 * @param phoneCode
	 *            国家代码
	 * @param phone
	 *            手机号码
	 * @param templateId
	 *            发送短信的不同模板
	 * @param isVaildata
	 *            是否 验证手机号在系统中存在
	 * 
	 * @return
	 */
	private BaseResponse sendCode(String phoneCode, String phone, String templateId, boolean isVaildata) {
		if(!PhoneUtil.isPhoneNumberValid(phoneCode, phone)) {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.phone_format_error.getValue());
		}
		if (isVaildata) {
			User user = userApi.findByAccount(AccountUtil.combAccount(phoneCode, phone));
			if (user != null) {
				return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
						ResponseMessageEnum.register_account_exist.getValue());
			}
		}
		String randomCode = saveCodeCache(phoneCode, phone, templateId);
		logger.info("短信操作类型:{},手机号码为:{},短信验证码为:{}", templateId, phone, randomCode);
		Map<String, String> variableMap = new HashMap<>();
		variableMap.put("code", randomCode);
		
		return aliSmsService.sendSms(phoneCode, phone, templateId, variableMap);
	}

	private String saveCodeCache(String phoneCode, String phone, String smsTemplate) {
		String randomCode = RandomUtil.getRandomForSix();
		CodePOJO codePOJO = new CodePOJO();
		codePOJO.setCode(randomCode);
		codePOJO.setTemplateId(smsTemplate);
		codePOJO.setAccount(AccountUtil.combAccount(phoneCode, phone));
		codeCache.save(codePOJO);
		return randomCode;
	}

	public BaseResponse switchOffNO(TokenPOJO token, Integer isWarnPush) {
		User user = new User();
		user.setUserId(token.getUserId());
		user.setAccount(token.getAccount());
		user.setIsWarnPush(isWarnPush);
		userApi.save(user);
		return BaseResponseGenerator.genSuccessResult(null);
	}

	public BaseResponse historyLocusSwitch(TokenPOJO token, Integer historyLocusSwitch) {
		User user = new User();
		user.setAccount(token.getAccount());
		user.setHistoryLocusSwitch(historyLocusSwitch);
		userApi.save(user);
		return BaseResponseGenerator.genSuccessResult(null);
	}

	public BaseResponse modifyUser(TokenPOJO tokenPOJO, UserDataRequest userDataRequest) {
		if (StringUtils.isNotEmpty(userDataRequest.getEmail())) {
			if (!RegexUtils.checkEmail(userDataRequest.getEmail())) {
				return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
						ResponseMessageEnum.email_format_error.getValue());
			}
		}
		User u = userApi.findByAccount(tokenPOJO.getAccount());
		u.setUpdateTime(new Date());
		u.setUserAvatar(userDataRequest.getUserAvatar());
		u.setUserName(userDataRequest.getUserName());
		u.setSex(userDataRequest.getSex());
		u.setIndustry(userDataRequest.getIndustry());
		u.setEmail(userDataRequest.getEmail());
		u.setAddress(tokenPOJO.getAddress());
		userApi.save(u);
		return BaseResponseGenerator.genSuccessResult(null);
	}

	public BaseResponse verifyCode(RegisterRequest registerRequest) {
		BaseResponse result = vaildateCode(registerRequest.getPhoneCode(), registerRequest.getPhone(),
				registerRequest.getVerificationCode());
		if (result != null) {
			return result;
		}
		return BaseResponseGenerator.genSuccessResult("短信验证码正确");
	}

	public BaseResponse modifyPasswordWithoutVerify(SetPasswordRequest setPasswordRequest) {
		BaseResponse result = vaildateCode(setPasswordRequest.getPhoneCode(), setPasswordRequest.getPhone(),
				setPasswordRequest.getVerificationCode());
		if (result != null) {
			return result;
		}
		String account = AccountUtil.combAccount(setPasswordRequest.getPhoneCode(), setPasswordRequest.getPhone());
		User user = userApi.findByAccount(
				AccountUtil.combAccount(setPasswordRequest.getPhoneCode(), setPasswordRequest.getPhone()));
		if (user == null) {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.register_account_not_exist.getValue());
		}
		user.setPassword(DigestUtils.md5Hex(setPasswordRequest.getPassword()));
		user.setUpdateTime(new Date());
		userApi.save(user);
		codeCache.remove(account);
		return BaseResponseGenerator.genSuccessResult(null);
	}
}