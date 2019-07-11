package com.soco.car.car.dao;

import com.soco.car.car.entity.ConfigAbout;
import com.soco.car.car.entity.ConfigAboutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigAboutMapper {
    long countByExample(ConfigAboutExample example);

    int deleteByExample(ConfigAboutExample example);

    int deleteByPrimaryKey(Long aboutid);

    int insert(ConfigAbout record);

    int insertSelective(ConfigAbout record);

    List<ConfigAbout> selectByExampleWithBLOBs(ConfigAboutExample example);

    List<ConfigAbout> selectByExample(ConfigAboutExample example);

    ConfigAbout selectByPrimaryKey(Long aboutid);

    int updateByExampleSelective(@Param("record") ConfigAbout record, @Param("example") ConfigAboutExample example);

    int updateByExampleWithBLOBs(@Param("record") ConfigAbout record, @Param("example") ConfigAboutExample example);

    int updateByExample(@Param("record") ConfigAbout record, @Param("example") ConfigAboutExample example);

    int updateByPrimaryKeySelective(ConfigAbout record);

    int updateByPrimaryKeyWithBLOBs(ConfigAbout record);

    int updateByPrimaryKey(ConfigAbout record);

    /**
     *  以下是新增加的方法
     */

    ConfigAbout selectAboutConfigInfo();

    String selectKefuConfigInfo();

    Double selectThirdUrlMoneyConfigInfo();
}