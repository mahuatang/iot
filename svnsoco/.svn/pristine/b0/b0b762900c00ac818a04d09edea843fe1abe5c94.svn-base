package com.soco.car.report.handler;

import com.soco.car.report.api.response.BaseResponse;
import com.soco.car.report.constants.SOCOReportConstant;

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
		result.setResultCode(resultCode);
		result.setMessage(message);
		result.setData(data);
		return result;
	}

	public static <T> BaseResponse<T> genSuccessResult(T data) {
		return genResult(SOCOReportConstant.ERROR_CODE_200, data, SOCOReportConstant.CODE_SUCESS);
	}

	public static <T> BaseResponse<T> genErrorResult() {
		return genResult(SOCOReportConstant.ERROR_CODE_400, null, SOCOReportConstant.CODE_INTERFACE_ERROR);
	}

	public static <T> BaseResponse<T> genErrorResult(String resultCode, String message) {
		return genResult(resultCode, null, message);
	}

}
