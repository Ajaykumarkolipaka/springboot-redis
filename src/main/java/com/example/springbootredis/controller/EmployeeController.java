package com.example.springbootredis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootredis.model.Employee;
import com.example.springbootredis.service.EmployeeService;

@RestController
@RequestMapping("/user")
public class EmployeeController {
	
	@Autowired
	private EmployeeService loginService;
	
	@GetMapping("/emp")
	public Optional<Employee> getEmpDetailsById(@RequestParam("empId") Integer empId) {
		return loginService.getEmployeeDetails(empId);
	}
	
	@GetMapping("/emp/")
	public List<Employee> getEmpDetails() {
		return loginService.getAllEmpDetails();
	}
	
	@DeleteMapping("/delete/{empId}")
	public void deleteByEmpId(@RequestParam Integer empId) {
		loginService.deleteEmpDetails(empId);
	}
	
	@PostMapping("/save")
	public void saveEmpDetails(@RequestBody Employee emp) {
		loginService.saveEmp(emp);
	}
}
