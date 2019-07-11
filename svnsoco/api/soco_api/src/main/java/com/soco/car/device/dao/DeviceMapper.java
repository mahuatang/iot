package com.soco.car.device.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soco.car.device.entity.Device;
import com.soco.car.device.entity.DeviceExample;
import com.soco.car.device.entity.ext.DeviceBindExt;
import com.soco.car.user.entity.Userbinddevice;

public interface DeviceMapper {
    long countByExample(DeviceExample example);

    int deleteByExample(DeviceExample example);

    int deleteByPrimaryKey(Long deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(Long deviceId);

    int updateByExampleSelective(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByExample(@Param("record") Device record, @Param("example") DeviceExample example);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
    
    /**
     *  下面为扩展方法
     */

    Device selectDeviceInfoBysnCode(Userbinddevice ubd);

    void updateDeviceInfo(Device device);
    
    DeviceBindExt queryDeviceInfoByDeviceNo(String deviceNo);
    
    DeviceBindExt queryDeviceInfoByUserId(Long userId);
    
    
    List<DeviceBindExt> queryUserBindDeviceByPage(Long userId);
}