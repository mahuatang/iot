/**
 * Project Name:soco_app
 * File Name:CodeCache.java
 * Package Name:com.soco.car.app.cache
 * Date:2018年7月28日下午2:48:38
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.cache;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.soco.car.app.constants.CacheExpireEnum;
import com.soco.car.bean.cache.CodePOJO;

/**
 * ClassName:CodeCache <br/>
 * Reason: 验证码相关API <br/>
 * Date: 2018年7月28日 下午2:48:38 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class CodeCache implements CacheI<CodePOJO> {

	@Resource
	private RedisTemplate<String, CodePOJO> redisTemplate;

	public final String value_key = "user_code_";

	@Override
	public void save(CodePOJO t) {
		// String k = MessageFormat.format(value_key, t.getAccount());
		String k = value_key + t.getAccount();
		redisTemplate.opsForValue().set(k, t);
		redisTemplate.expire(k, CacheExpireEnum.minute_5.getValue(), TimeUnit.MINUTES);
	}

	@Override
	public void remove(String key) {
		String k = value_key + key;
		redisTemplate.delete(k);
	}

	@Override
	public CodePOJO get(String key) {
		String k = value_key + key;
		return redisTemplate.opsForValue().get(k);
	}

}