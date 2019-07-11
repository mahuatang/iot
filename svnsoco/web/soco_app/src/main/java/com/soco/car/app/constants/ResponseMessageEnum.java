/**
 * Project Name:SOCO_APP
 * File Name:ResponseEnum.java
 * Package Name:com.soco.car.app.constants
 * Date:2018年7月23日下午1:14:37
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.constants;

/**
 * ClassName:ResponseEnum <br/>
 * Reason: 相应的消息枚举 <br/>
 * Date: 2018年7月23日 下午1:14:37 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public enum ResponseMessageEnum {
	/**
	 * 登录成功
	 */
	login_success("message.login.success"),
	/**
	 * 登录失败
	 */
	login_failure("message.login.failure"),
	/**
	 * 注册失败
	 */
	register_failure("message.register.failure"),
	/**
	 * 账户已存在
	 */
	register_account_exist("message.register.account.exist"),
	/**
	 * 账户不存在
	 */
	register_account_not_exist("message.register.account.not.exist"),
	/**
	 * token验证获取失效
	 */
	token_expire("message.token.expire"),
	/**
	 * 传入的参数有误
	 */
	params_error("message.params.error"),
	/**
	 * 处理成功
	 */
	success("message.success"),
	/**
	 * 系统错误
	 */
	error("message.error"),
	/**
	 * 账户或密码错误
	 */
	register_account_failure("message.account.failure"),
	/**
	 * 上传文件超出最大
	 */
	max_upload_size_exceeded("message.max.upload.size.exceeded"),
	/**
	 * 验证码过期
	 */
	verification_code_expire("message.verification.code.expire"),
	/**
	 * 设备已被其他用户绑定
	 */
	device_already_bind("message.device.already.bind"),
	/**
	 * 绑定的中控号不存在
	 */
	device_number_not_exist("message.number.not.exist"),
	/**
	 * 用户已绑定其他设备
	 */
	user_already_bind_other_device("message.user.already.bind.other.device"),
	/**
	 * 用户绑定的设备超过了5辆
	 */
	user_bind_device_times_exceed_five("message.bind.device.times.exceed.five"),
	/**
	 * 设备已被该用户绑定
	 */
	user_already_bind_device("message.user.already.bind.device"),
	/**
	 * 查询不到用户
	 */
	user_not_exists("message.user.not.exists"),
	/**
	 * 版本已是最新
	 */
	device_bind_success("message.device.bind.success"),
	/**
	 * 解除绑定成功
	 */
	device_un_bind_success("message.device.un.bind.success"),
	/**
	 * 解除绑定失败
	 */
	device_un_bind_fail("message.device.un.bind.fail"),
	/**
	 * 没有绑定设备,无需解绑
	 */
	device_un_bind_error("message.device.un.bind.error"),
	/**
	 * 没有查询到预警信息
	 */
	device_warn_not_found("message.device.warn.not.found"),
	/**
	 * 设备NO有误,没有查询到设备
	 */
	device_no_error("message.device.no.error"),
	/**
	 * 绑定失败
	 */
	device_bind_fail("message.device.bind.fail"),
	/**
	 * 查询版本更新错误
	 */
	is_update_version_fail("message.is.update.version.fail"),
	/**
	 * 查询新手教程失败
	 */
	device_course_url_not_found("message.course.url.no.found"),
	/**
	 * 查询类型为空
	 */
	query_model_null("message.query.model.null"),
	/**
	 * 查询类型错误
	 */
	query_model_error("message.query.model.error"),
	/**
	 * 序列号有误
	 */
	serial_number_wrong("serial_number_wrong"),
	/**
	 * 上传文件超出最大10MB
	 */
	verification_code_error("message.verification.code.error"),
	/**
	 * 参数json错误
	 */
	params_json_error("message.params.json.error"),
	/**
	 * message.auth.null.error=授权信息为空，请检查是否携带token
	 */
	params_auth_null_error("message.auth.null.error"),
	/**
	 * 版本已是最新
	 */
	version_is_new("message.version.is.new"),
	/**
	 * 发现新版本
	 */
	find_new_version("message.find.new.version"),
	/**
	 * 您发出的请求系统不支持此协议，目前只支持post请求
	 */
	request_not_support("message.request.not.support"),
	/**
	 * 输入的手机号码格式有误,请检查
	 */
	phone_format_error("message.phone.format.error"),
	/**
	 * 发送短信的手机号码格式有误
	 */
	mobile_number_illegal("message.mobile.number.illegal"),
	/**
	 * 发送短信过于频繁,请稍后再发送短信
	 */
	business_limit_control("message.business.limit.control"),
	/**
	 * 发送短信异常,请稍后再试
	 */
	send_ali_sms_error("message.send.ali.sms.error"),
	/**
	 * 邮箱格式不正确
	 */
	email_format_error("message.email.format.error");
	
	
	private String value;

	private ResponseMessageEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
