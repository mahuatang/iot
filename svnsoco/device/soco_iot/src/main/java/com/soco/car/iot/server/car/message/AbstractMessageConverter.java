/**
 * Project Name:SOCO_IOT
 * File Name:AbMessageConverter.java
 * Package Name:com.soco.car.iot.message
 * Date:2018年7月17日上午9:36:24
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message;
/**
 * ClassName:AbMessageConverter <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年7月17日 上午9:36:24 <br/>
 * @author   sunlangping
 * @version  
 * @see 	 
 */

import java.util.Calendar;
import java.util.Date;

import com.soco.car.iot.utils.ByteUtils;

public abstract class AbstractMessageConverter implements MessageConverter {

	/**
	 * 
	 * convertGeo: 经纬度字节转换成 经纬度信息
	 *
	 * @author sunlangping
	 * @param geoByte
	 * @return
	 */
	public double convertGeo(byte[] geoByte) {
		double geo = 0d;
		int i = ByteUtils.byte4ToInt(geoByte);
		geo = i / 1800000d;
		return geo;
	}

	/**
	 * 
	 * convertDate:时间字节转换成时间
	 *
	 * @author sunlangping
	 * @param dateByte
	 * @return
	 */
	public Date convertDate(byte[] dateByte) {
		Calendar calendar = Calendar.getInstance();
		byte year = dateByte[0];
		byte month = dateByte[1];
		byte day = dateByte[2];
		byte hour = dateByte[3];
		byte minute = dateByte[4];
		byte second = dateByte[5];
		calendar.set(year, month, day, hour, minute, second);
		return calendar.getTime();
	}

	public byte[] convertByteToBit(byte b) {
		return ByteUtils.getBooleanArray(b);
	}

	public byte[] generateResponse7979(byte msg) {
		return null;
	}
}
