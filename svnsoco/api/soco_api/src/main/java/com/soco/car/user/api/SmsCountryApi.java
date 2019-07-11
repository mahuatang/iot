/**
 * Project Name:soco_api
 * File Name:SmsCountryApi.java
 * Package Name:com.soco.car.user.api
 * Date:2018年7月30日下午5:34:38
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.user.api;

import java.util.List;

import com.soco.car.user.entity.SmsCountry;

/**
 * ClassName:SmsCountryApi <br/>
 * Reason: 各个国家短信信息中详情. <br/>
 * Date: 2018年7月30日 下午5:34:38 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public interface SmsCountryApi {

	public List<SmsCountry> findActiveCountry();

	public List<SmsCountry> findAll();
}
