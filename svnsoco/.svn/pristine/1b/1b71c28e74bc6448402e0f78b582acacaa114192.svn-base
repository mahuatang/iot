/**
 * Project Name:SOCO_API
 * File Name:DynamicDataSourceConfiguration.java
 * Package Name:com.soco.car.config
 * Date:2018年6月13日上午9:51:56
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.common.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.soco.car.common.dsl.DataSourceKey;
import com.soco.car.common.dsl.DynamicRoutingDataSource;

/**
 * ClassName:DynamicDataSourceConfiguration <br/>
 * Reason: 动态数据源配置中心. <br/>
 * Date: 2018年6月13日 上午9:51:56 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@MapperScan(basePackages = { "com.soco.car.car.dao", "com.soco.car.user.dao", "com.soco.car.device.dao" })
@Configuration
public class DynamicDataSourceConfiguration {
	/**
	 * 
	 * master: 主库配置文件
	 *
	 * @author sunlangping
	 * @return
	 */
	@Bean(name = "master")
	@ConfigurationProperties(prefix = "multiple.datasource.master")
	public DataSource master() {
		return DruidDataSourceBuilder.create().build();
	}
	/**
	 * 
	 * slave:从库配置文件
	 *
	 * @author sunlangping
	 * @return
	 */
	@Bean(name = "slave")
	@ConfigurationProperties(prefix = "multiple.datasource.slave")
	public DataSource slave() {
		return DruidDataSourceBuilder.create().build();
	}

	/**
	 * 核心动态数据源
	 *
	 * @return 数据源实例
	 */
	@Bean(name = "dynamicDataSource")
	public DataSource dynamicDataSource() {
		DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
		dataSource.setDefaultTargetDataSource(master());
		Map<Object, Object> dataSourceMap = new HashMap<>(2);
		dataSourceMap.put(DataSourceKey.MASTER, master());
		dataSourceMap.put(DataSourceKey.SLAVE, slave());
		dataSource.setTargetDataSources(dataSourceMap);
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dynamicDataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources1 = resolver.getResources("classpath:com/soco/car/car/sqlmap/*.xml");
		Resource[] resources2 = resolver.getResources("classpath:com/soco/car/device/sqlmap/*.xml");
		Resource[] resources3 = resolver.getResources("classpath:com/soco/car/user/sqlmap/*.xml");
		List<Resource> list = new ArrayList<>();
		list.addAll(Arrays.asList(resources1));
		list.addAll(Arrays.asList(resources2));
		list.addAll(Arrays.asList(resources3));
		Resource[] strings = new Resource[list.size()];
		list.toArray(strings);
		sqlSessionFactoryBean.setMapperLocations(strings);
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}

	/**
	 * 事务管理
	 *
	 * @return 事务管理实例
	 */
	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		return new DataSourceTransactionManager(dynamicDataSource());
	}
}
