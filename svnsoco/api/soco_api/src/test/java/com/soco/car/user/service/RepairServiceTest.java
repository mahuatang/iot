package com.soco.car.user.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soco.car.base.BaseTest;

public class RepairServiceTest extends BaseTest {

	@Autowired
	private RepairstationService repairstationService;

	@Test
	public void testSelectNearByRepairstation() throws Exception {
		System.out.println(repairstationService.nearbyList(117.194, 34.274, 100, 1, 1000));
	}
}
