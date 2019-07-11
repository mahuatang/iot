/**
 * Project Name:SOCO_Report
 * File Name:MapToWGSTest.java
 * Package Name:com.soco.car.report.utils
 * Date:2018年6月22日下午12:38:01
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.utils;

import java.util.Calendar;

import org.junit.Test;

/**
 * ClassName:MapToWGSTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月22日 下午12:38:01 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class MapToWGSTest {

	@Test
	public void testToWGS84Point() throws Exception {
		double lat = 31.150513;
		double lnt = 121.168533;

		System.out.println(CoordinateUtil.gps84_To_Gcj02(lat, lnt));
	}

	@Test
	public void testBaby100Day() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 4, 29);
		calendar.add(Calendar.DAY_OF_MONTH, 100);
		
		System.out.println(calendar.getTime());
	}
	
	@Test
	public void test() {
		System.out.println("898602B9211890204270".length());
	}
}
