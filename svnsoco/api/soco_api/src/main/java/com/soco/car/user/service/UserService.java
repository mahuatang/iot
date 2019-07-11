/**
 * Project Name:SOCO_API
 * File Name:UserService.java
 * Package Name:com.soco.car.user.service
 * Date:2018年7月24日上午11:21:33
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.user.service;

import java.util.Date;
import java.util.List;

import com.soco.car.user.dao.PhoneVersionMapper;
import com.soco.car.user.dao.SmsLogMapper;
import com.soco.car.user.dao.UserMapper;
import com.soco.car.user.entity.PhoneVersion;
import com.soco.car.user.entity.SmsLog;
import com.soco.car.user.entity.User;
import com.soco.car.user.entity.UserExample;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soco.car.common.constatns.SOCOAPIConstatns;
import com.soco.car.common.dsl.DataSourceKey;
import com.soco.car.common.dsl.TargetDataSource;
import com.soco.car.user.api.UserApi;
import com.soco.car.user.dao.UserRunPointMapper;
import com.soco.car.user.entity.UserRunPoint;

/**
 * ClassName:UserService <br/>
 * Reason: 与用户相关的一些接口 <br/>
 * Date: 2018年7月24日 上午11:21:33 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service(interfaceClass = UserApi.class, timeout = 30000)
public class UserService implements UserApi {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRunPointMapper userRunPointMapper;

	@Autowired
	private PhoneVersionMapper phoneVersionMapper;

	@Autowired
	private SmsLogMapper smsLogMapper;

	public User findByAccount(String account) {
		Assert.isTrue(!StringUtils.isEmpty(account), "账户信息不能为空!");
		UserExample example = new UserExample();
		example.createCriteria().andAccountEqualTo(account.trim());
		List<User> userList = userMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(userList)) {
			return null;
		}
		return userList.get(0);
	}

	@TargetDataSource(dataSourceKey = DataSourceKey.MASTER)
	@Transactional
	public User save(User user) {
		User u = findByAccount(user.getAccount());
		if (u == null) {
			user.setRgsTime(new Date());
			userMapper.insertSelective(user);
		} else {
			user.setUpdateTime(new Date());
			userMapper.updateByPrimaryKeySelective(user);
		}
		return user;
	}

	public PageInfo<UserRunPoint> findRunHistryList(Long userId, Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		PageInfo<UserRunPoint> result = new PageInfo<UserRunPoint>(userRunPointMapper.findRunHistryList(userId));
		return result;
	}

	@Override
	public void savePhoneVersion(PhoneVersion phoneVersion) {
		Assert.notNull(phoneVersion, "插入的对象不能为空");
		if (phoneVersion.getId() == null) {
			phoneVersion.setCreateTime(new Date());
			phoneVersion.setUpdateTime(new Date());
			phoneVersionMapper.insertSelective(phoneVersion);
		} else {
			phoneVersion.setUpdateTime(new Date());
			phoneVersionMapper.updateByPrimaryKeySelective(phoneVersion);
		}
	}

	@TargetDataSource(dataSourceKey = DataSourceKey.MASTER)
	@Transactional
	public void saveSmsLog(SmsLog smslog) {
		smslog.setCreateTime(new Date());
		smslog.setModifyTime(new Date());
		if (smslog.getId() == null) {
			smsLogMapper.insertSelective(smslog);
		} else {
			smsLogMapper.updateByPrimaryKeySelective(smslog);
		}
	}

	@Override
	public User findBindByDeviceNo(String deviceNo) {
		return userMapper.findByDeviceNo(deviceNo, SOCOAPIConstatns.BIND);
	}

}
