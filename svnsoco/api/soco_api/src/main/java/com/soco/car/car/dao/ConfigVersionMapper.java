package com.soco.car.car.dao;

import com.soco.car.car.entity.ConfigVersion;
import com.soco.car.car.entity.ConfigVersionExample;
import java.util.List;

import com.soco.car.user.entity.PhoneVersion;
import org.apache.ibatis.annotations.Param;

public interface ConfigVersionMapper {
    long countByExample(ConfigVersionExample example);

    int deleteByExample(ConfigVersionExample example);

    int deleteByPrimaryKey(Long configid);

    int insert(ConfigVersion record);

    int insertSelective(ConfigVersion record);

    List<ConfigVersion> selectByExample(ConfigVersionExample example);

    ConfigVersion selectByPrimaryKey(Long configid);

    int updateByExampleSelective(@Param("record") ConfigVersion record, @Param("example") ConfigVersionExample example);

    int updateByExample(@Param("record") ConfigVersion record, @Param("example") ConfigVersionExample example);

    int updateByPrimaryKeySelective(ConfigVersion record);

    int updateByPrimaryKey(ConfigVersion record);

    /**
     * 以下是新增加的方法
     */

    ConfigVersion selectFirmwareVersionInfo(Integer objectType);
}