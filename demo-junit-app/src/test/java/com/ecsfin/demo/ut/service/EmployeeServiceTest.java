package com.ecsfin.demo.ut.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecsfin.demo.ut.entity.Employee;

@SpringBootTest
@DisplayName("Employee Service Test")
class EmployeeServiceTest {

	@Autowired
	EmployeeService employeeService;
	
	@Test
	void getAll() {
		List<Employee> employees = employeeService.getEmployees();
		assertThat(employees.size()).isGreaterThan(0);
	}

}
