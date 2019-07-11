/**
 * Project Name:soco_app
 * File Name:BaseResponseTest.java
 * Package Name:com.soco.car.app.api.response
 * Date:2018年8月14日上午11:14:51
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.api.response;

import org.junit.Test;

import com.google.common.reflect.TypeToken;
import com.soco.car.app.utils.GsonUtil;

/**
 * ClassName:BaseResponseTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年8月14日 上午11:14:51 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class BaseResponseTest {

	@Test
	public void testBeanToJson() {

		String json = "	{"
				+ "			  \"status\": \"200\", "
				+ "			  \"message\": \"处理成功\","
				+ "			  \"data\": { "
				+ "			    \"token\": \"Bearer eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1MzQ4MjE0MzMsImFjY291bnQiOiI4Nl8xNzYwMjEwOTQ2OCJ9.3zn7us3ODjwi750CXm4eF_PtA11IoXhnIlGggWAVpK-wtwMR_eo-OAdpRhVkyTvm1Ibi-u_68EtXvhbJ-9_1uw\"  "
				+ "			  } "
				+ "		}    ";
		System.out.println(json);
		BaseResponse<UserLoginIntoResponse> response = GsonUtil.fromJson(json, new TypeToken<BaseResponse<UserLoginIntoResponse>>() {
		}.getType());
		System.out.println(response);

		// BaseResponse<UserLoginIntoResponse> response = new BaseResponse<>();
		// response.setStatus("403");
		// response.setMessage("123123123");

	}
}
