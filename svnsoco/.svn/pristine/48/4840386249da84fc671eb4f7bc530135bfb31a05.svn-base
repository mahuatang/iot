package com.soco.car.app.api.response;

import com.soco.car.device.entity.Device;
import com.soco.car.user.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "返回用户和对应的绑定设备数据信息响应")
public class UserDeviceResponse<T> extends BaseResponse<T> {
    private static final long serialVersionUID = 9195277477027046860L;

    @ApiModelProperty(value = "返回的用户数据信息")
    private User user;

    @ApiModelProperty(value = "返回的绑定设备信息")
    private Device device;

    public UserDeviceResponse() {
        super();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "UserDeviceResponse{" +
                "user=" + user +
                ", device=" + device +
                '}';
    }

    public static <T> UserDeviceResponse<T> newInstance() {
        return new UserDeviceResponse<>();
    }
}
