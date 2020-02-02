package com.example.springbootredis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootredis.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}