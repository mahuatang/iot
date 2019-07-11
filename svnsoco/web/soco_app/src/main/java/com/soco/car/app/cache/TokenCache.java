/**
 * Project Name:SOCO_APP
 * File Name:UserCache.java
 * Package Name:com.soco.car.app.cache
 * Date:2018年7月20日下午4:05:43
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.cache;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.soco.car.bean.cache.TokenPOJO;

/**
 * ClassName:UserCache <br/>
 * Reason: 用户相关缓存 ,目前用户信息操作时间设置为永久<br/>
 * Date: 2018年7月20日 下午4:05:43 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class TokenCache implements CacheI<TokenPOJO> {

	private final String hash_key = "user_token_";

	@Resource
	private RedisTemplate<String, TokenPOJO> redisTemplate;

	@Override
	public void save(TokenPOJO t) {
		String key = hash_key + t.getAccount();
		redisTemplate.opsForValue().set(key, t);
	}

	@Override
	public void save(TokenPOJO t, int expire) {
		String key = hash_key + t.getAccount();
		redisTemplate.opsForValue().set(key, t);
		redisTemplate.expire(key, expire, TimeUnit.DAYS);
	}

	@Override
	public void remove(String key) {
		String k = hash_key + key;
		redisTemplate.delete(k);
	}

	@Override
	public TokenPOJO get(String key) {
		String k = hash_key + key;
		return (TokenPOJO) redisTemplate.opsForValue().get(k);
	}

}
