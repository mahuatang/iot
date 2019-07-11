package com.soco.car.iot.server.app.handler;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.soco.car.iot.constants.AppChannelContext;
import com.soco.car.iot.constants.DeviceChannelContext;
import com.soco.car.iot.constants.SOCOIotConstant;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.service.SpringUtil;
import com.soco.car.iot.service.app.IAppService;
import com.soco.car.iot.utils.GsonUtil;
import com.soco.car.iot.utils.Hex;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@Service("appChannelInboundHandler")
@ChannelHandler.Sharable
public class AppChannelInboundHandler extends ChannelInboundHandlerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AppChannelInboundHandler.class);

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		SOCOIotConstant.online_app_number.increment();
		logger.info("在线APP总数为:" + SOCOIotConstant.online_app_number.intValue());
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
		SOCOIotConstant.online_app_number.decrement();
		super.channelInactive(ctx);
		String account = AppChannelContext.removeAttrbute(ctx.channel());
		logger.info("连接断开,账号为:{},在线APP总数为:{}", account, SOCOIotConstant.online_app_number.intValue());
		if (StringUtils.isNotEmpty(account)) {
			AppChannelContext.removeApp(account);
		}
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object obj) throws Exception {
		ByteBuf msg = (ByteBuf) obj;
		Channel channel = ctx.channel();
		byte[] byteMsg = new byte[msg.readableBytes()];
		String account = AppChannelContext.getAttrbute(channel);
		msg.readBytes(byteMsg);
		BaseMsg baseMsg = null;
		IAppService appService = null;
		try {
			baseMsg = GsonUtil.GsonToBean(new String(byteMsg, SOCOIotConstant.default_charset_utf8), BaseMsg.class);
			appService = (IAppService) SpringUtil.getBean(baseMsg.getMsgType() + "Service");
			if (baseMsg.getHasAuth()) {
				appService.exec(channel, baseMsg);
			} else {
				logger.warn("当前账号:{},请求未授权,将当前通道关闭,请求内容为:{}", account, Hex.encodeHexStr(byteMsg));
				channel.close();
			}
			if (StringUtils.isEmpty(account)) {
				account = AppChannelContext.getAttrbute(channel);
			}
			logger.info("请求账号为:{},请求参数为:{}", account, baseMsg);
		} catch (Exception e) {
			logger.info("请求发生异常,请求账户为:{},请求参数为:{}", account, Hex.encodeHexStr(byteMsg));
			channel.close();
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
		if (!channel.isActive()) {
			ctx.close();
		}
	}

}
