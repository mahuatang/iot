package com.soco.car.car.dao;

import com.soco.car.car.entity.CarBaseinfo;
import com.soco.car.car.entity.CarBaseinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarBaseinfoMapper {
    long countByExample(CarBaseinfoExample example);

    int deleteByExample(CarBaseinfoExample example);

    int deleteByPrimaryKey(String vehiclebarcode);

    int insert(CarBaseinfo record);

    int insertSelective(CarBaseinfo record);

    List<CarBaseinfo> selectByExample(CarBaseinfoExample example);

    CarBaseinfo selectByPrimaryKey(String vehiclebarcode);

    int updateByExampleSelective(@Param("record") CarBaseinfo record, @Param("example") CarBaseinfoExample example);

    int updateByExample(@Param("record") CarBaseinfo record, @Param("example") CarBaseinfoExample example);

    int updateByPrimaryKeySelective(CarBaseinfo record);

    int updateByPrimaryKey(CarBaseinfo record);
}