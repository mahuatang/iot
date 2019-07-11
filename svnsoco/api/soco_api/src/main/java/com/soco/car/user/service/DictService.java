/**
 * Project Name:soco_api
 * File Name:DictService.java
 * Package Name:com.soco.car.user.service
 * Date:2018年7月26日下午5:10:26
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.soco.car.user.api.DictApi;
import com.soco.car.user.dao.DictMapper;
import com.soco.car.user.entity.Dict;
import com.soco.car.user.entity.DictExample;

/**
 * ClassName:DictService <br/>
 * Reason: 接口相关接口 <br/>
 * Date: 2018年7月26日 下午5:10:26 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service(interfaceClass = DictApi.class,timeout=30000)
public class DictService implements DictApi {

	@Autowired
	private DictMapper mapper;

	@Override
	public List<Dict> findALl() {
		return mapper.selectByExample(null);
	}

	@Override
	public Dict findByCode(String code) {
		DictExample example = new DictExample();
		example.createCriteria().andCodeEqualTo(code);
		List<Dict> list = mapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Dict> findByChild(String code) {
		return mapper.findByChild(code);
	}

}
