/**
 * Project Name:SOCO_Report
 * File Name:Test.java
 * Package Name:com.soco.car.report.mq.prod
 * Date:2018年6月21日下午4:07:00
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.report.mq.consume;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;
import com.hualinfor.soco.pojo.NETTY.DeviceRideRecordEntity;
import com.hualinfor.soco.pojo.mq.BaseMessage;
import com.hualinfor.soco.util.GsonUtils;
import com.soco.car.report.api.response.BaiduGeoReponse;
import com.soco.car.report.index.TrailDeviceIndex;
import com.soco.car.report.repository.TrailDeviceRepository;
import com.soco.car.report.service.BaiduMapService;

/**
 * 
 * ClassName: TrailDeviceConsumer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2018年6月22日 下午2:46:51 <br/>
 *
 * @author sunlangping
 * @version
 */
@Component
public class TrailDeviceConsumer {

	private static Logger logger = LoggerFactory.getLogger(TrailDeviceConsumer.class);

	@Autowired
	private TrailDeviceRepository trailDeviceRepository;

	@Autowired
	private BaiduMapService baiduMapService;

	/**
	 * 
	 * processMessage: 监听队列消息
	 *
	 * @author sunlangping
	 * @param content
	 *            消息内容
	 */
	@RabbitListener(queues = "queue-trail_device", concurrency = "10")
	public void processMessage(String content) {
		if (StringUtils.isEmpty(content)) {
			logger.warn("发送为空字符串！");
			return;
		}
		BaseMessage<DeviceRideRecordEntity> baseMessage = GsonUtils.fromJson(content,
				new TypeToken<BaseMessage<DeviceRideRecordEntity>>() {
				}.getType());
		if (logger.isDebugEnabled()) {
			logger.debug("转换对象{}", baseMessage);
		}
		DeviceRideRecordEntity entity = baseMessage.getBody();
		if (entity == null || StringUtils.isEmpty(entity.getDeviceNo())) {
			logger.warn("传入的参数有异常请检查{}", baseMessage);
			return;
		}
		saveTrailDeviceIndex(entity);
	}

	/**
	 * 
	 * saveTrailDeviceIndex: 将设备轨迹保存到索引中
	 *
	 * @author sunlangping
	 * @param entity
	 */
	private void saveTrailDeviceIndex(DeviceRideRecordEntity entity) {
		Optional<TrailDeviceIndex> optional = trailDeviceRepository.findById(entity.getDeviceNo());
		TrailDeviceIndex trailDevice = new TrailDeviceIndex();
		trailDevice.setTrailTime(entity.getCreateTime());
		trailDevice.setEndurance(entity.getEndurance());
		trailDevice.setIsStartup(entity.getStartup());
		if ((entity.getLatitude() == null || entity.getLongitude() == null)
				|| (entity.getLatitude() == 0d && entity.getLongitude() == 0d)) {
			logger.warn("经纬度数据不准确过滤掉！参数为{}", entity);
			return;
		}
		trailDevice.setGeo(new GeoPoint(entity.getLatitude(), entity.getLongitude()));
		trailDevice.setDeviceNo(entity.getDeviceNo());
		trailDevice.setLock(entity.getLock());
		// 如果存在索引创建时间与省市级区不做变化
		if (optional.isPresent()) {
			trailDevice.setCreateTime(optional.get().getCreateTime());
			trailDevice.setCountry(optional.get().getCountry());
			trailDevice.setProvince(optional.get().getProvince());
			trailDevice.setCity(optional.get().getCity());
			trailDevice.setDistrict(optional.get().getDistrict());
		} else {
			String geo = entity.getLatitude() + "," + entity.getLongitude();
			BaiduGeoReponse reponse = baiduMapService.getGeoInfo(geo);
			// 定时刷新位置信息
			if (null != reponse && null != reponse.getResult() && null != reponse.getResult().getAddressComponent()) {
				trailDevice.setCountry(reponse.getResult().getAddressComponent().getCountry());
				trailDevice.setProvince(reponse.getResult().getAddressComponent().getProvince());
				trailDevice.setCity(reponse.getResult().getAddressComponent().getCity());
				trailDevice.setDistrict(reponse.getResult().getAddressComponent().getDistrict());
			}
		}
		// 轨迹的在es中的更新时间
		trailDevice.setModifyTime(new Date());
		try {
			trailDeviceRepository.save(trailDevice);
		} catch (Exception e) {
			logger.error("保存异常trailDeviceRepository.save,参数为:{},错误描述:{}", trailDevice, e.getMessage());
		}
	}
}
