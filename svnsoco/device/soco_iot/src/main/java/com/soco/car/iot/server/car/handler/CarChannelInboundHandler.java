package com.soco.car.iot.server.car.handler;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soco.car.iot.constants.DeviceChannelContext;
import com.soco.car.iot.constants.SOCOIotConstant;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.server.car.message.MessageConverter;
import com.soco.car.iot.server.car.message.MessageConverterContext;
import com.soco.car.iot.service.SpringUtil;
import com.soco.car.iot.service.car.ICarService;
import com.soco.car.iot.utils.Hex;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@Service("carChannelInboundHandler")
@ChannelHandler.Sharable
public class CarChannelInboundHandler extends ChannelInboundHandlerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(CarChannelInboundHandler.class);

	@Autowired
	private MessageConverterContext messageConverterContext;

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		SOCOIotConstant.online_car_number.increment();
		logger.info("在线车俩总数为:" + SOCOIotConstant.online_car_number.intValue());
		super.channelActive(ctx);
	}

	/**
	 * 
	 * channelInactive: tcp连接通道超时或主动断开
	 *
	 * @author sunlangping
	 * @param ctx
	 * @throws Exception
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		SOCOIotConstant.online_car_number.decrement();
		super.channelInactive(ctx);
		String deviceNo = DeviceChannelContext.removeAttrbute(ctx.channel());
		logger.info("连接断开,设备ID为:{},在线车俩总数为:{}", deviceNo, SOCOIotConstant.online_car_number.intValue());
		if (StringUtils.isNotEmpty(deviceNo)) {
			DeviceChannelContext.removeDevice(deviceNo);
		}
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object obj) throws Exception {
		ByteBuf msg = (ByteBuf) obj;
		// int len = msg.readInt();
		// logger.info("消息的长度为:{}", len);
		Channel channel = ctx.channel();
		byte[] byteMsg = new byte[msg.readableBytes()];
		msg.readBytes(byteMsg);
		String deviceNo = DeviceChannelContext.getAttrbute(channel);
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("请求的设备号{},请求IP地址:{},当前处理的消息内容为:{}", deviceNo, channel.remoteAddress().toString(),
						Hex.encodeHexStr(byteMsg));
			}
			MessageConverter convert = messageConverterContext.get(byteMsg);
			if (null == convert) {
				logger.warn("无法识别此消息,设备号为:{},消息内容为:{},", deviceNo, Hex.encodeHexStr(byteMsg));
				return;
			}
			BaseMsg baseMsg = convert.convert2Message(channel, byteMsg);
			if (baseMsg.getHasAuth()) {
				ICarService service = (ICarService) SpringUtil.getBean(baseMsg.getMsgType() + "Service");
				service.exec(channel, baseMsg);
			} else {
				logger.warn("当前请求没有授权,将当前通道关闭,请求内容为:{}", Hex.encodeHexStr(byteMsg));
				channel.close();
			}
			if (StringUtils.isEmpty(deviceNo)) {
				deviceNo = DeviceChannelContext.getAttrbute(channel);
			}
			logger.info("接收设备号:{},内容为:{}", deviceNo, baseMsg);
		} catch (Exception e) {
			logger.error("处理消息异常,请求设备为:{},请求参数为:{},请求的IP:{},错误描述:{}", DeviceChannelContext.getAttrbute(channel),
					Hex.encodeHexStr(byteMsg), channel.remoteAddress().toString(), e.getMessage());
		}
	}

	/**
	 * 
	 * 超时时触发
	 * 
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#userEventTriggered(io.netty.channel.ChannelHandlerContext,
	 *      java.lang.Object)
	 */
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		super.userEventTriggered(ctx, evt);
		ctx.close();
		// Channel channel = ctx.channel();
		// if (!channel.isOpen()) {
		// }
		// if (evt instanceof IdleStateEvent) {
		//
		// IdleStateEvent event = (IdleStateEvent) evt;
		//
		// if (event.state().equals(IdleState.READER_IDLE)) { // 读超时
		// // 超时关闭channel
		//// ctx.close();
		// checkHeartbeatMsg(ctx, channel);
		// } else if (event.state().equals(IdleState.WRITER_IDLE)) {// 写超时
		// checkHeartbeatMsg(ctx, channel);
		// } else if (event.state().equals(IdleState.ALL_IDLE)) {// 读写超时
		// checkHeartbeatMsg(ctx, channel);
		// }
		// }
	}

	/**
	 * 
	 * checkHeartbeatMsg:
	 * 检查客户端是否还连接服务器，如果连接服务器状态，服务器端超时则主动发客户端发心跳包，此方法目前占不使用，降低服务器压力
	 *
	 * @author sunlangping
	 * @param ctx
	 * @param channel
	 */
	@Deprecated
	private void checkHeartbeatMsg(ChannelHandlerContext ctx, Channel channel) {
		// 检测到过期主动发送服务器端心跳
		ByteBuf bf = Unpooled.copiedBuffer(new byte[] { 0x01 });
		if (channel.isOpen()) {
			channel.writeAndFlush(bf);
		} else {
			ctx.close();
		}
	}

	/**
	 * 
	 * 服务器端未给客户端回复,客户端提前关闭
	 * 
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#exceptionCaught(io.netty.channel.ChannelHandlerContext,
	 *      java.lang.Throwable)
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		Channel channel = ctx.channel();
		if (channel.isActive()) {
			ctx.close();
		}
	}

}
