
package com.soco.car.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ClassName:RedisConfig <br/>
 * Reason: redis配置中心.目前先不做集群模式，单点 <br/>
 * Date: 2018年7月9日 下午3:17:48 <br/>
 * 
 * @author sunlangping
 * @version
 * @see
 */
@Configuration
// @EnableRedisRepositories //激活 CURD接口
// @ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisConfig {

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

	// private List<String> nodes;

	/**
	 * Get initial collection of known cluster nodes in format {@code host:port}.
	 *
	 * @return
	 */
	// public List<String> getNodes() {
	// return nodes;
	// }
	//
	// public void setNodes(List<String> nodes) {
	// this.nodes = nodes;
	// }

	// @Bean
	// public RedisConnectionFactory connectionFactory() {
	// RedisClusterConfiguration config = new RedisClusterConfiguration(getNodes());
	// config.setPassword(RedisPassword.of("soco"));
	// JedisConnectionFactory jedisConnectionFactory = new
	// JedisConnectionFactory(config);
	// return jedisConnectionFactory;
	// }
}
