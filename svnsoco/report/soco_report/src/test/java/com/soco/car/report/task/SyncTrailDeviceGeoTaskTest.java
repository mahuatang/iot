/**
 * Project Name:SOCO_Report
 * File Name:SyncTrailDeviceGeoTaskTest.java
 * Package Name:com.soco.car.report.task
 * Date:2018年7月4日下午6:47:08
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.task;

import org.junit.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.soco.car.car.api.CarTypeApi;
import com.soco.car.report.base.BaseTest;

/**
 * ClassName:SyncTrailDeviceGeoTaskTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月4日 下午6:47:08 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class SyncTrailDeviceGeoTaskTest extends BaseTest {

	@Reference
	private CarTypeApi carTypeApi;

	@Test
	public void testCarTypeApi() throws Exception {
		System.out.println("carTypeApi:" + carTypeApi);
	}
}
