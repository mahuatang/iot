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
<<<<<<< .mine

		// 根据设备编号查询设备信息
		Device device = deviceApi.selectDeviceInfoByDeviceNo(deviceNo);
		if (device == null) {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.device_number_not_exist.getValue());
		}
		Long deviceId = device.getDeviceId();
		//检查设备是否有被其他用户绑定
		int flag = userbinddeviceApi.checkDeviceBindUser(deviceId);

		if (flag == 0) {
			Userbinddevice ubd = new Userbinddevice();
			ubd.setDeviceId(deviceId);
			ubd.setUserId(userId);
			ubd.setBindTime(new Date());
			ubd.setState("0");
			ubd.setImgUrls(device.getImgUrls());

			userbinddeviceApi.insertUserBindDevice(ubd);

			return BaseResponseGenerator.genSuccessResult(ResponseMessageEnum.device_bind_success.getValue());
		} else {
			return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
					ResponseMessageEnum.device_already_bind.getValue());
=======
		if (userbinddeviceApi.checkUserBindDevice(token.getUserId())) {
			return BaseResponseGenerator.genErrorResult(ResponseMessageEnum.user_already_bind_other_device.getValue());
>>>>>>> .r119
		}
		return BaseResponseGenerator.genSuccessResult(null);
	}

<<<<<<< .mine
	/**
	 * 用户解绑设备操作
	 * 
	 * @param deviceNo
	 * @param userId
	 * @return
	 */
	public BaseResponse userUnBindDevice(String deviceNo, Long userId) {
		Device deviceInfo = deviceApi.selectDeviceInfoByDeviceNo(deviceNo);
		if (deviceInfo != null) {
			Userbinddevice ubd = new Userbinddevice();
			ubd.setDeviceId(deviceInfo.getDeviceId());
			ubd.setUserId(userId);
			Userbinddevice ubdInfo = userbinddeviceApi.checkUserDeviceBind(ubd);
			if (ubdInfo != null) {
				if (ubdInfo.getState().equals("0")) {
					ubd.setBindId(ubdInfo.getBindId());
					ubd.setState("-1");
					ubd.setUnbindTime(new Date());
					int result = userbinddeviceApi.updateUserBindDevice(ubd);
					if (result > 0) {
						return BaseResponseGenerator.genSuccessResult(ResponseMessageEnum.device_un_bind_success);
					} else {
						return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
								ResponseMessageEnum.device_un_bind_fail.getValue());
					}
				} else {
					return BaseResponseGenerator.genErrorResult(SOCOAppConstant.ERROR_CODE_400,
							ResponseMessageEnum.device_un_bind_error.getValue());
				}
			}
=======
	public BaseResponse bindDevice(String deviceNo, TokenPOJO token) {
		Device device = deviceApi.findByDeviceNo(deviceNo);
		if (device == null) {
			return BaseResponseGenerator.genErrorResult(ResponseMessageEnum.device_no_error.getValue());
>>>>>>> .r119
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
