package com.soco.car.user.service;

import com.soco.car.base.BaseTest;
import com.soco.car.car.service.ConfigService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfigServiceTest extends BaseTest {
    @Autowired
    private ConfigService configService;

    @Autowired
    private ProblemAnalysisService problemAnalysisService;

    @Test
    public void testSelectAboutConfigInfo() {
        System.out.println("????  " + configService.selectAboutConfigInfo());
    }

    @Test
    public void testSelectKefuConfigInfo() {
        System.out.println("*******   " + configService.selectKefuConfigInfo());
    }

    @Test
    public void testSelectThirdUrlMoneyConfigInfo() {
        System.out.println(")))))) " + configService.selectThirdUrlMoneyConfigInfo());
    }

    @Test
    public void testListAllProblem() {
        System.out.println(")))))) " + problemAnalysisService.listAllProblem());
    }

    @Test
    public void testSelectVersionInfo() {
        System.out.println("&&&& " + configService.selectVersionInfo(4l));
    }

    @Test
    public void testSelectFirmwareVersionInfo() {
        System.out.println("))))) " + configService.selectFirmwareVersionInfo(1));
    }
}
