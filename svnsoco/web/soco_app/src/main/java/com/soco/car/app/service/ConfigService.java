package com.soco.car.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.soco.car.app.api.response.BaseResponse;
import com.soco.car.app.constants.ResponseMessageEnum;
import com.soco.car.app.constants.SOCOAppConstant;
import com.soco.car.app.handler.BaseResponseGenerator;
import com.soco.car.car.api.ConfigApi;
import com.soco.car.car.entity.ConfigVersion;

@Service
public class ConfigService {
    private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);

    @Reference
    private ConfigApi configApi;

    public BaseResponse isUpgradeVersion(Integer versionNo, String systemName) {
        Long configId = null;
        if (SOCOAppConstant.SYSTEM_IOS.equalsIgnoreCase(systemName)) {
            configId = SOCOAppConstant.CONFIG_TYPE_IOS;
        } else {
            configId = SOCOAppConstant.CONFIG_TYPE_ANDROID;
        }
        ConfigVersion configVersion = configApi.selectVersionInfo(configId);
        if (configVersion != null) {
            int sysVersion = configVersion.getVersionno();
            int appVersion = versionNo;
            if (appVersion >= sysVersion) {
                // 如果版本一致强制设置为不需要升级
                configVersion.setIsupgradeversion(SOCOAppConstant.UPGRADE_TYPE_NO);
                return BaseResponseGenerator.genSuccessResult(configVersion);
            }  else {
                return BaseResponseGenerator.genSuccessResult(configVersion);
            }
        } else {
            return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400, ResponseMessageEnum.is_update_version_fail.getValue());
        }
    }

    public BaseResponse getUserProductInstructions(String carType) {
        return  BaseResponseGenerator.genSuccessResult(configApi.getUserProductInstructions(carType));
    }
}
