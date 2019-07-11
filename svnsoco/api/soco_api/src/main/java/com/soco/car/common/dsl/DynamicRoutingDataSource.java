/**
 * Project Name:SOCO_API
 * File Name:DynamicRoutingDataSource.java
 * Package Name:com.soco.car.dsl
 * Date:2018年6月13日上午9:51:01
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.common.dsl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ClassName:DynamicRoutingDataSource <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月13日 上午9:51:01 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

	private static final Logger logger = LoggerFactory.getLogger(DynamicRoutingDataSource.class);

	@Override
	protected Object determineCurrentLookupKey() {
		if (logger.isDebugEnabled()) {
			logger.info("当前数据源：{0}", DynamicDataSourceContextHolder.get());
		}
		return DynamicDataSourceContextHolder.get();
	}

}
