package com.soco.car.car.dao;

import com.soco.car.car.entity.Ts01ConfigVersion;
import com.soco.car.car.entity.Ts01ConfigVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Ts01ConfigVersionMapper {
    long countByExample(Ts01ConfigVersionExample example);

    int deleteByExample(Ts01ConfigVersionExample example);

    int deleteByPrimaryKey(Long configid);

    int insert(Ts01ConfigVersion record);

    int insertSelective(Ts01ConfigVersion record);

    List<Ts01ConfigVersion> selectByExample(Ts01ConfigVersionExample example);

    Ts01ConfigVersion selectByPrimaryKey(Long configid);

    int updateByExampleSelective(@Param("record") Ts01ConfigVersion record, @Param("example") Ts01ConfigVersionExample example);

    int updateByExample(@Param("record") Ts01ConfigVersion record, @Param("example") Ts01ConfigVersionExample example);

    int updateByPrimaryKeySelective(Ts01ConfigVersion record);

    int updateByPrimaryKey(Ts01ConfigVersion record);
}