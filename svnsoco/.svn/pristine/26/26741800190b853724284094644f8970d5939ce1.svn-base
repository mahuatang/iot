package com.soco.car.user.dao;

import com.soco.car.user.entity.Dict;
import com.soco.car.user.entity.DictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictMapper {
	long countByExample(DictExample example);

	int deleteByExample(DictExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Dict record);

	int insertSelective(Dict record);

	List<Dict> selectByExample(DictExample example);

	Dict selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Dict record, @Param("example") DictExample example);

	int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);

	int updateByPrimaryKeySelective(Dict record);

	int updateByPrimaryKey(Dict record);

	/**
	 * ext下面方法为扩展方法
	 */

	List<Dict> findByChild(String code);

}