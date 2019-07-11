/**
 * Project Name:SOCO_Report
 * File Name:CityRepository.java
 * Package Name:com.soco.car.report.repository
 * Date:2018年6月21日下午2:39:00
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.soco.car.report.index.TrailDeviceIndex;

/**
 * ClassName:CityRepository <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月21日 下午2:39:00 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public interface TrailDeviceRepository extends ElasticsearchRepository<TrailDeviceIndex, String> {

}
