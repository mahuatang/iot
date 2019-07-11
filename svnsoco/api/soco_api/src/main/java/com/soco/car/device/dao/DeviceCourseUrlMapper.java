package com.soco.car.device.dao;

import com.soco.car.device.entity.DeviceCourseUrl;
import com.soco.car.device.entity.DeviceCourseUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceCourseUrlMapper {
    long countByExample(DeviceCourseUrlExample example);

    int deleteByExample(DeviceCourseUrlExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DeviceCourseUrl record);

    int insertSelective(DeviceCourseUrl record);

    List<DeviceCourseUrl> selectByExampleWithBLOBs(DeviceCourseUrlExample example);

    List<DeviceCourseUrl> selectByExample(DeviceCourseUrlExample example);

    DeviceCourseUrl selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DeviceCourseUrl record, @Param("example") DeviceCourseUrlExample example);

    int updateByExampleWithBLOBs(@Param("record") DeviceCourseUrl record, @Param("example") DeviceCourseUrlExample example);

    int updateByExample(@Param("record") DeviceCourseUrl record, @Param("example") DeviceCourseUrlExample example);

    int updateByPrimaryKeySelective(DeviceCourseUrl record);

    int updateByPrimaryKeyWithBLOBs(DeviceCourseUrl record);

    int updateByPrimaryKey(DeviceCourseUrl record);

    /**
     *  下面为扩展方法
     */

    public List<DeviceCourseUrl> getCourseUrl(String protype);
}