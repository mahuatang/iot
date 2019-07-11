package com.soco.car.app.controller;

import com.soco.car.app.service.ConfigService;
import com.soco.car.app.service.UserService;
import com.soco.car.car.api.ConfigApi;
import com.soco.car.user.api.ProblemAnalysisApi;
import com.soco.car.user.entity.PhoneVersion;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.soco.car.app.api.response.BaseResponse;
import com.soco.car.app.handler.BaseResponseGenerator;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/rest/v1/config")
@Api(value = "/rest/v1/config", tags = { "查询配置信息相关接口" })
public class ConfigController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

	@Reference
    private ConfigApi configApi;

    @Reference
    private ProblemAnalysisApi problemAnalysisApi;

    @Autowired
    private ConfigService configService;

    @Autowired
    private UserService userService;

	@PostMapping("selectConfig")
	@ApiOperation("查询关于我们配置信息")
	public BaseResponse selectAboutConfigInfo() {
		return BaseResponseGenerator.genSuccessResult(configApi.selectAboutConfigInfo());
	}

	@PostMapping("selectKefu")
	@ApiOperation("查询客服电话配置信息")
	public BaseResponse selectKefuConfigInfo() {
		return BaseResponseGenerator.genSuccessResult(configApi.selectKefuConfigInfo());
	}

	@PostMapping("selectThirdUrlMoney")
	@ApiOperation("第三方URL限额配置信息")
	public BaseResponse selectThirdUrlMoneyConfigInfo() {
		return BaseResponseGenerator.genSuccessResult(configApi.selectThirdUrlMoneyConfigInfo());
	}

	@PostMapping("listAllProblem")
	@ApiOperation("查询故障分析列表")
	public BaseResponse listAllProblem() {
		return BaseResponseGenerator.genSuccessResult(problemAnalysisApi.listAllProblem());
	}

	@PostMapping("selectVersion/{configId}")
	@ApiOperation("查询版本配置信息")
	public BaseResponse selectVersionInfo(@PathVariable("configId") Long configId) {
		return BaseResponseGenerator.genSuccessResult(configApi.selectVersionInfo(configId));
	}

	@PostMapping("selectFirmwareVersion/{objectType}")
	@ApiOperation("查询固件版本配置信息")
	public BaseResponse selectFirmwareVersionInfo(@PathVariable("objectType") Integer objectType) {
		return BaseResponseGenerator.genSuccessResult(configApi.selectFirmwareVersionInfo(objectType));
	}

	/**
	 * 检查是否需要版本升级
	 * @param versionNo
	 * @return
	 */
	@PostMapping("isUpgradeVersion/{versionNo}/{systemName}")
	public BaseResponse isUpgradeVersion(@PathVariable("versionNo") Integer versionNo, @PathVariable("systemName") String systemName) {
		return configService.isUpgradeVersion(versionNo, systemName);
	}

	/**
	 * 查询用户产品说明书
	 * @param carType
	 * @return
	 */
	@PostMapping("getInstructions/{carType}")
	@ApiOperation("查看用户产品说明书")
	public BaseResponse getInstructions(@PathVariable("carType") String carType) {
		return configService.getUserProductInstructions(carType);
	}
}
