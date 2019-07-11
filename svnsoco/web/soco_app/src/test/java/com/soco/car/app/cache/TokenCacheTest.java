/**
 * Project Name:SOCO_APP
 * File Name:UserCacheTest.java
 * Package Name:com.soco.car.app.cache
 * Date:2018年7月24日下午9:10:57
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.cache;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soco.car.app.base.BaseTest;
import com.soco.car.bean.cache.TokenPOJO;

/**
 * ClassName:UserCacheTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月24日 下午9:10:57 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class TokenCacheTest extends BaseTest {

	@Autowired
	private TokenCache userCache;
	//
	// @Autowired
	// private UserCacheRepository userCacheRepository;

	@Test
	public void testSaveUserPOJOInt() throws Exception {
		TokenPOJO userpojo = new TokenPOJO();
		userpojo.setAccount("86_17602109468");
		userCache.save(userpojo, 7);
	}

	@Test
	public void testGet() throws Exception {
		String phone = "86_17602109468";
		System.out.println(userCache.get(phone));

	}

	// @Test
	// public void testRepositroy() {
	// UserPOJO userpojo = new UserPOJO();
	// userpojo.setPhone("17602109463");
	//// userpojo.setExpiration(10000l);
	// userCacheRepository.save(userpojo);
	// }

}
