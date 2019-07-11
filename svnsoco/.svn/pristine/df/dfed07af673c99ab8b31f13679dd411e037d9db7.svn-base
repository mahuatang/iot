/**
 * Project Name:soco_iot
 * File Name:AppLoginService.java
 * Package Name:com.soco.car.iot.service.app
 * Date:2018年8月8日下午3:59:22
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.service.app;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.soco.car.bean.cache.TokenPOJO;
import com.soco.car.iot.cache.TokenCache;
import com.soco.car.iot.constants.AppChannelContext;
import com.soco.car.iot.server.car.message.BaseMsg;
import com.soco.car.iot.utils.GsonUtil;

import io.jsonwebtoken.Jwts;
import io.netty.channel.Channel;

/**
 * ClassName:AppLoginService <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年8月8日 下午3:59:22 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class AppLoginService implements IAppService {

	private static final Logger logger = LoggerFactory.getLogger(AppLoginService.class);

	@Value("${jwt.secret}")
	private String secret;

	@Resource
	private TokenCache tokenCache;

	@Override
	public BaseMsg exec(Channel channel, BaseMsg baseMsg) {
		
		Map<String, Object> tokenMap = null;
		try {
			tokenMap = validateToken(baseMsg.getToken());
		} catch (Exception e) {
			logger.error("登录请求授权异常!异常的的参数为:{}", baseMsg);
			response(channel, GsonUtil.GsonString(baseMsg));
			//授权不通过则将当前通道关闭节约资源
			channel.close();
			return baseMsg;
		}
		String account = tokenMap.get("account") + "";
		Channel old=AppChannelContext.getApp(account);
		if (old != null) {
			logger.warn("同一个账户只能在一个地方登录APP后台,老登录的IP为:{}端口为:,新的IP为:{},端口为:{}", old.remoteAddress(),
					channel.remoteAddress());
			old.close();
		}
		AppChannelContext.putApp(account, channel);
		AppChannelContext.setAttrbute(account, channel);
		return baseMsg;
	}

	private Map<String, Object> validateToken(String token) {
		Map<String, Object> body = null;
		try {
			String t = token.replace("Bearer ", "");
			// 将token转换
			body = Jwts.parser().setSigningKey(secret).parseClaimsJws(t).getBody();

			String account = body.get("account") + "";
			TokenPOJO tokenPOJO = tokenCache.get(account);
			if (tokenPOJO == null || !tokenPOJO.getToken().equals(token)) {
				throw new RuntimeException("认证异常");
			}
		} catch (Exception e) {
			// logger.info("token验证失败,token:{},错误描述为:{}", token, e.getMessage());
			throw new RuntimeException("认证异常");
		}
		return body;
	}
}
