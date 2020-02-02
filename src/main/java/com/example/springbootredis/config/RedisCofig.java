package com.example.springbootredis.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.springbootredis.model.Employee;

@Configuration
public class RedisCofig {

	@Bean
	public JedisConnectionFactory getJedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
//	@Bean(name = "CustomRedisConnection")
//	JedisConnectionFactory getCustomJedisConnectionFactory() {
//		RedisStandaloneConfiguration redisStandaloneConfig = new RedisStandaloneConfiguration("localhost", 6379);
//		redisStandaloneConfig.setPassword(RedisPassword.of("password"));
//		return new JedisConnectionFactory(redisStandaloneConfig);
//	}

	@Bean
	public RedisTemplate<String, Employee> getRedisTemplate() {
		RedisTemplate<String, Employee> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(getJedisConnectionFactory());
		return redisTemplate;
	}
	
	@Bean
	public RedisCacheConfiguration getRedisCacheConfig() {
		RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofSeconds(60))
				.disableCachingNullValues();
		return cacheConfig;
		
	}

}
