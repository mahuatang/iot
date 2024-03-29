package com.soco.car.user.dao;

import com.soco.car.user.entity.SmsLog;
import com.soco.car.user.entity.SmsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsLogMapper {
    long countByExample(SmsLogExample example);

    int deleteByExample(SmsLogExample example);

    int deleteByPrimaryKey(Double id);

    int insert(SmsLog record);

    int insertSelective(SmsLog record);

    List<SmsLog> selectByExample(SmsLogExample example);

    SmsLog selectByPrimaryKey(Double id);

    int updateByExampleSelective(@Param("record") SmsLog record, @Param("example") SmsLogExample example);

    int updateByExample(@Param("record") SmsLog record, @Param("example") SmsLogExample example);

    int updateByPrimaryKeySelective(SmsLog record);

    int updateByPrimaryKey(SmsLog record);
}