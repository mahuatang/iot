package com.soco.car.car.api;

import com.soco.car.car.entity.ConfigAbout;
import com.soco.car.car.entity.ConfigStart;
import com.soco.car.car.entity.ConfigVersion;
import com.soco.car.user.entity.PhoneVersion;

public interface ConfigApi {
    /**
     * APP前端，查询关于我们配置信息
     * @return
     */
    public ConfigAbout selectAboutConfigInfo();

    /**
     * APP前端，查询客服电话配置信息
     * @return
     */
    public String selectKefuConfigInfo();

    /**
     * APP前端，第三方URL限额配置信息
     * @return
     */
    public Double selectThirdUrlMoneyConfigInfo();

    /**
     * 查询固件版本配置信息
     * @param objectType
     * @return
     */
    public ConfigVersion selectFirmwareVersionInfo(Integer objectType);

    /**
     * 查询版本配置信息
     * @param configId
     * @return
     */
    public ConfigVersion selectVersionInfo(Long configId);

    /**
     * 查看用户产品说明书
     * @param carType
     * @return
     */
    public String getUserProductInstructions(String carType);
}
