package com.soco.car.user.dao;

import com.soco.car.user.entity.UserRunPoint;
import com.soco.car.user.entity.UserRunPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRunPointMapper {
	long countByExample(UserRunPointExample example);

	int deleteByExample(UserRunPointExample example);

	int deleteByPrimaryKey(Long pointId);

	int insert(UserRunPoint record);

	int insertSelective(UserRunPoint record);

	List<UserRunPoint> selectByExample(UserRunPointExample example);

	UserRunPoint selectByPrimaryKey(Long pointId);

	int updateByExampleSelective(@Param("record") UserRunPoint record, @Param("example") UserRunPointExample example);

	int updateByExample(@Param("record") UserRunPoint record, @Param("example") UserRunPointExample example);

	int updateByPrimaryKeySelective(UserRunPoint record);

	int updateByPrimaryKey(UserRunPoint record);

	/**
	 * 下面为扩展方法
	 */

	List<UserRunPoint> findRunHistryList(Long userId);
}