/**
 * Project Name:SOCO_IOT
 * File Name:CRC16Test.java
 * Package Name:com.soco.car.iot.utils
 * Date:2018年7月13日上午10:41:41
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.utils;

import java.util.Date;

import org.junit.Test;

/**
 * ClassName:CRC16Test <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月13日 上午10:41:41 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class CRC16Test {

	@Test
	public void testCrc16Bytes7878() throws Exception {
		// byte[] bytes = new byte[] { 0x11, 0x01, 0x08, 0x68, 0x12, 0x01, (byte) 0x97,
		// 0x51, (byte) 0x86, (byte) 0x96,
		// 0x22, 0x06, 0x32, 0x02, 0x00, 0x09 };
		byte[] bytes = new byte[] { 0x00, 0x0d, (byte) 0x9b, 0x33, 0x2c, (byte) 0xc2, 0x00, 0x33, 0x00, 0x03, 0x00,
				(byte) 0xeb, (byte) 0x8b, 0x00, 0x00 };
		String hex = Hex.encodeHexStr(CRC16.crc16Bytes7878(bytes));
		System.out.println(hex);
	}

	@Test
	public void testBit() throws Exception {
		byte b = (byte) 0x06;
		System.out.println(byteToBit(b));
		System.out.println(byteToBit(b).length());
	}

	public static String byteToBit(byte b) {
		return "" + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1) + (byte) ((b >> 5) & 0x1)
				+ (byte) ((b >> 4) & 0x1) + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1) + (byte) ((b >> 1) & 0x1)
				+ (byte) ((b >> 0) & 0x1);
	}

	@Test
	public void testCrc16() throws Exception {
		// byte[] b=new byte[] {0x00,0x00,0x00,0x00,0x00,0x41,(byte)
		// 0xa0,0x49,0x00,0x00,0x01,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x3a,0x01,0x51,0x27};
		// byte[] b = new byte[] { 0x2c, (byte) 0xc2, 0x00, 0x32, 0x00, 0x16, 0x00,
		// 0x00, 0x00, 0x00, 0x00, 0x41, (byte) 0xa0,
		// 0x49, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x3a, 0x01,
		// 0x51, 0x27 };
		// byte[] a = new byte[] { 0x2c, (byte) 0xc2, 0x00, 0x32, 0x00, 0x03, (byte)
		// 0xd2, 0x76 };
		// byte[] b = new byte[] { 0x2c, (byte) 0xc2, 0x00, 0x32, 0x00, 0x03, 0x00,
		// (byte) 0x9d, 0x3f };
		// byte[] b = new byte[] { 0x2c, (byte) 0xc2, 0x00, 0x33, 0x00, 0x03, 0x00,
		// (byte) 0xeb, (byte) 0x8b };
		// byte[] b = new byte[] { 0x2c, (byte) 0xc2, 0x00, 0x33, 0x00, 0x03, 0x01 };
		byte[] b = new byte[] { 0x2C, (byte) 0xC2, 0x00, 0x36, 0x00, 0x09, 0x00, 0x00, 0x00, 0x00, 0x5E, 0x00, 0x00 };

		System.out.println(Hex.encodeHexStr(CRC16.crc16Bytes(b)));
	}

	@Test
	public void testSplit() throws Exception {
		String command = "797900219c022cc2003300150000000000000000010000000000000000000050cc0030c8ee";
		int len = command.length();
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < len; i++) {
			if (i % 2 == 0) {
				sbf.append(" ");
			}
			sbf.append(command.substring(i, i + 1));
		}
		System.out.println(sbf.toString());
	}

	@Test
	public void testDate() throws Exception {
		Date date = DateUtil.parseStrToDate("2018-08-12", "yyyy-MM-dd");
		int days = 5;
		Date timeoutTime = new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * days));

		System.out.println(DateUtil.formatDate(timeoutTime));
	}

	@Test
	public void testHex() throws Exception {
		byte[] hex = new byte[] { 0x0d, 0x0a };
		String str = new String(hex, "utf-8");
		System.out.println("开始");
		System.out.println(str);
		System.out.println("结束");
	}
}
