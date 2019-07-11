/**
 * Project Name:SOCO_IOT
 * File Name:PlatServerTest.java
 * Package Name:com.soco.car.iot.server.plat
 * Date:2018年7月12日上午9:20:32
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.server.plat;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soco.car.iot.base.BaseTest;
import com.soco.car.iot.server.NettyServerI;

/**
 * ClassName:PlatServerTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月12日 上午9:20:32 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class PlatServerTest extends BaseTest {

	@Autowired
	private Map<String, NettyServerI> cs;

	@Test
	public void testStart() throws Exception {
		cs.forEach((k, v) -> {
//			System.out.println(v);
			v.start();
		});
	}

}
