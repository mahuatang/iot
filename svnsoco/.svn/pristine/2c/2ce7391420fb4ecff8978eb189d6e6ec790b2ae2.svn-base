/**
 * Project Name:soco_iot
 * File Name:BaseJsonMsgTest.java
 * Package Name:com.soco.car.iot.server.app.message
 * Date:2018年8月8日下午4:08:02
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.app.message.request;

import java.util.Date;

import org.junit.Test;

import com.soco.car.iot.constants.SOCOIotConstant;
import com.soco.car.iot.server.app.message.request.BaseRequestMsg;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.utils.ByteUtils;
import com.soco.car.iot.utils.GsonUtil;
import com.soco.car.iot.utils.Hex;

/**
 * ClassName:BaseJsonMsgTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年8月8日 下午4:08:02 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class BaseRequestMsgTest {

	@Test
	public void testAppLogin() throws Exception {
		BaseMsg msg = new BaseMsg();
		msg.setDeviceNo("0868120197538942");
		msg.setMsgType("appLogin");
		msg.setToken("Bearer eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1MzQ3NTc2MTMsImFjY291bnQiOiI4Nl8xNzYwMjEwOTQ2OCJ9._dUjjAGpxmv1yYnlUmfNhtniXe3qFwTKwP_q6lHc6H0FotVDRyzUaVE6PVLF8vxEWAZiE8kWFeP1RtpEWpBdsg");
		String json = GsonUtil.GsonString(msg);
		byte[] jsonByte = json.getBytes(SOCOIotConstant.default_charset_utf8);
		System.out.println(json);
		System.out.println(Hex.encodeHexStr(jsonByte).length());
		System.out.println(ByteUtils.splitBlank(Hex.encodeHexStr(jsonByte)));
	}
	
	@Test
	public void testAppVehicleCheckup() throws Exception {
		BaseMsg msg = new BaseMsg();
		msg.setDeviceNo("0868120197538942");
		msg.setMsgType("appVehicleCheckup");
		String json = GsonUtil.GsonString(msg);
		byte[] jsonByte = json.getBytes(SOCOIotConstant.default_charset_utf8);
		System.out.println(json);
		System.out.println(Hex.encodeHexStr(jsonByte).length());
		System.out.println(ByteUtils.splitBlank(Hex.encodeHexStr(jsonByte)));
	}
	
	@Test
	public void testAppHeartbeat() throws Exception {
		BaseMsg msg = new BaseMsg();
		msg.setDeviceNo("0868120197538942");
		msg.setMsgType("appHeartbeat");
		String json = GsonUtil.GsonString(msg);
		byte[] jsonByte = json.getBytes(SOCOIotConstant.default_charset_utf8);
		System.out.println(json);
		System.out.println(Hex.encodeHexStr(jsonByte).length());
		System.out.println(ByteUtils.splitBlank(Hex.encodeHexStr(jsonByte)));
	}
}
