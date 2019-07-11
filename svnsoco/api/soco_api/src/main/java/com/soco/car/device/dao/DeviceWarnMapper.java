package com.soco.car.device.dao;

import com.soco.car.device.entity.DeviceWarn;
import com.soco.car.device.entity.DeviceWarnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceWarnMapper {
    long countByExample(DeviceWarnExample example);

    int deleteByExample(DeviceWarnExample example);

    int deleteByPrimaryKey(Long warnId);

    int insert(DeviceWarn record);

    int insertSelective(DeviceWarn record);

    List<DeviceWarn> selectByExample(DeviceWarnExample example);

    DeviceWarn selectByPrimaryKey(Long warnId);

    int updateByExampleSelective(@Param("record") DeviceWarn record, @Param("example") DeviceWarnExample example);

    int updateByExample(@Param("record") DeviceWarn record, @Param("example") DeviceWarnExample example);

    int updateByPrimaryKeySelective(DeviceWarn record);

    int updateByPrimaryKey(DeviceWarn record);
}