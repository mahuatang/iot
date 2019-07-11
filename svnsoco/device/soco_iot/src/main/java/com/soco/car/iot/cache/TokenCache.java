package com.soco.car.iot.cache;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
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
		redisTemplate.expire(key, expire, TimeUnit.MINUTES);
	}

	@Override
	public void remove(String key) {
		String k = hash_key + key;
		redisTemplate.delete(key);
	}

	@Override
	public TokenPOJO get(String key) {
		String k = hash_key + key;
		return (TokenPOJO) redisTemplate.opsForValue().get(k);
	}

}
