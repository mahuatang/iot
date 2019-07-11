package com.soco.car.user.dao;

import com.soco.car.user.entity.CarTypeInstructions;
import com.soco.car.user.entity.CarTypeInstructionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarTypeInstructionsMapper {
    long countByExample(CarTypeInstructionsExample example);

    int deleteByExample(CarTypeInstructionsExample example);

    int deleteByPrimaryKey(String carType);

    int insert(CarTypeInstructions record);

    int insertSelective(CarTypeInstructions record);

    List<CarTypeInstructions> selectByExample(CarTypeInstructionsExample example);

    CarTypeInstructions selectByPrimaryKey(String carType);

    int updateByExampleSelective(@Param("record") CarTypeInstructions record, @Param("example") CarTypeInstructionsExample example);

    int updateByExample(@Param("record") CarTypeInstructions record, @Param("example") CarTypeInstructionsExample example);

    int updateByPrimaryKeySelective(CarTypeInstructions record);

    int updateByPrimaryKey(CarTypeInstructions record);
}