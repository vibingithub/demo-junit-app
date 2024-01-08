package com.ecsfin.demo.ut.service;

import java.util.List;

import com.ecsfin.demo.ut.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	
	public Employee getEmployeeByEmailId(String emailId);
	
	public Employee upsertEmployee(Employee employee);
	
}
