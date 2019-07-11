package com.soco.car.car.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.soco.car.car.api.ConfigApi;
import com.soco.car.car.dao.ConfigAboutMapper;
import com.soco.car.car.dao.ConfigStartMapper;
import com.soco.car.car.dao.ConfigVersionMapper;
import com.soco.car.car.entity.ConfigAbout;
import com.soco.car.car.entity.ConfigStart;
import com.soco.car.car.entity.ConfigVersion;
import com.soco.car.user.dao.CarTypeInstructionsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@Service(interfaceClass = ConfigApi.class, timeout = 30000)
public class ConfigService implements ConfigApi{
    private static final Logger logger = LoggerFactory.getLogger(CarTypeService.class);

    @Autowired
    private ConfigAboutMapper configAboutMapper;

    @Autowired
    private ConfigVersionMapper configVersionMapper;

    @Autowired
    private CarTypeInstructionsMapper carTypeInstructionsMapper;

    @Override
    public ConfigAbout selectAboutConfigInfo() {
        return configAboutMapper.selectAboutConfigInfo();
    }

    @Override
    public String selectKefuConfigInfo() {
        return configAboutMapper.selectKefuConfigInfo();
    }

    @Override
    public Double selectThirdUrlMoneyConfigInfo() {
        return configAboutMapper.selectThirdUrlMoneyConfigInfo();
    }

    @Override
    public ConfigVersion selectFirmwareVersionInfo(Integer objectType) {
        Assert.notNull(objectType, "对象类型不能为空");
        return configVersionMapper.selectFirmwareVersionInfo(objectType);
    }

    @Override
    public ConfigVersion selectVersionInfo(Long configId) {
        if (configId == null) {
            configId = 1l;
        }
        return configVersionMapper.selectByPrimaryKey(configId);
    }

    @Override
    public String getUserProductInstructions(String carType) {
        Assert.notNull(carType, "车辆类型不能为空");
        return carTypeInstructionsMapper.selectByPrimaryKey(carType).getInstructionsUrl();
    }
}
