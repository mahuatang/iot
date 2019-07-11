package com.soco.car.car.dao;

import com.soco.car.car.entity.CarPicture;
import com.soco.car.car.entity.CarPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarPictureMapper {
    long countByExample(CarPictureExample example);

    int deleteByExample(CarPictureExample example);

    int deleteByPrimaryKey(Long showpictureid);

    int insert(CarPicture record);

    int insertSelective(CarPicture record);

    List<CarPicture> selectByExample(CarPictureExample example);

    CarPicture selectByPrimaryKey(Long showpictureid);

    int updateByExampleSelective(@Param("record") CarPicture record, @Param("example") CarPictureExample example);

    int updateByExample(@Param("record") CarPicture record, @Param("example") CarPictureExample example);

    int updateByPrimaryKeySelective(CarPicture record);

    int updateByPrimaryKey(CarPicture record);
}