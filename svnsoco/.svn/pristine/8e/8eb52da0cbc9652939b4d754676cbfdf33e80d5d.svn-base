package com.soco.car.car.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soco.car.car.entity.CarTypeMapping;
import com.soco.car.car.entity.CarTypeMappingExample;

public interface CarTypeMappingMapper {
	long countByExample(CarTypeMappingExample example);

	int deleteByExample(CarTypeMappingExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CarTypeMapping record);

	int insertSelective(CarTypeMapping record);

	List<CarTypeMapping> selectByExample(CarTypeMappingExample example);

	CarTypeMapping selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CarTypeMapping record,
			@Param("example") CarTypeMappingExample example);

	int updateByExample(@Param("record") CarTypeMapping record, @Param("example") CarTypeMappingExample example);

	int updateByPrimaryKeySelective(CarTypeMapping record);

	int updateByPrimaryKey(CarTypeMapping record);
	/**
	 * ext
	 */
}