/**
 * Project Name:SOCO_APP
 * File Name:jwtService.java
 * Package Name:com.soco.car.app.service
 * Date:2018年7月25日下午1:27:15
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.soco.car.app.cache.TokenCache;
import com.soco.car.app.exception.AuthException;
import com.soco.car.app.exception.AuthNullException;
import com.soco.car.bean.cache.TokenPOJO;
import com.soco.car.user.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * ClassName:jwtService <br/>
 * Reason: JWT验证模块 <br/>
 * Date: 2018年7月25日 下午1:27:15 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class JwtService {

	@Value("${jwt.secret}")
	private String SECRET;

	@Value("${jwt.expire}")
	private int jwtExpire;

	@Autowired
	private TokenCache tokenCache;

	/**
	 * 
	 * generateToken:生成新的token
	 *
	 * @author sunlangping
	 * @param account
	 *            账户
	 * 
	 * @param user
	 *            用户对象
	 * 
	 * @return
	 */
	public String generateToken(String account, User user) {
		Date timeoutTime=new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * jwtExpire));
		HashMap<String, Object> map = new HashMap<>();
		map.put("account", account);
		// 7天不登录则将token设置为过期
		String jwt = Jwts.builder().setClaims(map)
				.setExpiration(timeoutTime)
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		String token = "Bearer " + jwt;// jwt前面一般都会加Bearer
		TokenPOJO tokenPOJO=tokenCache.get(account);
		if(tokenPOJO==null) {
			tokenPOJO = new TokenPOJO();
		}
		fullCacheUser(user, tokenPOJO);
		tokenPOJO.setAccount(account);
		tokenPOJO.setToken(token);
		tokenCache.save(tokenPOJO,jwtExpire);
		return token;
	}

	/**
	 * 
	 * fullCacheUser:填充用户中的缓存信息
	 *
	 * @author sunlangping
	 */
	private void fullCacheUser(User u, TokenPOJO tokenPOJO) {
		if (u == null) {
			return;
		}
		tokenPOJO.setUserId(u.getUserId());
	}

	/**
	 * 
	 * validateToken:验证token是否有效
	 *
	 * @author sunlangping
	 * @param token
	 * @return
	 */
	public Map<String, Object> validateToken(String token) {
		if (StringUtils.isEmpty(token)) {
			throw new AuthNullException("授权信息为空,无法继续访问请授权访问");
		}
		Map<String, Object> body = null;
		try {
			String t = token.replace("Bearer ", "");
			// 将token转换
			body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(t).getBody();
			String account = body.get("account") + "";
			TokenPOJO tokenPOJO = tokenCache.get(account);
			if (tokenPOJO == null || !tokenPOJO.getToken().equals(token)) {
				throw new AuthException("鉴权失败,请重新请求授权");
			}
		} catch (Exception e) {
			throw new AuthException("鉴权失败！");
		}
		return body;
	}
}
