package com.soco.car.user.dao;

import com.soco.car.user.entity.Userbinddevice;
import com.soco.car.user.entity.UserbinddeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserbinddeviceMapper {
    long countByExample(UserbinddeviceExample example);

    int deleteByExample(UserbinddeviceExample example);

    int deleteByPrimaryKey(Integer bindId);

    int insert(Userbinddevice record);

    int insertSelective(Userbinddevice record);

    List<Userbinddevice> selectByExample(UserbinddeviceExample example);

    Userbinddevice selectByPrimaryKey(Integer bindId);

    int updateByExampleSelective(@Param("record") Userbinddevice record, @Param("example") UserbinddeviceExample example);

    int updateByExample(@Param("record") Userbinddevice record, @Param("example") UserbinddeviceExample example);

    int updateByPrimaryKeySelective(Userbinddevice record);

    int updateByPrimaryKey(Userbinddevice record);
    
}