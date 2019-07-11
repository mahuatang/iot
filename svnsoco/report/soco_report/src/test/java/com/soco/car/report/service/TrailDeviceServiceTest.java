/**
 * Project Name:SOCO_Report
 * File Name:TrailDeviceServiceTest.java
 * Package Name:com.soco.car.report.service
 * Date:2018年6月22日上午10:01:24
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.service;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.soco.car.report.api.domain.GeoDomain;
import com.soco.car.report.api.request.QueryAreaRequest;
import com.soco.car.report.api.request.QueryNearByRequest;
import com.soco.car.report.api.response.BaseResponse;
import com.soco.car.report.api.response.QueryAreaResponse;
import com.soco.car.report.base.BaseTest;
import com.soco.car.report.constants.SOCOReportConstant;
import com.soco.car.report.index.TrailDeviceIndex;
import com.soco.car.report.repository.TrailDeviceRepository;
import com.soco.car.report.utils.GeoUtil;

/**
 * ClassName:TrailDeviceServiceTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月22日 上午10:01:24 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
public class TrailDeviceServiceTest extends BaseTest {

	@Autowired
	private TrailDeviceService trailDeviceService;

	@Autowired
	private TrailDeviceRepository trailDeviceRepository;

	@Test
	public void testSearchAll() throws Exception {
		QueryNearByRequest queryNearByRequest = new QueryNearByRequest();
		List<GeoDomain> trailDeviceList = trailDeviceService.searchNearBy(queryNearByRequest);
		trailDeviceList.forEach(t -> {
			System.out.println(t);
		});
	}

	@Test
	public void testFindByPage() throws Exception {
		Integer pageNum = 1;
		Integer pageSize = 1000;
		for (int i = 0; i < pageSize; i++) {
			Page<TrailDeviceIndex> trailDeviceList = trailDeviceService.findByPage(pageNum, pageSize);
			for (TrailDeviceIndex t : trailDeviceList.getContent()) {
				// System.out.println(t);
			}
//			if (!trailDeviceList.hasNext()) {
//				break;
//			}
			System.out.println(
					trailDeviceList.hasNext() + "," + trailDeviceList.getSize() + "," + trailDeviceList.getNumber()
							+ "," + trailDeviceList.getNumberOfElements() + "," + trailDeviceList.getPageable());
			pageNum++;
			// System.out.println(trailDeviceList.getTotalElements());
			// System.out.println(trailDeviceList.getTotalPages());
		}
	}

	@Test
	public void testSearchAreaInfo() throws Exception {
		QueryAreaRequest queryAreaRequest = new QueryAreaRequest();
		// queryAreaRequest.setAreaType(SOCOReportConstant.AREA_COUNTRY);

		queryAreaRequest.setAreaType(SOCOReportConstant.AREA_COUNTRY);
		queryAreaRequest.setLatitude(31.227283);
		queryAreaRequest.setLongitude(121.489739);

		BaseResponse<QueryAreaResponse> reponse = trailDeviceService.searchAreaInfo(queryAreaRequest);
		System.out.println(reponse);

	}

	@Test
	public void testModifyTrailDeviceIndex() {
		Iterable<TrailDeviceIndex> iterable = trailDeviceRepository.findAll();
		Iterator<TrailDeviceIndex> iterator = iterable.iterator();
		int i = 0;
		int min = 0;
		int max = 10;
		while (iterator.hasNext()) {
			i++;
			TrailDeviceIndex trailDevice = iterator.next();
			if (i > min && i < max) {
				trailDevice.setCountry("中国");
				trailDevice.setDistrict("测试区");
			} else {
				trailDevice.setCountry("美国");
			}
			trailDeviceRepository.save(trailDevice);
		}
	}

	@Test
	public void testSearchNearBy() throws Exception {
		double latitude = 31.227283;
		double longitude = 121.489739;
		QueryNearByRequest queryNearByRequest = new QueryNearByRequest();
		queryNearByRequest.setLatitude(latitude);
		queryNearByRequest.setLongitude(longitude);
		queryNearByRequest.setDistance(5000000d);
		List<GeoDomain> list = trailDeviceService.searchNearBy(queryNearByRequest);
		list.forEach(l -> {
			System.out.println(l);
		});
	}

}
