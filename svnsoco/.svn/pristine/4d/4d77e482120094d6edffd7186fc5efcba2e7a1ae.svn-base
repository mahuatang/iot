/**
 * Project Name:soco_app
 * File Name:AliSmsService.java
 * Package Name:com.soco.car.app.sdk.ali.sms
 * Date:2018年7月28日下午2:05:53
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.sdk.ali.sms;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.soco.car.app.api.response.BaseResponse;
import com.soco.car.app.constants.AliSmsTemplateEnum;
import com.soco.car.app.constants.ResponseMessageEnum;
import com.soco.car.app.constants.SOCOAppConstant;
import com.soco.car.app.handler.BaseResponseGenerator;
import com.soco.car.app.utils.AccountUtil;
import com.soco.car.app.utils.GsonUtil;
import com.soco.car.user.api.UserApi;
import com.soco.car.user.entity.SmsLog;

/**
 * ClassName:AliSmsService <br/>
 * Reason: 阿里发送短信服务 <br/>
 * Date: 2018年7月28日 下午2:05:53 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class AliSmsService {

	private static final Logger logger = LoggerFactory.getLogger(AliSmsService.class);
	/**
	 * 将短信发送频率限制在正常的业务流控范围内，默认流控：短信验证码 ：使用同一个签名，对同一个手机号码发送短信验证码，支持1条/分钟，5条/小时 ，累计10条/天
	 */
	private String MOBILE_NUMBER_ILLEGAL = "isv.MOBILE_NUMBER_ILLEGAL";
	/**
	 * 非法手机号
	 */
	private String BUSINESS_LIMIT_CONTROLL = "isv.BUSINESS_LIMIT_CONTROLL";

	@Autowired
	private IAcsClient acsClient;

	@Value("${ali.sms.switch}")
	private boolean aliSmsSwitch;

	@Reference
	private UserApi userApi;

	/**
	 * 
	 * sendSms: 发送短信
	 *
	 * @author sunlangping
	 * @param phoneCode
	 * 
	 * @param phone
	 * @param templateId
	 * @param variableMap
	 * @return TODO
	 */
	public BaseResponse sendSms(String phoneCode, String phone, String templateId, Map<String, String> variableMap) {
		String newPhone = null;
		String singName = null;
		if (AccountUtil.isChinese(phoneCode)) {
			newPhone = phone;
			singName = AliSmsTemplateEnum.sign_name_zh.getValue();
		} else {
			// 国家短信格式为00开头+国家手机代码+手机号码
			newPhone = "00" + phoneCode + phone;
			singName = AliSmsTemplateEnum.sign_name_en.getValue();
		}
		SendSmsRequest request = new SendSmsRequest();
		request.setPhoneNumbers(newPhone);
		request.setSignName(singName);
		request.setTemplateCode(templateId);

		request.setTemplateParam(GsonUtil.GsonString(variableMap));
		SendSmsResponse response = null;
		try {
			if (aliSmsSwitch) {
				response = acsClient.getAcsResponse(request);
				logger.info("send message response:{}" + response);
			}
			saveSmsLog(templateId, variableMap, newPhone, response);
		} catch (ServerException e) {
			logger.info("sendSms:" + e.getMessage());
		} catch (ClientException e) {
			logger.info("sendSms:" + e.getMessage());
		}
		if (response != null && SOCOAppConstant.SEND_ALI_SMS_SUCCESS.equals(response.getCode())) {
			return BaseResponseGenerator.genSuccessResult(null);
		}
		if (MOBILE_NUMBER_ILLEGAL.equals(response.getCode())) {
			return BaseResponseGenerator.genErrorResult(ResponseMessageEnum.mobile_number_illegal.getValue());
		}
		if (BUSINESS_LIMIT_CONTROLL.equals(response.getCode())) {
			return BaseResponseGenerator.genErrorResult(ResponseMessageEnum.business_limit_control.getValue());
		}
		return BaseResponseGenerator.genErrorResult(ResponseMessageEnum.send_ali_sms_error.getValue());
	}

	/**
	 * 
	 * saveSmsLog: j
	 *
	 * @author sunlangping
	 * @param templateId
	 * @param variableMap
	 * @param newPhone
	 * @param response
	 */
	private void saveSmsLog(String templateId, Map<String, String> variableMap, String newPhone,
			SendSmsResponse response) {
		SmsLog smsLog = new SmsLog();
		smsLog.setAccount(newPhone);
		if (response != null) {
			smsLog.setRequestId(response.getRequestId());
			smsLog.setBizId(response.getBizId());
			smsLog.setCode(response.getCode());
			smsLog.setMessage(response.getMessage());
		}
		smsLog.setTemplateId(templateId);
		smsLog.setVariable(GsonUtil.GsonString(variableMap));
		userApi.saveSmsLog(smsLog);
	}

}
