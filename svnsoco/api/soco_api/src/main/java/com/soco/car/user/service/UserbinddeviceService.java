package com.soco.car.user.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soco.car.common.constatns.SOCOAPIConstatns;
import com.soco.car.device.dao.DeviceMapper;
import com.soco.car.device.entity.Device;
import com.soco.car.device.entity.ext.DeviceBindExt;
import com.soco.car.device.service.DeviceService;
import com.soco.car.user.api.UserbinddeviceApi;
import com.soco.car.user.dao.UserbinddeviceMapper;
import com.soco.car.user.entity.Userbinddevice;
import com.soco.car.user.entity.UserbinddeviceExample;
import com.soco.car.user.entity.UserbinddeviceExample.Criteria;

@Service(interfaceClass = UserbinddeviceApi.class, timeout = 30000)
public class UserbinddeviceService implements UserbinddeviceApi {

	@Autowired
	private UserbinddeviceMapper userbinddeviceMapper;

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private DeviceMapper deviceMapper;

	
	@Override
	public boolean checkUserBindDevice(Long userId) {
		UserbinddeviceExample example = new UserbinddeviceExample();
		Criteria c = example.createCriteria();
		c.andUserIdEqualTo(userId);
		c.andStateGreaterThanOrEqualTo(SOCOAPIConstatns.BIND);
		return !CollectionUtils.isEmpty(userbinddeviceMapper.selectByExample(example));
	}

	@Override
	public PageInfo<DeviceBindExt> queryUserBindDeviceByPage(Long userId, int pageNum, int pageSize) {
		Assert.notNull(userId, "查询的账号不能为空");
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<DeviceBindExt> reuslt = new PageInfo<DeviceBindExt>(deviceMapper.queryUserBindDeviceByPage(userId));
		return reuslt;
	}

	@Override
	public void bindDevice(Long userId, String deviceNo) {
		Assert.notNull(userId, "用户ID不能为空");
		Assert.notNull(deviceNo, "设备号不能为空");
		
		Device device = deviceService.findByDeviceNo(deviceNo);
		
		Assert.notNull(device, "绑定的设备在系统中不存在");
		
		Assert.isNull(deviceMapper.queryDeviceInfoByDeviceNo(deviceNo), "该设备已被绑定,无法继续绑定");
		
		Userbinddevice userbinddevice = new Userbinddevice();
		userbinddevice.setUserId(userId);
		userbinddevice.setBindTime(new Date());
		userbinddevice.setState(SOCOAPIConstatns.BIND);
		userbinddevice.setDeviceId(device.getDeviceId());
		userbinddeviceMapper.insertSelective(userbinddevice);
	}

	@Override
	public void unbindDevice(Long userId, String deviceNo) {
		Assert.notNull(userId, "用户ID不能为空");
		Assert.notNull(deviceNo, "设备号不能为空");
		Device device = deviceMapper.queryDeviceInfoByDeviceNo(deviceNo);
		Assert.notNull(device, "绑定设备时设备不能为空");
		UserbinddeviceExample example = new UserbinddeviceExample();
		example.createCriteria().andUserIdEqualTo(userId).andDeviceIdEqualTo(device.getDeviceId())
				.andStateEqualTo(SOCOAPIConstatns.BIND);
		List<Userbinddevice> userbinddeviceList = userbinddeviceMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(userbinddeviceList)) {
			return;
		}
		Userbinddevice ubd = userbinddeviceList.get(0);
		ubd.setState(SOCOAPIConstatns.UNBIND);
		ubd.setUnbindTime(new Date());
		userbinddeviceMapper.updateByPrimaryKeySelective(ubd);
	}

	@Override
	public DeviceBindExt queryDeviceInfoByUserId(Long userId) {
		return deviceMapper.queryDeviceInfoByUserId(userId);
	}
}
