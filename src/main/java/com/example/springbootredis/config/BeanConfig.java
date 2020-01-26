package com.example.springbootredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.springbootredis.model.Employee;

@Configuration
public class BeanConfig {

	@Bean
	JedisConnectionFactory getJedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
//	@Bean(name = "CustomRedisConnection")
//	JedisConnectionFactory getCustomJedisConnectionFactory() {
//		RedisStandaloneConfiguration redisStandaloneConfig = new RedisStandaloneConfiguration("localhost", 6379);
//		redisStandaloneConfig.setPassword(RedisPassword.of("password"));
//		return new JedisConnectionFactory(redisStandaloneConfig);
//	}

	@Bean
	RedisTemplate<String, Employee> getRedisTemplate() {
		RedisTemplate<String, Employee> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(getJedisConnectionFactory());
		return redisTemplate;
	}

}
