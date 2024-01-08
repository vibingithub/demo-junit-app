package com.ecsfin.demo.ut.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecsfin.demo.ut.entity.Employee;
import com.ecsfin.demo.ut.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> employees = employeeService.getEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
}
