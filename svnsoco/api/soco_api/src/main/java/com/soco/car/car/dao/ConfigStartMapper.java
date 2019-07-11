package com.soco.car.car.dao;

import com.soco.car.car.entity.ConfigStart;
import com.soco.car.car.entity.ConfigStartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigStartMapper {
    long countByExample(ConfigStartExample example);

    int deleteByExample(ConfigStartExample example);

    int deleteByPrimaryKey(Long startid);

    int insert(ConfigStart record);

    int insertSelective(ConfigStart record);

    List<ConfigStart> selectByExample(ConfigStartExample example);

    ConfigStart selectByPrimaryKey(Long startid);

    int updateByExampleSelective(@Param("record") ConfigStart record, @Param("example") ConfigStartExample example);

    int updateByExample(@Param("record") ConfigStart record, @Param("example") ConfigStartExample example);

    int updateByPrimaryKeySelective(ConfigStart record);

    int updateByPrimaryKey(ConfigStart record);
}