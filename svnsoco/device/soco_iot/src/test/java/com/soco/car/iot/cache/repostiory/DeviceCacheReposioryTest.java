/**
 * Project Name:SOCO_IOT
 * File Name:DeviceCacheReposioryTest.java
 * Package Name:com.soco.car.iot.cache.repostiory
 * Date:2018年7月12日下午6:34:30
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.cache.repostiory;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import com.soco.car.bean.cache.DeviceCachePOJO;
import com.soco.car.iot.base.BaseTest;

/**
 * ClassName:DeviceCacheReposioryTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月12日 下午6:34:30 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class DeviceCacheReposioryTest extends BaseTest {

	@Resource(name = "redisTemplate")
	private RedisTemplate<String, String> redis;

	@Test
	public void testSave() {
		DeviceCachePOJO cache = new DeviceCachePOJO();
		String test = "zs";
		cache.setDeviceNo(test);
		cache.setMobile(test);
		for (int i = 0; i < 100; i++) {
			redis.opsForValue().set(test + i, "123");
			redis.expire(test + i, 30, TimeUnit.SECONDS);
		}
	}
}
