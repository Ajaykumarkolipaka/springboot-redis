package com.example.springbootredis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootredis.model.Employee;
import com.example.springbootredis.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	public Optional<Employee> getEmployeeDetails(Integer empId) {
		Optional<Employee> empDetails = empRepository.findById(empId);
		if(empDetails != null) {
			return empDetails;
		}
		return null;
	}
	
	public List<Employee> getAllEmpDetails() {
		return empRepository.findAll();
	}
	
	public void deleteEmpDetails(Integer empId) {
		empRepository.deleteById(empId);
		
	}

	public void saveEmp(Employee emp) {
		empRepository.save(emp);
	}
}
