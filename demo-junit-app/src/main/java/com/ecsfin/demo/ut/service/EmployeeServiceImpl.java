package com.ecsfin.demo.ut.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecsfin.demo.ut.entity.Employee;
import com.ecsfin.demo.ut.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeByEmailId(String emailId) {
		return employeeRepository.findByEmailId(emailId);
	}

	@Override
	public Employee upsertEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}

}
