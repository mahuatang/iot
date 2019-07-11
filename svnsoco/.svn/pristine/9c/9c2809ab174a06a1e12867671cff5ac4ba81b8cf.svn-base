/**
 * Project Name:SOCO_API
 * File Name:TargetDataSource.java
 * Package Name:com.soco.car.dsl
 * Date:2018年6月13日上午9:54:12
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.common.dsl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:TargetDataSource <br/>
 * Reason: 根据注解动态选择数据库. <br/>
 * Date: 2018年6月13日 上午9:54:12 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {
	DataSourceKey dataSourceKey() default DataSourceKey.MASTER;
}
