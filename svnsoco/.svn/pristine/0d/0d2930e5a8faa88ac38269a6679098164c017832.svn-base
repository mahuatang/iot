/**
 * Project Name:SOCO_Report
 * File Name:queryAreaRequest.java
 * Package Name:com.soco.car.report.api.request
 * Date:2018年6月25日下午2:23:54
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.api.request;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ClassName:queryAreaRequest <br/>
 * Reason: 根据各个区域开始统计. <br/>
 * Date: 2018年6月25日 下午2:23:54 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@ApiModel(value="查询区域对象详情")
public class QueryAreaRequest extends BaseRequest {

	private static final long serialVersionUID = -8800390951415519623L;
	/**
	 * 区域类型
	 */
	@ApiModelProperty(value="区域类型areaType=1(全世界),areaType=2(传入坐标某个国家全省),areaType=3(传入坐标某个省下全市),areaType=4(传入坐标某个市下全区)",required=true,example="1")
	private Integer areaType;
	/**
	 * 纬度
	 */
	@ApiModelProperty(value="纬度",required=true,example="31.236176")
	private Double latitude;
	/**
	 * 经度
	 */
	@ApiModelProperty(value="经度",required=true,example="121.471341")
	private Double longitude;
//	/**
//	 * 查询的距离
//	 */
//	@ApiModelProperty(value="查询的距离单位KM,非必传")
//	private Double distance;

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryAreaRequest [areaType=");
		builder.append(areaType);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append("]");
		return builder.toString();
	}

//	public Double getDistance() {
//		return distance;
//	}
//
//	public void setDistance(Double distance) {
//		this.distance = distance;
//	}


}
