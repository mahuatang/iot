/**
 * Project Name:SOCO_API
 * File Name:BaseTest.java
 * Package Name:com.soco.car.car.base
 * Date:2018年6月12日下午5:37:43
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.app.base;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.soco.car.app.SoCoAppTestApplicatoin;

/**
 * ClassName:BaseTest <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年6月12日 下午5:37:43 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SoCoAppTestApplicatoin.class)
@WebAppConfiguration
public class BaseTest {

}
