/**
 * Project Name:soco_iot
 * File Name:AlarmConvert.java
 * Package Name:com.soco.car.iot.message.car.convert
 * Date:2018年8月4日上午2:22:01
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car.message.convert;

import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.soco.car.iot.annotation.AuthAnnotation;
import com.soco.car.iot.annotation.AuthAnnotation.Auth;
import com.soco.car.iot.constants.SOCOIotConstant;
import com.soco.car.iot.server.car.message.AbstractMessageConverter;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.server.car.message.msg.AlarmMsg;
import com.soco.car.iot.utils.ByteUtils;
import com.soco.car.iot.utils.CRC16;

import io.netty.channel.Channel;

/**
 * ClassName:AlarmConvert <br/>
 * Reason: 报警包转换类 <br/>
 * Date: 2018年8月4日 上午2:22:01 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class AlarmConvert extends AbstractMessageConverter {

	private String msgType = "gps";

	@AuthAnnotation(Auth.AUTH_DEVICE)
	@Override
	public BaseMsg convert2Message(Channel channel, byte[] msg) {
		AlarmMsg alarmMsg = new AlarmMsg();
		byte[] command = Arrays.copyOfRange(msg, 0, 2);
		byte contentLength = Arrays.copyOfRange(msg, 2, 3)[0];
		byte protocol = Arrays.copyOfRange(msg, 3, 4)[0];
		// 报警时间
		byte[] alarmDate = Arrays.copyOfRange(msg, 4, 10);
		// GPS卫星数量
		byte gpsCount = Arrays.copyOfRange(msg, 10, 11)[0];
		// 纬度
		byte[] latitude = Arrays.copyOfRange(msg, 11, 15);
		// 经度
		byte[] longitude = Arrays.copyOfRange(msg, 15, 19);
		// 速度
		byte speed = Arrays.copyOfRange(msg, 19, 20)[0];
		// 航向、方向
		byte[] orientation = Arrays.copyOfRange(msg, 20, 22);
		// LBS长度
		byte lbsLength = Arrays.copyOfRange(msg, 22, 23)[0];
		// 国家代码
		byte[] mcc = Arrays.copyOfRange(msg, 23, 25);
		// 移动网号码
		byte mnc = Arrays.copyOfRange(msg, 25, 26)[0];
		// 位置区码
		byte[] lac = Arrays.copyOfRange(msg, 26, 28);
		// 移动基站
		String cellId = ByteUtils.byte4ToIntAuto(Arrays.copyOfRange(msg, 28, 31)) + "";
		// 终端信息
		byte terminal = Arrays.copyOfRange(msg, 31, 32)[0];
		// 电压等级
		byte voltageLevel = Arrays.copyOfRange(msg, 32, 33)[0];
		// GSM等级
		byte gsmLevel = Arrays.copyOfRange(msg, 33, 34)[0];
		// 报警与语言
		byte[] alarmLanguge = Arrays.copyOfRange(msg, 34, 36);

		byte[] messageSerialNumber = Arrays.copyOfRange(msg, 36, 38);

		alarmMsg.setCommand(ByteUtils.byte2ToShort(command));
		alarmMsg.setContentLength(contentLength);
		alarmMsg.setProtocol(protocol);

		alarmMsg.setAlarmDate(convertDate(alarmDate));
		alarmMsg.setGpsCount(gpsCount);
		alarmMsg.setLatitude(convertGeo(latitude));
		alarmMsg.setLongitude(convertGeo(longitude));
		alarmMsg.setSpeed(speed);
		alarmMsg.setOrientation(orientation);
		alarmMsg.setLbsLength(lbsLength);
		alarmMsg.setMcc(ByteUtils.byte2ToShort(mcc));
		alarmMsg.setMnc(mnc);
		alarmMsg.setLac(ByteUtils.byte2ToShort(lac));
		alarmMsg.setCellId(cellId);
		alarmMsg.setTerminal(terminal);
		alarmMsg.setVoltageLevel(voltageLevel);
		alarmMsg.setGsmLevel(gsmLevel);
		alarmMsg.setAlarmLanguge(alarmLanguge);
		alarmMsg.setMsgType(msgType);

		byte[] content = ByteUtils.addAll(new byte[] { 0x05 }, new byte[] { supportProcotol() }, messageSerialNumber);
		byte[] checkCode = CRC16.crc16Bytes7878(content);
		byte[] responseContent = ByteUtils.addAll(command, content, checkCode, SOCOIotConstant.STOP_INDEX);
		alarmMsg.setResponseContent(responseContent);
		alarmMsg.setRequestContent(msg);
		return alarmMsg;
	}

	@Override
	public byte supportProcotol() {
		return 0x26;
	}

}
