package com.soco.car.app.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.soco.car.app.api.response.BaseResponse;
import com.soco.car.app.constants.ResponseMessageEnum;
import com.soco.car.app.constants.SOCOAppConstant;
import com.soco.car.app.handler.BaseResponseGenerator;
import com.soco.car.bean.cache.TokenPOJO;
import com.soco.car.device.api.DeviceApi;
import com.soco.car.device.entity.Device;
import com.soco.car.device.entity.DeviceCourseUrl;
import com.soco.car.user.api.UserApi;
import com.soco.car.user.api.UserbinddeviceApi;

@Service
public class UserbinddeviceService {
	@Reference
	public UserbinddeviceApi userbinddeviceApi;

	@Reference
	public DeviceApi deviceApi;

	@Reference
	public UserApi userApi;

	public BaseResponse checkUserBindDevice(String deviceNo, TokenPOJO token) {
		Device device = deviceApi.findByDeviceNo(deviceNo);
		if (device == null) {
			return BaseResponseGenerator.genErrorResult(ResponseMessageEnum.device_no_error.getValue());
		}

		if (userbinddeviceApi.checkUserBindDevice(token.getUserId())) {
			return BaseResponseGenerator.genErrorResult(ResponseMessageEnum.user_already_bind_other_device.getValue());
		}
		return BaseResponseGenerator.genSuccessResult(null);
	}

	public BaseResponse bindDevice(String deviceNo, TokenPOJO token) {
		Device device = deviceApi.findByDeviceNo(deviceNo);
		if (device == null) {
			return BaseResponseGenerator.genErrorResult(ResponseMessageEnum.device_no_error.getValue());
		}
		device = deviceApi.queryDeviceInfoByDeviceNo(deviceNo);
		if (device != null) {
			return BaseResponseGenerator.genErrorResult(ResponseMessageEnum.device_already_bind.getValue());
		}
		userbinddeviceApi.bindDevice(token.getUserId(), deviceNo);
		return BaseResponseGenerator.genSuccessResult(null);
	}

	public BaseResponse unbindDevice(String deviceNo, TokenPOJO token) {
		userbinddeviceApi.unbindDevice(token.getUserId(), deviceNo);
		return BaseResponseGenerator.genSuccessResult(null);
	}

	/**
	 * 获取新手教程url
	 * 
	 * @param protype
	 * @return
	 */
	public BaseResponse getCourseUrl(String protype) {
		if (StringUtils.isNotEmpty(protype) && protype.length() > 2) {
			protype = protype.substring(0, 2);
		}
		// 原始车型找不到数据，使用默认的TS车型视频教程返回
		List<DeviceCourseUrl> list = deviceApi.getCourseUrl(protype);
		if (CollectionUtils.isEmpty(list)) {
			list = deviceApi.getCourseUrl(SOCOAppConstant.DEFAULT_CAR_MODEL_TYPE);
		}
		return BaseResponseGenerator.genSuccessResult(list);
	}
}
