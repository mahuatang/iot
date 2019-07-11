/**
 * Project Name:SOCO_Report
 * File Name:TrailDeviceSearchControll.java
 * Package Name:com.soco.car.report.controll
 * Date:2018年6月22日上午10:06:58
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:TrailDeviceSearchControll <br/>
 * Reason: 与轨迹相关统计接口统一入口. <br/>
 * Date: 2018年6月22日 上午10:06:58 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Controller
@RequestMapping(value = "/")
public class IndexControll {

	private static final Logger logger = LoggerFactory.getLogger(IndexControll.class);

	@RequestMapping(path = { "/index", "/" })
	public String index() {
		return "index";
	}
}
