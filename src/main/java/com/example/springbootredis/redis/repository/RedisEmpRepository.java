package com.example.springbootredis.redis.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.springbootredis.model.Employee;

@Repository
public class RedisEmpRepository {
	
	private RedisTemplate<String, Employee> redisTemplate;
	private HashOperations<String, Integer, Employee> hashOperations;
	
	public RedisEmpRepository(RedisTemplate<String, Employee> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = this.redisTemplate.opsForHash();
	}
	
	public void saveInRedis(String key, Employee emp) {
		hashOperations.put(key, emp.getEmpId(), emp);
	}
	
	public Map<Integer, Employee> getAllFromRedis(String key) {
		return hashOperations.entries(key);
	}
	
	public void updateInRedis(String key, Integer hashKey, Employee value) {
		hashOperations.put(key, hashKey, value);
	}
}
