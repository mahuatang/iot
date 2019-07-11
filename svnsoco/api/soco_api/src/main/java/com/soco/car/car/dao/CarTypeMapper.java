package com.soco.car.car.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soco.car.car.entity.CarType;
import com.soco.car.car.entity.CarTypeExample;

public interface CarTypeMapper {
    long countByExample(CarTypeExample example);

    int deleteByExample(CarTypeExample example);

    int deleteByPrimaryKey(String carTypeCode);

    int insert(CarType record);

    int insertSelective(CarType record);

    List<CarType> selectByExample(CarTypeExample example);

    CarType selectByPrimaryKey(String carTypeCode);

    int updateByExampleSelective(@Param("record") CarType record, @Param("example") CarTypeExample example);

    int updateByExample(@Param("record") CarType record, @Param("example") CarTypeExample example);

    int updateByPrimaryKeySelective(CarType record);

    int updateByPrimaryKey(CarType record);
    /**
     * ext
     */
    
    List<CarType> findByPage();
    
    List<String> findChildAll();
    
	CarType findByDeviceNo(String deviceNo);
}