/**
 * Project Name:SOCO_Report
 * File Name:CoordinateUtilTest.java
 * Package Name:com.soco.car.report.utils
 * Date:2018年6月25日下午3:52:40
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.utils;

import org.junit.Test;

/**
 * ClassName:CoordinateUtilTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月25日 下午3:52:40 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class CoordinateUtilTest {

	@Test
	public void testBd09_To_Gps84() throws Exception {
		// 北斗芯片获取的经纬度为WGS84地理坐标 31.426896,119.496145
		Gps gps = new Gps(31.426896, 119.496145);
		System.out.println("gps :" + gps);
		Gps gcj = CoordinateUtil.gps84_To_Gcj02(gps.getWgLat(), gps.getWgLon());
		System.out.println("gcj :" + gcj);
		Gps star = CoordinateUtil.gcj_To_Gps84(gcj.getWgLat(), gcj.getWgLon());
		System.out.println("star:" + star);
		Gps bd = CoordinateUtil.gcj02_To_Bd09(gcj.getWgLat(), gcj.getWgLon());
		System.out.println("bd  :" + bd);
		Gps gcj2 = CoordinateUtil.bd09_To_Gcj02(bd.getWgLat(), bd.getWgLon());
		System.out.println("gcj :" + gcj2);
	}

}
