/**
 * Project Name:SOCO_IOT
 * File Name:GpsConvertTest.java
 * Package Name:com.soco.car.iot.message.car.convert
 * Date:2018年7月17日上午9:56:53
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.convert;

import java.util.Date;

import org.junit.Test;

import com.soco.car.iot.server.car.message.convert.GpsConvert;

/**
 * ClassName:GpsConvertTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月17日 上午9:56:53 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class GpsConvertTest {

	@Test
	public void testConvertDate() throws Exception {
		GpsConvert gps = new GpsConvert();
		byte[] dateByte = new byte[] { 0x0F, 0x0C, 0x1D, 0x03, 0x0B, 0x26 };
		Date date = gps.convertDate(dateByte);
		System.out.println(date);
	}

	@Test
	public void testGeo() throws Exception {
		GpsConvert gps = new GpsConvert();
		byte[] lnt = new byte[] { 0x02, 0x7A, (byte) 0xC8, 0x18 };
		byte[] lat = new byte[] { 0x0C, 0x46, 0x58, 0x60 };
		double lntb = gps.convertGeo(lnt);
		double latb = gps.convertGeo(lat);
		System.out.println(lntb + "," + latb);
	}

	@Test
	public void testByte2String() throws Exception {
		byte command = 0x78;
		byte protocol = 0x01;
		System.out.println(command + "_" + protocol);
	}

}
