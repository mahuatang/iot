/**
 * Project Name:soco_api
 * File Name:SmsCountryService.java
 * Package Name:com.soco.car.user.service
 * Date:2018年7月30日下午5:34:19
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.soco.car.common.constatns.SOCOAPIConstatns;
import com.soco.car.user.api.SmsCountryApi;
import com.soco.car.user.dao.SmsCountryMapper;
import com.soco.car.user.entity.SmsCountry;
import com.soco.car.user.entity.SmsCountryExample;

/**
 * ClassName:SmsCountryService <br/>
 * Date: 2018年7月30日 下午5:34:19 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service(interfaceClass = SmsCountryApi.class,timeout=30000)
public class SmsCountryService implements SmsCountryApi {

	@Autowired
	private SmsCountryMapper mapper;

	@Override
	public List<SmsCountry> findActiveCountry() {
		return findByCommon(SOCOAPIConstatns.N);
	}

	@Override
	public List<SmsCountry> findAll() {
		return findByCommon(null);
	}

	private List<SmsCountry> findByCommon(Integer isDelFlag) {
		SmsCountryExample example = new SmsCountryExample();
		if (isDelFlag != null) {
			example.createCriteria().andDelFlagEqualTo(isDelFlag);
		}
		example.setOrderByClause("  seq IS NULL,seq ASC");
		return mapper.selectByExample(example);
	}

}
