/**
 * Project Name:soco_api
 * File Name:DeviceBindExt.java
 * Package Name:com.soco.car.device.entity.ext
 * Date:2018年8月15日下午9:17:03
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.device.entity.ext;

import java.util.Date;

import com.soco.car.device.entity.Device;

/**
 * ClassName:DeviceBindExt <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年8月15日 下午9:17:03 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class DeviceBindExt extends Device {

	private static final long serialVersionUID = -8922102546507546668L;
	
	/**
	 * 绑定状态 0 绑定,-1 解绑,1绑定并选中中
	 */
	private Integer state;
	/**
	 * 绑定时间
	 */
	private Date bindTime;
	/**
	 * 解绑时间
	 */
	private Date unbindTime;
	/**
	 * 车型名称
	 */
	private String carModelName;
	/**
	 * 颜色代码
	 */
	private String colorCode;
	/**
	 * 图片路径
	 */
	private String imgUrl;
	

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getBindTime() {
		return bindTime;
	}

	public void setBindTime(Date bindTime) {
		this.bindTime = bindTime;
	}

	public Date getUnbindTime() {
		return unbindTime;
	}

	public void setUnbindTime(Date unbindTime) {
		this.unbindTime = unbindTime;
	}

	public String getCarModelName() {
		return carModelName;
	}

	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeviceBindExt [");
		if (state != null) {
			builder.append("state=");
			builder.append(state);
			builder.append(", ");
		}
		if (bindTime != null) {
			builder.append("bindTime=");
			builder.append(bindTime);
			builder.append(", ");
		}
		if (unbindTime != null) {
			builder.append("unbindTime=");
			builder.append(unbindTime);
			builder.append(", ");
		}
		if (carModelName != null) {
			builder.append("carModelName=");
			builder.append(carModelName);
			builder.append(", ");
		}
		if (colorCode != null) {
			builder.append("colorCode=");
			builder.append(colorCode);
			builder.append(", ");
		}
		if (imgUrl != null) {
			builder.append("imgUrl=");
			builder.append(imgUrl);
			builder.append(", ");
		}
		if (super.toString() != null) {
			builder.append("toString()=");
			builder.append(super.toString());
		}
		builder.append("]");
		return builder.toString();
	}

}
