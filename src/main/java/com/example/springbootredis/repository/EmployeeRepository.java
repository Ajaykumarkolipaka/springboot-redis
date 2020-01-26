package com.example.springbootredis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootredis.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	Optional<Employee> findById(Integer empId);
	List<Employee> findAll();
	void deleteById(Integer empId);
}
