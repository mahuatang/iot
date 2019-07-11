/**
 * Project Name:SOCO_IOT
 * File Name:GpsConvert.java
 * Package Name:com.soco.car.iot.message.car.convert
 * Date:2018年7月17日上午9:12:07
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.convert;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.soco.car.iot.annotation.AuthAnnotation;
import com.soco.car.iot.annotation.AuthAnnotation.Auth;
import com.soco.car.iot.server.car.message.AbstractMessageConverter;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.server.car.message.msg.GpsMsg;
import com.soco.car.iot.utils.ByteUtils;

import io.netty.channel.Channel;

/**
 * ClassName:GpsConvert <br/>
 * Reason: GPS位置信息上传 <br/>
 * Date: 2018年7月17日 上午9:12:07 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class GpsConvert extends AbstractMessageConverter {

	private String msgType = "gps";

	@Override
	@AuthAnnotation(value = Auth.AUTH_DEVICE)
	public BaseMsg convert2Message(Channel channel, byte[] msg) {
		GpsMsg gpsMsg = new GpsMsg();
		byte[] command = Arrays.copyOfRange(msg, 0, 2);
		byte contentLength = Arrays.copyOfRange(msg, 2, 3)[0];
		byte protocol = Arrays.copyOfRange(msg, 3, 4)[0];
		byte[] dateB = Arrays.copyOfRange(msg, 4, 10);
		byte gps = Arrays.copyOfRange(msg, 10, 11)[0];
		byte[] latitude = Arrays.copyOfRange(msg, 11, 15);
		byte[] longitude = Arrays.copyOfRange(msg, 15, 19);
		byte sleep = Arrays.copyOfRange(msg, 19, 20)[0];
		byte[] orientationState = Arrays.copyOfRange(msg, 20, 22);
		short mcc = ByteUtils.byte2ToShort(Arrays.copyOfRange(msg, 20, 22));
		byte mnc = Arrays.copyOfRange(msg, 22, 23)[0];
		short lac = ByteUtils.byte2ToShort(Arrays.copyOfRange(msg, 23, 25));
		String cellId = ByteUtils.byte4ToIntAuto(Arrays.copyOfRange(msg, 25, 28)) + "";
		byte acc = Arrays.copyOfRange(msg, 28, 29)[0];
		byte dataReportModel = Arrays.copyOfRange(msg, 29, 30)[0];
		
		gpsMsg.setProtocol(protocol);
		gpsMsg.setDate(convertDate(dateB));
		gpsMsg.setGps(gps);
		gpsMsg.setLatitude(convertGeo(latitude));
		gpsMsg.setLongitude(convertGeo(longitude));
		gpsMsg.setSleep(sleep);
		gpsMsg.setOrientationState(orientationState);
		gpsMsg.setMcc(mcc);
		gpsMsg.setMnc(mnc);
		gpsMsg.setLac(lac);
		gpsMsg.setCellId(cellId);
		gpsMsg.setAcc(acc);
		gpsMsg.setDataReportModel(dataReportModel);
		gpsMsg.setMsgType(msgType);
		gpsMsg.setRequestContent(msg);
		
		return gpsMsg;
	}

	/**
	 * 
	 * GPS上传协议
	 * 
	 * @see com.soco.car.iot.server.car.message.MessageConverter#supportProcotol()
	 */
	@Override
	public byte supportProcotol() {
		return 0x22;
	}

}
