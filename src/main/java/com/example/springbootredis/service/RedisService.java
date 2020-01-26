package com.example.springbootredis.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootredis.model.Employee;
import com.example.springbootredis.redis.repository.RedisEmpRepository;

@Service
public class RedisService {

	@Autowired
	private RedisEmpRepository redisEmpRepository;
	
	public Map<Integer, Employee> getAllEmpFromRedis() {
		return redisEmpRepository.getAllFromRedis("EMP");
	}

	public void saveEmpDetailsInRedis(Employee emp) {
		redisEmpRepository.saveInRedis("EMP", emp);
	}

}
