package com.soco.car.user.dao;

import com.soco.car.user.entity.SmsCountry;
import com.soco.car.user.entity.SmsCountryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsCountryMapper {
    long countByExample(SmsCountryExample example);

    int deleteByExample(SmsCountryExample example);

    int deleteByPrimaryKey(String countryCode);

    int insert(SmsCountry record);

    int insertSelective(SmsCountry record);

    List<SmsCountry> selectByExample(SmsCountryExample example);

    SmsCountry selectByPrimaryKey(String countryCode);

    int updateByExampleSelective(@Param("record") SmsCountry record, @Param("example") SmsCountryExample example);

    int updateByExample(@Param("record") SmsCountry record, @Param("example") SmsCountryExample example);

    int updateByPrimaryKeySelective(SmsCountry record);

    int updateByPrimaryKey(SmsCountry record);
}