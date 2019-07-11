package com.soco.car.app.handler;

import com.soco.car.app.api.response.UserDeviceResponse;
import com.soco.car.device.entity.Device;
import com.soco.car.user.entity.User;
import org.springframework.util.StringUtils;

import com.soco.car.app.api.response.BaseResponse;
import com.soco.car.app.constants.ResponseMessageEnum;
import com.soco.car.app.constants.SOCOAppConstant;

/**
 * 
 * ClassName: BaseResponseGenerator <br/>
 * Function: 通用返回对象类型. <br/>
 * date: 2018年6月25日 下午2:35:15 <br/>
 *
 * @author sunlangping
 * @version
 */
public class BaseResponseGenerator {

	public static <T> BaseResponse<T> genResult(String resultCode, T data, String message) {
		BaseResponse<T> result = BaseResponse.newInstance();
		result.setStatus(resultCode);
		result.setMessage(message);
		result.setData(data);
		return result;
	}

	public static <T> BaseResponse<T> genSuccessResult(T data, String messageCode) {
		return genResult(SOCOAppConstant.ERROR_CODE_200, data, messageCode);
	}

	public static <T> BaseResponse<T> genSuccessResult(T data) {
		return genResult(SOCOAppConstant.ERROR_CODE_200, data, ResponseMessageEnum.success.getValue());
	}

	public static <T> BaseResponse<T> genErrorResult(String messageCode) {
		return genResult(SOCOAppConstant.ERROR_CODE_400, null, messageCode);
	}

	public static <T> BaseResponse<T> genErrorResult(String resultCode, String messageCode) {
		return genResult(resultCode, null, messageCode);
	}

	public static <T> BaseResponse<T> genErrorAuthResult(String messageCode) {
		return genResult(SOCOAppConstant.ERROR_CODE_403, null, messageCode);
	}
}
