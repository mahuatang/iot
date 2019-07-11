package com.soco.car.user.dao;

import com.soco.car.user.entity.User;
import com.soco.car.user.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	long countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Long userId);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Long userId);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	/**
	 * 
	 * findUserByDeviceNo: 根据设备号查询设备绑定并激活使用的用户信息
	 *
	 * @author sunlangping
	 * @param deviceNo
	 * @return
	 */
	public User findByDeviceNo(@Param("deviceNo") String deviceNo, @Param("state") Integer state);
}