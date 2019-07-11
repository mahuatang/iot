/**
 * Project Name:soco_iot
 * File Name:NettyClientHandler.java
 * Package Name:com.soco.car.iot.client
 * Date:2018年8月14日下午1:36:29
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.client;

import java.io.UnsupportedEncodingException;

import com.soco.car.iot.constants.SOCOIotConstant;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.utils.ByteUtils;
import com.soco.car.iot.utils.GsonUtil;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * ClassName:NettyClientHandler <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年8月14日 下午1:36:29 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

	public static ChannelHandlerContext context = null;

	// 利用写空闲发送心跳检测消息
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		BaseMsg msg = new BaseMsg();
		msg.setDeviceNo("0868120197538942");
		msg.setMsgType("appHeartbeat");
		String json = GsonUtil.GsonString(msg);
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent) evt;
			response(ctx.channel(), json);
		}
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf obj) throws Exception {
		ByteBuf msg = (ByteBuf) obj;
		byte[] byteMsg = new byte[msg.readableBytes()];
		msg.readBytes(byteMsg);
		String str = new String(byteMsg);
		System.out.println(str);
	}
	public static boolean response(Channel channel, String responseJson) {
		boolean flag = false;
		byte[] requestContent;
		try {
			requestContent = responseJson.getBytes(SOCOIotConstant.default_charset_utf8);
			requestContent = ByteUtils.addAll(requestContent, SOCOIotConstant.STOP_INDEX);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage());
		}
		ByteBuf bf = Unpooled.buffer(requestContent.length);
		bf.writeBytes(requestContent);
		if (channel.isOpen()) {
			channel.writeAndFlush(bf);
			flag = true;
		}
		return flag;
	}
}
