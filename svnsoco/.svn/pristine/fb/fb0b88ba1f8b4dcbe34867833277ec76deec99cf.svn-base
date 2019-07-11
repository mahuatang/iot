/**
 * Project Name:SOCO_Report
 * File Name:queryAreaResponse.java
 * Package Name:com.soco.car.report.api.response
 * Date:2018年6月25日下午2:31:13
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.api.response;
/**
 * ClassName:queryAreaResponse <br/>
 * Reason:	 查询返回的类型 <br/>
 * Date:     2018年6月25日 下午2:31:13 <br/>
 * @author   sunlangping
 * @version  
 * @see 	 
 */

import java.util.List;

import com.soco.car.report.api.domain.AreaInfoDomain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "经纬度详情对象")
public class QueryAreaResponse {
	/**
	 * 返回的类型
	 */
	@ApiModelProperty(value = "区域类型")
	private Integer areaType;
	@ApiModelProperty(value = "区域详情列表")
	List<AreaInfoDomain> areaInfoList;
	@ApiModelProperty(value = "车俩总数")
	private Integer total;

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}

	public List<AreaInfoDomain> getAreaInfoList() {
		return areaInfoList;
	}

	public void setAreaInfoList(List<AreaInfoDomain> areaInfoList) {
		this.areaInfoList = areaInfoList;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryAreaResponse [areaType=");
		builder.append(areaType);
		builder.append(", areaInfoList=");
		builder.append(areaInfoList);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}
	
}

