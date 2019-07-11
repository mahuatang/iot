/**
 * Project Name:soco_iot
 * File Name:Client.java
 * Package Name:com.soco.car.iot.client
 * Date:2018年8月14日下午1:27:42
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.client;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soco.car.iot.constants.SOCOIotConstant;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.utils.ByteUtils;
import com.soco.car.iot.utils.GsonUtil;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * ClassName:Client <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年8月14日 下午1:27:42 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class Client {

	private static final Logger logger = LoggerFactory.getLogger(Client.class);

	private static boolean isConnect = false;

	private static Channel ch;

	public void connect(String ip, int port) {
		NioEventLoopGroup workGroup = new NioEventLoopGroup(4);
		// Random random = new Random(System.currentTimeMillis());
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(workGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
				protected void initChannel(SocketChannel socketChannel) throws Exception {
					ChannelPipeline p = socketChannel.pipeline();
					p.addLast(new IdleStateHandler(0, 0, 10));
					p.addLast(new NettyClientHandler());
				}
			});

			ChannelFuture cf = bootstrap.remoteAddress(ip, port).connect().sync();
			cf.addListener(new GenericFutureListener<Future<? super Void>>() {
				@Override
				public void operationComplete(Future<? super Void> future) throws Exception {
					if (future.isSuccess()) {
						isConnect = false;
						logger.info("与服务器{}:{}连接建立成功...", ip, port);
					} else {
						logger.info("与服务器{}:{}连接建立失败...", ip, port);
					}
				}
			});
			ch = cf.channel();
			if (null != ch && ch.isActive() && ch.isOpen()) {
				BaseMsg msg = new BaseMsg();
				msg.setDeviceNo("0868120197538942");
				msg.setMsgType("appLogin");
				msg.setToken(
						"Bearer eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1MzQ5MDA1NDEsImFjY291bnQiOiI4Nl8xNzYwMjEwOTQ2OCJ9.IlKohETNxGXbNdn1HLccChZsgX0Nm4zRHEqo01rYDKgkH3rcQrIIhl9MXQvvfTeMNpefSWTnbrUIpzMmKPHvCA");
				response(ch, GsonUtil.GsonString(msg));
			}
			cf.channel().closeFuture().sync();
		} catch (Exception e) {
			isConnect = false;
			throw new RuntimeException(e);
		} finally {
			isConnect = false;
			workGroup.shutdownGracefully();
			reConnect(ip, port);
		}
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

	private void reConnect(String ip, int port) {
		try {
			isConnect = false;
			int delay = 5;
			logger.error("与服务器{}:{}连接已断开, {}秒后重连...", ip, port, delay);
			Thread.sleep(delay * 1000);
			connect(ip, port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String ip = "127.0.0.1";
		int port = 12302;
		Client client = new Client();
		try {
			new Thread(() -> {
				client.connect(ip, port);
			}).start();
//			Thread.sleep(1000l);
//			new Thread(() -> {
//				client.connect(ip, port);
//			}).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		for (int i = 0; i < 100; i++) {
//			AppVehicleCheckup();
//			try {
//				Thread.sleep(3000l);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}

	public static void AppVehicleCheckup() {
		BaseMsg msg = new BaseMsg();
		msg.setDeviceNo("0868120197538942");
		msg.setMsgType("appVehicleCheckup");
		String json = GsonUtil.GsonString(msg);
		if (ch != null && ch.isActive() && ch.isOpen()) {
			response(ch, json);
		}
	}
}
