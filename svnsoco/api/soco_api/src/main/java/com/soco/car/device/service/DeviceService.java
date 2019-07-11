/**
 * Project Name:SOCO_API
 * File Name:DeviceService.java
 * Package Name:com.soco.car.device.service
 * Date:2018年7月23日下午8:13:51
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.device.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soco.car.car.entity.CarType;
import com.soco.car.common.constatns.SOCOAPIConstatns;
import com.soco.car.common.dsl.DataSourceKey;
import com.soco.car.common.dsl.TargetDataSource;
import com.soco.car.device.api.DeviceApi;
import com.soco.car.device.dao.DeviceCourseUrlMapper;
import com.soco.car.device.dao.DeviceMapper;
import com.soco.car.device.dao.DeviceWarnMapper;
import com.soco.car.device.entity.Device;
import com.soco.car.device.entity.DeviceCourseUrl;
import com.soco.car.device.entity.DeviceExample;
import com.soco.car.device.entity.DeviceWarn;
import com.soco.car.device.entity.DeviceWarnExample;
import com.soco.car.device.entity.DeviceWarnExample.Criteria;
import com.soco.car.device.entity.ext.DeviceBindExt;
import com.soco.car.user.dao.UserRunPointMapper;
import com.soco.car.user.entity.UserRunPoint;
import com.soco.car.user.entity.UserRunPointExample;
import com.soco.car.user.entity.Userbinddevice;

/**
 * ClassName:DeviceService <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月23日 下午8:13:51 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service(interfaceClass = DeviceApi.class, timeout = 30000)
public class DeviceService implements DeviceApi {

	@Autowired
	private DeviceMapper deviceMapper;

	@Autowired
	private DeviceCourseUrlMapper deviceCourseUrlMapper;

	@Autowired
	private DeviceWarnMapper deviceWarnMapper;

	@Autowired
	private UserRunPointMapper userRunPointMapper;

	public List<Device> findAll() {
		return deviceMapper.selectByExample(null);
	}

	@Override
	public PageInfo<DeviceWarn> findDeviceWarnByPage(Long userId, Integer delFlag, Integer pageNum, Integer pageSize) {
		Assert.notNull(userId, "用户ID不能为空");
		Assert.notNull(pageNum, "页数不能为空");
		Assert.notNull(pageSize, "每页显示的条数不能为空");
		PageHelper.startPage(pageNum, pageSize);
		DeviceWarnExample example = new DeviceWarnExample();
		Criteria c = example.createCriteria();
		c.andUserIdEqualTo(userId);
		if (null != delFlag) {
			c.andDelFlagEqualTo(delFlag);
		}
		PageInfo<DeviceWarn> reuslt = new PageInfo<DeviceWarn>(deviceWarnMapper.selectByExample(example));
		return reuslt;
	}

	@TargetDataSource(dataSourceKey = DataSourceKey.MASTER)
	@Transactional
	public void removeWarnIds(String warnIds) {
		Assert.notNull("预警id不能为空", warnIds);
		String[] ids = warnIds.split(",");
		for (String warnId : ids) {
			DeviceWarn deviceWarn = new DeviceWarn();
			if (StringUtils.isEmpty(warnId)) {
				continue;
			}
			deviceWarn.setWarnId(Long.parseLong(warnId));
			deviceWarn.setDelFlag(SOCOAPIConstatns.Y);
			deviceWarnMapper.updateByPrimaryKeySelective(deviceWarn);
		}
	}

	@Override
	public List<DeviceCourseUrl> getCourseUrl(String protype) {
		List<DeviceCourseUrl> list = deviceCourseUrlMapper.getCourseUrl(protype);
		return list;
	}

	@TargetDataSource(dataSourceKey = DataSourceKey.MASTER)
	@Transactional
	@Override
	public void updateDeviceInfo(Device device) {
		Assert.notNull(device, "设备信息不能为空");
		deviceMapper.updateDeviceInfo(device);
	}

	@Override
	public DeviceBindExt queryDeviceInfoByDeviceNo(String deviceNo) {
		Assert.notNull(deviceNo, "设备号不能为空");
		return deviceMapper.queryDeviceInfoByDeviceNo(deviceNo);
	}


	@TargetDataSource(dataSourceKey = DataSourceKey.MASTER)
	@Transactional
	@Override
	public void removePointIds(String pointIds) {
		String[] ids = pointIds.split(",");
		for (String pointId : ids) {
			UserRunPoint userRunPoint = new UserRunPoint();
			if (StringUtils.isEmpty(pointId)) {
				continue;
			}
			userRunPoint.setPointId(Long.parseLong(pointId));
			userRunPoint.setDelFlag(SOCOAPIConstatns.Y);
			userRunPointMapper.updateByPrimaryKeySelective(userRunPoint);
		}
	}

	@TargetDataSource(dataSourceKey = DataSourceKey.MASTER)
	@Transactional
	@Override
	public void removeUserRunPointByUserId(Long userId) {
		Assert.notNull(userId, "用户ID不能为空");
		UserRunPoint userRunPoint = new UserRunPoint();
		userRunPoint.setDelFlag(SOCOAPIConstatns.Y);
		UserRunPointExample example = new UserRunPointExample();
		example.createCriteria().andUserIdEqualTo(userId);
		userRunPointMapper.updateByExampleSelective(userRunPoint, example);
	}

	@Override
	public void saveDeviceWarn(DeviceWarn deviceWarn) {
		Long warnId = deviceWarn.getWarnId();
		if (warnId == null) {
			deviceWarn.setCreateTime(new Date());
			deviceWarn.setUpdateTime(new Date());
			deviceWarnMapper.insertSelective(deviceWarn);
		} else {
			deviceWarnMapper.updateByPrimaryKeySelective(deviceWarn);
		}
	}
	
	public Device findByDeviceNo(String deviceNo){
		Assert.notNull(deviceNo,"设备号不能为空");
		DeviceExample example=new DeviceExample();
		example.createCriteria().andDeviceNoEqualTo(deviceNo);
		List<Device> deviceList=deviceMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(deviceList)) {
			return null;
		}
		return deviceList.get(0);
	}
}
