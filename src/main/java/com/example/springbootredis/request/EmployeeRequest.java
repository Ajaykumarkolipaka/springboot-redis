package com.example.springbootredis.request;

import lombok.Data;

@Data
public class EmployeeRequest {
	private Integer empId;
	private String password;
}
