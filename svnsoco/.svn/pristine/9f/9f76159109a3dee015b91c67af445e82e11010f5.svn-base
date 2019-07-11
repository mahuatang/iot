package com.soco.car.user.api;

import com.github.pagehelper.PageInfo;
import com.soco.car.device.entity.ext.DeviceBindExt;

public interface UserbinddeviceApi {
	/**
	 * 检查用户是否有绑定过其他设备
	 * 
	 * @param ubd
	 * @return
	 * @throws Exception
	 */
	public boolean checkUserBindDevice(Long userId);

	/**
	 * 获取用户绑定的设备列表分页展示 queryUserBindDeviceByPage:
	 *
	 * @author sunlangping
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<DeviceBindExt> queryUserBindDeviceByPage(Long userId, int pageNum, int pageSize);

	/**
	 * 
	 * bindDevice: 绑定设备
	 *
	 * @author sunlangping
	 */
	public void bindDevice(Long userId, String deviceNo);
	/**
	 * 
	 * unbindDevice:解绑设备
	 *
	 * @author sunlangping
	 * @param userId
	 * @param deviceNo
	 */
	public void unbindDevice(Long userId, String deviceNo);
	
    public DeviceBindExt queryDeviceInfoByUserId(Long userId);
}
