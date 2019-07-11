package com.soco.car.app.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.soco.car.app.api.request.BaseRequest;
import com.soco.car.app.api.response.BaseResponse;
import com.soco.car.app.handler.BaseResponseGenerator;
import com.soco.car.app.service.UserbinddeviceService;
import com.soco.car.user.api.UserbinddeviceApi;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/rest/v1/Userbinddevice")
@Api(value = "/rest/v1/Userbinddevice", tags = { "车辆管理相关接口服务" })
public class UserbinddeviceController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(UserbinddeviceController.class);

	@Autowired
	private UserbinddeviceService userbinddeviceService;

<<<<<<< .mine
    @ApiOperation("绑定设备")
    @PostMapping("userBindDevice/{deviceNo}")
    public BaseResponse userBindDevice(@PathVariable("deviceNo") String deviceNo) {
        return userbinddeviceService.userBindDevice(deviceNo, getUser().getUserId());
    }
=======
	@Reference
	private UserbinddeviceApi userbinddeviceApi;
>>>>>>> .r119

<<<<<<< .mine
    @ApiOperation("解绑设备")
    @PostMapping("userUnBindDevice/{deviceNo}")
    public BaseResponse userUnBindDevice(@PathVariable("deviceNo") String deviceNo) {
        return userbinddeviceService.userUnBindDevice(deviceNo, getUser().getUserId());
    }
=======
	@PostMapping("getCourseUrl/{protype}")
	public BaseResponse getCourseUrl(@PathVariable String protype) {
		return userbinddeviceService.getCourseUrl(protype);
	}
>>>>>>> .r119

<<<<<<< .mine
    @ApiOperation("根据条件查询用户的历史绑定信息")
    @PostMapping("queryMyBindedDevice")
    public BaseResponse queryMyBindedDevice(@RequestBody BindedDeviceRequest bindedDeviceRequest) {
        return userbinddeviceService.queryMyBindedDevice(bindedDeviceRequest);
    }
=======
	@PostMapping("checkUserBindDevice/{deviceNo}")
	public BaseResponse checkUserBindDevice(@PathVariable String deviceNo) {
		return userbinddeviceService.checkUserBindDevice(deviceNo, getUser());
	}
>>>>>>> .r119

<<<<<<< .mine
    @ApiOperation("查询指定设备消耗统计信息")
    @PostMapping("queryDeviceStatisMsg")
    public BaseResponse queryDeviceStatisMsg(@RequestBody DeviceStateRequest deviceStateRequest) {
        return userbinddeviceService.queryDeviceStatisMsg(deviceStateRequest);
    }
=======
	@PostMapping("bindDevice/{deviceNo}")
	public BaseResponse bindDevice(@PathVariable String deviceNo) {
		return userbinddeviceService.bindDevice(deviceNo, getUser());
	}
>>>>>>> .r119

<<<<<<< .mine
    @ApiOperation("根据设备编号查询设备信息")
    @PostMapping("selectDeviceInfo/{deviceNo}")
    public BaseResponse selectDeviceInfo(@PathVariable("deviceNo") String deviceNo) {
        return userbinddeviceService.selectDeviceInfo(deviceNo);
    }
=======
	@PostMapping("unbindDevice/{deviceNo}")
	public BaseResponse unbindDevice(@PathVariable String deviceNo) {
		return userbinddeviceService.unbindDevice(deviceNo, getUser());
	}
>>>>>>> .r119

<<<<<<< .mine
    @ApiOperation("获取新手教程url")
    @PostMapping("getCourseUrl/{protype}")
    public BaseResponse getCourseUrl(String protype) {
        return userbinddeviceService.getCourseUrl(protype);
    }
=======
	@PostMapping("list")
	public BaseResponse list(@RequestBody BaseRequest baseRequest) {
		return BaseResponseGenerator.genSuccessResult(userbinddeviceApi.queryUserBindDeviceByPage(getUser().getUserId(),
				baseRequest.getPageNum(), baseRequest.getPageSize()));
	}
>>>>>>> .r119
}
