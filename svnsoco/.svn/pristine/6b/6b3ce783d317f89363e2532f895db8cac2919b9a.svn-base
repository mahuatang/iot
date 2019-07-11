/**
 * Project Name:soco_api
 * File Name:DeviceApi.java
 * Package Name:com.soco.car.device.api
 * Date:2018年7月26日下午3:55:53
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.device.api;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.soco.car.device.entity.Device;
import com.soco.car.device.entity.DeviceCourseUrl;
import com.soco.car.device.entity.DeviceWarn;
import com.soco.car.device.entity.ext.DeviceBindExt;

/**
 * ClassName:DeviceApi <br/>
 * Reason: 与设备相关的接口API <br/>
 * Date: 2018年7月26日 下午3:55:53 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public interface DeviceApi {

	/**
	 * 
	 * findDeviceWarnByPage:查询设备告警中的列表
	 *
	 * @author sunlangping
	 * @param userId		用户ID
	 * @param delFlag		传空查询全部
	 * @param pageNum		第×页
	 * @param pageSize		每页显示的条数
	 * @return
	 */
	public PageInfo<DeviceWarn> findDeviceWarnByPage(Long userId, Integer delFlag, Integer pageNum, Integer pageSize);

	/**
	 * 
	 * removeWarnIds:删除告警列表(逻辑删除)
	 *
	 * @author sunlangping
	 * @param warnIds
	 */
	public void removeWarnIds(String warnIds);
	/**
	 * 
	 * removePointIds:删除轨迹列表(逻辑删除)
	 *
	 * @author sunlangping
	 * @param pointIds
	 */
	public void removePointIds(String pointIds);

	/**
	 * 获取新手教程url
	 * @param protype		设备类型
	 */
	public List<DeviceCourseUrl> getCourseUrl(String protype);

	/**
	 * 修改设备信息，激活时间
	 * @param device		设备信息
	 * @throws Exception
	 */
	public void updateDeviceInfo(Device device);

	/**
	 * 根据设备编号查询设备信息
	 * @param deviceNo		设备号
	 * @throws Exception
	 */
	public DeviceBindExt queryDeviceInfoByDeviceNo(String deviceNo);
	
	/**
	 * 删除骑行点
	 * removeUserRunPointByUserId:
	 *
	 * @author sunlangping
	 * @param userId
	 */
	public void removeUserRunPointByUserId(Long userId);
	/**
	 * 
	 * saveDeviceWarn:	保存告警信息
	 *
	 * @author sunlangping
	 * @param deviceWarn
	 */
	public void saveDeviceWarn(DeviceWarn deviceWarn);
	/**
	 * 
	 * findByDeviceNo:查询设备编号
	 *
	 * @author sunlangping
	 * @param deviceNo
	 * @return
	 */
	public Device findByDeviceNo(String deviceNo);
}
