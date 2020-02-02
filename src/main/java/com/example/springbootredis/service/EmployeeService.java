package com.example.springbootredis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.example.springbootredis.model.Employee;
import com.example.springbootredis.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	@Cacheable(value = "empCache", key="#empId")
	public Employee getEmployeeDetails(Integer empId) {
		if(empRepository.findById(empId).isPresent())
			return empRepository.findById(empId).get();
		else {
			return new Employee();
		}
	}
	
	@Cacheable(value = "allEmpCache", unless = "#result.size() == 0")
	public List<Employee> getAllEmpDetails() {
		return empRepository.findAll();
	}
	
	@Caching(
			evict = {
					@CacheEvict(value = "empCache", key = "#empId"),
					@CacheEvict(value = "allEmpCache", allEntries = true)
					}
			)
	@CacheEvict(value = "allEmpCache", allEntries = true)
	public String deleteEmpDetails(Integer empId) {
		if(empRepository.findById(empId).isPresent()) {
			empRepository.deleteById(empId);
			return "Deleted Successfully...";
		} else {
			return "No data with given info";
		}
	}
	
	@Caching(
			put = { @CachePut(value = "empCache", key = "#emp.empId") },
			evict = { @CacheEvict(value = "allEmpCache", allEntries = true)}
			)
	public Employee saveEmp(Employee emp) {
		return empRepository.save(emp);
	}
	
	@Caching (
		put = { @CachePut(value = "empCache", key = "#empId") },
		evict = { @CacheEvict(value = "allEmpCache", allEntries = true)}
	)
	public Employee updateEmpDetails(Employee newEmp, Integer empId) {
		if(empRepository.findById(empId).isPresent()) {
			Employee emp = empRepository.findById(empId).get();
			emp.setName(newEmp.getName());
			emp.setPassword(newEmp.getPassword());
			emp.setUsername(newEmp.getUsername());
			return empRepository.save(emp);
		} else {
			return empRepository.save(newEmp);
		}
		
	}
}
