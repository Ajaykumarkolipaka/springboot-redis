package com.example.springbootredis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootredis.model.Employee;
import com.example.springbootredis.service.RedisService;

@RestController
@RequestMapping("/redis/emp")
public class RedisController {
	
	@Autowired
	private RedisService redisService;
	
	@GetMapping("/")
	public Map<Integer, Employee> getEmpDetailsFromRedis() {
		return redisService.getAllEmpFromRedis();
	}
	
	@PostMapping("/save")
	public void saveInRedis(@RequestBody Employee emp) {
		redisService.saveEmpDetailsInRedis(emp);
	}
}
