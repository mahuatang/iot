package com.soco.car.app.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "附近位置信息")
public class NearByLocationRequest extends BaseRequest {

	private static final long serialVersionUID = -3296833432869967558L;
	
	@ApiModelProperty(value = "经度信息", required = true, example = "117.194")
	private Double currLng;
	@ApiModelProperty(value = "纬度信息", required = true, example = "34.274")
	private Double currLat;
	@ApiModelProperty(value = "距离信息", required = false, example = "100")
	private Integer distance;

	public Double getCurrLng() {
		return currLng;
	}

	public void setCurrLng(Double currLng) {
		this.currLng = currLng;
	}

	public Double getCurrLat() {
		return currLat;
	}

	public void setCurrLat(Double currLat) {
		this.currLat = currLat;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "NearByLocationRequest{" + "currLng=" + currLng + ", currLat=" + currLat + ", distance=" + distance
				+ '}';
	}
}
