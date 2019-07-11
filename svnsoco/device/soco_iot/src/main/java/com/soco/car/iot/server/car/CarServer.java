/**
 * Project Name:SOCO_IOT
 * File Name:CarServer.java
 * Package Name:com.soco.car.iot.server
 * Date:2018年7月9日下午7:33:26
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.car;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.soco.car.SoCoIOTApplicatoin;
import com.soco.car.iot.constants.SOCOIotConstant;
import com.soco.car.iot.server.NettyServerI;
import com.soco.car.iot.server.car.handler.CarChannelInboundHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * ClassName:CarServer <br/>
 * Reason: 车相关的netty服务 <br/>
 * Date: 2018年7月9日 下午7:33:26 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class CarServer implements NettyServerI {

	private static final Logger logger = LoggerFactory.getLogger(SoCoIOTApplicatoin.class);

	@Value("${car.netty.host}")
	private String host;

	@Value("${car.netty.port}")
	private Integer port;

	@Value("${car.netty.read.timeout}")
	private Integer readTimeout;

	@Value("${car.netty.write.timeout}")
	private Integer writeTimeout;

	@Value("${car.netty.all.timeout}")
	private Integer allTimeout;

	@Resource(name = "boss")
	private EventLoopGroup boss;

	@Resource(name = "worker")
	private EventLoopGroup worker;

	@Autowired
	private CarChannelInboundHandler carChannelInboundHandler;

	@Override
	public void start() {
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(CarServer.this.boss, CarServer.this.worker);
			b.channel(NioServerSocketChannel.class);
			b.option(ChannelOption.SO_BACKLOG, Integer.valueOf(102400));
			b.childOption(ChannelOption.TCP_NODELAY, true);
			b.childOption(ChannelOption.SO_KEEPALIVE, true);
			b.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel socketChannel) throws Exception {
					ChannelPipeline p = socketChannel.pipeline();
					p.addLast(new IdleStateHandler(readTimeout, writeTimeout, allTimeout));
//					p.addLast(new ByteMessageToByteDecoder());
//					p.addLast(new ByteMessageToByteEncoder());
					
					// p.addLast(new LineBasedFrameDecoder(2048));
					ByteBuf delimiter = Unpooled.copiedBuffer(SOCOIotConstant.STOP_INDEX);
					// 到2048字节还没找到分隔符则抛出异常
					p.addLast(new DelimiterBasedFrameDecoder(2048, delimiter));
					p.addLast(carChannelInboundHandler);
				}
			});
			ChannelFuture cf = b.bind(host, port).sync();
			Channel c = cf.channel();
			if (cf.isSuccess()) {
				logger.info("car netty({}) 启动成功, 等待连接...", c.localAddress());
			} else {
				logger.info("car netty({}) 启动异常", c.localAddress());
			}
		} catch (Throwable e) {
			logger.error("启动CarServer错误:{}", e.getMessage());
		}
	}

}
