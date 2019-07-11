/**
 * Project Name:SOCO_IOT
 * File Name:ChannelContext.java
 * Package Name:com.soco.car.iot.constants
 * Date:2018年7月13日下午1:46:28
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.constants;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

/**
 * ClassName:ChannelContext <br/>
 * Reason: 手机通道对象上下文. <br/>
 * Date: 2018年7月13日 下午1:46:28 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class AppChannelContext {

	private static final AttributeKey<String> app_channel_key = AttributeKey.valueOf("app.channel");

	private static final ConcurrentMap<String, Channel> appChannel = new ConcurrentHashMap<>();

	public static Channel putApp(String account, Channel channel) {
		return appChannel.put(account, channel);
	}

	public static Channel removeApp(String account) {
		return appChannel.remove(account);
	}

	public static Channel getApp(String account) {
		return appChannel.get(account);
	}

	public static Integer getAppSize() {
		return appChannel.size();
	}
	
	/**
	 * 
	 * setAttrbute: 设置当前会话对象
	 *
	 * @author sunlangping
	 * @param deviceNo		设备号
	 * @param channel		通道对象
	 */
	public static void setAttrbute(String deviceNo, Channel channel) {
		Attribute<String> attr = channel.attr(app_channel_key);
		if (attr.get() == null) {
			attr.setIfAbsent(deviceNo);
		}
	}
	/**
	 * 
	 * getAttrbute:获取当前会话对象
	 *
	 * @author sunlangping
	 * @param channel	通道对象
	 * @return	
	 */
	public static String getAttrbute(Channel channel) {
		Attribute<String> attr = channel.attr(app_channel_key);
		return attr.get();
	}
	/**
	 * 
	 * removeAttrbute:获取当前会话并将当前会话设置为空
	 *
	 * @author sunlangping
	 * @param channel
	 * @return
	 */
	public static String removeAttrbute(Channel channel) {
		return channel.attr(app_channel_key).getAndSet(null);
	}
}
