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
 * Reason: 后台管理通道对象上下文. <br/>
 * Date: 2018年7月13日 下午1:46:28 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class PlatChannelContext {

	private static final AttributeKey<String> plat_channel_key = AttributeKey.valueOf("plat.channel");

	private static final ConcurrentMap<String, Channel> platChannel = new ConcurrentHashMap<>();

	public static Channel putPlat(String channelId, Channel channel) {
		return platChannel.put(channelId, channel);
	}

	public static Channel removePlat(String channelId) {
		return platChannel.remove(channelId);
	}

	public static Channel getPlat(String channelId) {
		return platChannel.get(channelId);
	}

	public static Integer getPlatSize() {
		return platChannel.size();
	}

	/**
	 * 
	 * setAttrbute: 设置当前会话对象
	 *
	 * @author sunlangping
	 * @param channel
	 *            通道对象
	 * @param deviceNo
	 *            设备号
	 */
	public static void setAttrbute(Channel channel, String deviceNo) {
		Attribute<String> attr = channel.attr(plat_channel_key);
		if (attr.get() == null) {
			attr.setIfAbsent(deviceNo);
		}
	}

	/**
	 * 
	 * getAttrbute:获取当前会话对象
	 *
	 * @author sunlangping
	 * @param channel
	 *            通道对象
	 * @return
	 */
	public static String getAttrbute(Channel channel) {
		Attribute<String> attr = channel.attr(plat_channel_key);
		return attr.get();
	}
}
