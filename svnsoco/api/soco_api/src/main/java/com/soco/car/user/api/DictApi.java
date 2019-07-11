/**
 * Project Name:soco_api
 * File Name:DictApi.java
 * Package Name:com.soco.car.user.api
 * Date:2018年7月26日下午5:09:01
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.user.api;

import java.util.List;

import com.soco.car.user.entity.Dict;

/**
 * ClassName:DictApi <br/>
 * Reason: 字典相关接口服务. <br/>
 * Date: 2018年7月26日 下午5:09:01 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public interface DictApi {
	
	public List<Dict> findALl();
	
	public Dict findByCode(String code);
	
	public List<Dict> findByChild(String code);
}
