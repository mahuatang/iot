/**
 * Project Name:SOCO_IOT
 * File Name:SOCOIotConstant.java
 * Package Name:com.soco.car.iot.constants
 * Date:2018年7月9日上午3:43:50
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.constants;

import java.util.concurrent.atomic.LongAdder;

/**
 * ClassName:SOCOIotConstant <br/>
 * Reason: 车联网常量类 <br/>
 * Date: 2018年7月9日 上午3:43:50 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class SOCOIotConstant {

	/**
	 * 拆包，沾包 统一标志符
	 */
	public static final byte[] STOP_INDEX = new byte[] { 0x0D, 0x0A };
	/**
	 * 透传协议
	 */
	public static final byte PASSTHROUGH = (byte) 0x9b;
	/**
	 * 设备哈希表
	 */
	public static final String DEVICE_HASH = "device";
	/**
	 * 所有在线的车辆信息
	 */
	public static final LongAdder online_car_number = new LongAdder();

	/**
	 * 所有在线的APP信息
	 */
	public static final LongAdder online_app_number = new LongAdder();
	/**
	 * 默认传输字符集
	 */
	public static final String default_charset_utf8 = "utf-8";
	/**
	 * 手机操作系统为苹果
	 */
	public static final String APP_SYSTEM_IOS = "IOS";
	/**
	 * 手机操作系统为安卓
	 */
	public static final String APP_SYSTEM_ANDROID = "android";
	/**
	 * 通用标识符true,或者标志1
	 */
	public static final Integer Y = 1;
	/**
	 * 通用标识符false,或者标志0
	 */
	public static final Integer N = 0;
}
