/**
 * Project Name:SOCO_IOT
 * File Name:RedisConfig.java
 * Package Name:com.soco.car.iot.config
 * Date:2018年7月9日下午3:17:48
 * Copyright (c) 2018, sunlangping8888@163.com All Rights Reserved
 *
*/

package com.soco.car.iot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soco.car.iot.cache.listener.ExpiredMessageListener;

/**
 * ClassName:RedisConfig <br/>
 * Reason: redis配置中心. <br/>
 * Date: 2018年7月9日 下午3:17:48 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Configuration
@EnableRedisRepositories
public class RedisConfig {
	
	@Autowired
	private ExpiredMessageListener expiredMessageListener;

	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);

		// 使用Jackson2JsonRedisSerialize 替换默认序列化
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		// 将为空的垃圾数据过滤。
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

		// 设置value的序列化规则和 key的序列化规则
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());

		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean
	public RedisMessageListenerContainer keyExpirationListenerContainer(RedisConnectionFactory connectionFactory) {

		RedisMessageListenerContainer listenerContainer = new RedisMessageListenerContainer();
		listenerContainer.setConnectionFactory(connectionFactory);

//		listenerContainer.addMessageListener((message, pattern) -> {
//		}, new PatternTopic("__keyevent@*__:expired"));
		listenerContainer.addMessageListener(expiredMessageListener, new PatternTopic("__keyevent@*__:expired"));
		return listenerContainer;
	}

}
