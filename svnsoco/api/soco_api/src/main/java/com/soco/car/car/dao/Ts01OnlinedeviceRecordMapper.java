package com.soco.car.car.dao;

import com.soco.car.car.entity.Ts01OnlinedeviceRecord;
import com.soco.car.car.entity.Ts01OnlinedeviceRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Ts01OnlinedeviceRecordMapper {
    long countByExample(Ts01OnlinedeviceRecordExample example);

    int deleteByExample(Ts01OnlinedeviceRecordExample example);

    int deleteByPrimaryKey(Long recordid);

    int insert(Ts01OnlinedeviceRecord record);

    int insertSelective(Ts01OnlinedeviceRecord record);

    List<Ts01OnlinedeviceRecord> selectByExample(Ts01OnlinedeviceRecordExample example);

    Ts01OnlinedeviceRecord selectByPrimaryKey(Long recordid);

    int updateByExampleSelective(@Param("record") Ts01OnlinedeviceRecord record, @Param("example") Ts01OnlinedeviceRecordExample example);

    int updateByExample(@Param("record") Ts01OnlinedeviceRecord record, @Param("example") Ts01OnlinedeviceRecordExample example);

    int updateByPrimaryKeySelective(Ts01OnlinedeviceRecord record);

    int updateByPrimaryKey(Ts01OnlinedeviceRecord record);
}