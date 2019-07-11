package com.soco.car.user.dao;

import com.soco.car.user.entity.PhoneVersion;
import com.soco.car.user.entity.PhoneVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhoneVersionMapper {
    long countByExample(PhoneVersionExample example);

    int deleteByExample(PhoneVersionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PhoneVersion record);

    int insertSelective(PhoneVersion record);

    List<PhoneVersion> selectByExample(PhoneVersionExample example);

    PhoneVersion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PhoneVersion record, @Param("example") PhoneVersionExample example);

    int updateByExample(@Param("record") PhoneVersion record, @Param("example") PhoneVersionExample example);

    int updateByPrimaryKeySelective(PhoneVersion record);

    int updateByPrimaryKey(PhoneVersion record);
}