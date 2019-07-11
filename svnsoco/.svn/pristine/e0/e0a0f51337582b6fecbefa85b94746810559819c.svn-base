package com.soco.car.user.dao;

import com.soco.car.user.entity.RepairAreas;
import com.soco.car.user.entity.RepairAreasExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairAreasMapper {
    long countByExample(RepairAreasExample example);

    int deleteByExample(RepairAreasExample example);

    int deleteByPrimaryKey(Long areaId);

    int insert(RepairAreas record);

    int insertSelective(RepairAreas record);

    List<RepairAreas> selectByExample(RepairAreasExample example);

    RepairAreas selectByPrimaryKey(Long areaId);

    int updateByExampleSelective(@Param("record") RepairAreas record, @Param("example") RepairAreasExample example);

    int updateByExample(@Param("record") RepairAreas record, @Param("example") RepairAreasExample example);

    int updateByPrimaryKeySelective(RepairAreas record);

    int updateByPrimaryKey(RepairAreas record);
}