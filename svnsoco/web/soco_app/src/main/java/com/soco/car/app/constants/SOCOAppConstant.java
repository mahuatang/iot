/**
 * Project Name:SOCO_Report
 * File Name:SOCOReportConstant.java
 * Package Name:com.soco.car.report.constants
 * Date:2018年6月22日下午2:33:25
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.constants;

/**
 * ClassName:SOCOReportConstant <br/>
 * Reason: 报表相关常量库 <br/>
 * Date: 2018年6月22日 下午2:33:25 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class SOCOAppConstant {

	/**
	 * 请求成功状态200 区间
	 */
	public final static String ERROR_CODE_200 = "200";
	/**
	 * 参数错误，业务错误400区间
	 */
	public final static String ERROR_CODE_400 = "400";
	/**
	 * 权限认证错误
	 */
	public final static String ERROR_CODE_403 = "403";
	/**
	 * 系统错误，500区间
	 */
	public final static String ERROR_CODE_500 = "500";
	/**
	 * 对应字典的值
	 */
	public final static String IMAGE_PATH = "IMAGE_PATH";
	/**
	 * 删除标志位 1代表删除
	 */
	public final static Integer DELETE_FLAG_Y = 1;
	/**
	 * 删除标志位 0代表未删除
	 */
	public final static Integer DELETE_FLAG_N = 0;

	/**
	 * 系统版本安卓
	 */
	public static final Long CONFIG_TYPE_ANDROID = 1L;
	/**
	 * 系统版本IOS
	 */
	public static final Long CONFIG_TYPE_IOS = 2L;
	/**
	 * 系统IOS
	 */
	public static final String SYSTEM_IOS = "ios";
	/**
	 * 版本控制不需要升级
	 */
	public static final Integer UPGRADE_TYPE_NO = 0;
	/**
	 * 默认车型
	 */
	public static final String DEFAULT_CAR_MODEL_TYPE = "TS";
	/**
	 * 用户头像存储常量类
	 */
	public static final String IMAGE_HEAD_PORTRAIT = "IMAGE_HEAD_PORTRAIT";
	/**
	 * 阿里短信发送成功
	 */
	public static final String SEND_ALI_SMS_SUCCESS = "OK";

}