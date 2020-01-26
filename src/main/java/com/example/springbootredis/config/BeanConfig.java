package com.example.springbootredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.springbootredis.model.Employee;

@Configuration
public class BeanConfig {

	@Bean
	JedisConnectionFactory getJedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, Employee> getRedisTemplate() {
		RedisTemplate<String, Employee> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(getJedisConnectionFactory());
		return redisTemplate;
	}

}
