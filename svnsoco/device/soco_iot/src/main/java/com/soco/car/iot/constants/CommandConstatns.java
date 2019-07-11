/**
 * Project Name:SOCO_IOT
 * File Name:Command.java
 * Package Name:com.soco.car.iot.constants
 * Date:2018年7月11日上午8:55:20
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.constants;

/**
 * ClassName:Command <br/>
 * Reason: 指令常量类 <br/>
 * Date: 2018年7月11日 上午8:55:20 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class CommandConstatns {
	/**
	 * 7878指令
	 */
	public final static short COMMAND_7878 = 0x7878;
	/**
	 * 7979透传指令
	 */
	public final static short COMMAND_7979 = 0x7979;
	/**
	 * 一代ECU 指令
	 */
	public final static short COMMAND_2CC2 = 0x2cc2;
	/**
	 * 7979 透传协议标识符
	 */
	public final static byte PASSTHROUGH_AGREEMENT = (byte) 0x9c;
}
