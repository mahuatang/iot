/**
 * Project Name:SOCO_APP
 * File Name:DeviceController.java
 * Package Name:com.soco.car.app.controller
 * Date:2018年7月25日下午4:30:02
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.soco.car.app.service.UserService;
import com.soco.car.device.api.DeviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:DeviceController <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年7月25日 下午4:30:02 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@RestController(value = "/rest/v1/device")
public class DeviceController extends BaseController {

    @Reference
    private DeviceApi deviceApi;


}
