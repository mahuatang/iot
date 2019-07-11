/**
 * Project Name:soco_api
 * File Name:DictServiceTest.java
 * Package Name:com.soco.car.user.service
 * Date:2018年7月26日下午5:20:02
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.user.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soco.car.base.BaseTest;
import com.soco.car.user.entity.Dict;

/**
 * ClassName:DictServiceTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月26日 下午5:20:02 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class DictServiceTest extends BaseTest {

	@Autowired
	private DictService dictService;

	@Test
	public void testFindByChild() throws Exception {
		String code = "IMAGE_PATH";
		List<Dict> dictList = dictService.findByChild(code);
		System.out.println(dictList);
	}

}
