/**
 * Project Name:SOCO_Report
 * File Name:BaseRequest.java
 * Package Name:com.soco.car.report.api.request
 * Date:2018年6月22日下午2:52:13
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.api.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * ClassName:BaseRequest <br/>
 * Reason: 基础请求类 <br/>
 * Date: 2018年6月22日 下午2:52:13 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class BaseRequest implements Serializable {

	private static final long serialVersionUID = -745123377340456214L;
	
	@ApiModelProperty(value = "第×页", required = false, example = "1")
	private Integer pageNum = 1;
	@ApiModelProperty(value = "每页×××条，默认每页显示10条", required = false, example = "10")
	private Integer pageSize = 10;
	
	//private String token;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BaseRequest [pageNum=");
		builder.append(pageNum);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append("]");
		return builder.toString();
	}

}
