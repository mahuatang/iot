/**

 * Project Name:SOCO_Report
 * File Name:LocationDomain.java
 * Package Name:com.soco.car.report.api.domain
 * Date:2018年6月26日上午11:18:10
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.api.domain;
/**
 * ClassName:LocationDomain <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月26日 上午11:18:10 <br/>
 * @author   sunlangping
 * @version  
 * @see 	 
 */

import java.io.Serializable;

public class LocationDomain implements Serializable{

	private static final long serialVersionUID = 353280124348189489L;
	
	private Double lat;
	
	private Double lng;

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LocationDomain [lat=");
		builder.append(lat);
		builder.append(", lng=");
		builder.append(lng);
		builder.append("]");
		return builder.toString();
	}
	
	
}

