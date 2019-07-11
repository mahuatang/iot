package com.soco.car.user.dao;

import com.soco.car.user.entity.Repairstation;
import com.soco.car.user.entity.RepairstationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairstationMapper {
    long countByExample(RepairstationExample example);

    int deleteByExample(RepairstationExample example);

    int deleteByPrimaryKey(Long stationid);

    int insert(Repairstation record);

    int insertSelective(Repairstation record);

    List<Repairstation> selectByExample(RepairstationExample example);

    Repairstation selectByPrimaryKey(Long stationid);

    int updateByExampleSelective(@Param("record") Repairstation record, @Param("example") RepairstationExample example);

    int updateByExample(@Param("record") Repairstation record, @Param("example") RepairstationExample example);

    int updateByPrimaryKeySelective(Repairstation record);

    int updateByPrimaryKey(Repairstation record);

    /**
     * 以下是新增加的方法
     */

    List<Repairstation> nearbyList(@Param("currLng") Double currLng, @Param("currLat") Double currLat, @Param("distance") Integer distance);
}