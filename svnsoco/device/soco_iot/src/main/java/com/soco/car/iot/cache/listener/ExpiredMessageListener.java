package com.soco.car.iot.cache.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import com.soco.car.bean.constants.CacheKeyEnum;

/**
 * ClassName:ExpiredMessageListener <br/>
 * Reason: 缓存过期监听器,用于处理各种维度数据处理<br/>
 * Date: 2018年8月10日 下午12:03:55 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Service
public class ExpiredMessageListener implements MessageListener {

	private final static Logger logger = LoggerFactory.getLogger(ExpiredMessageListener.class);

	@Override
	public void onMessage(Message message, byte[] pattern) {
		String key = new String(message.getBody());
	}

}
