package com.ecsfin.demo.ut.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecsfin.demo.ut.entity.Employee;

@SpringBootTest
@DisplayName("Employee Repo Test")
class EmployeeRepositoryTest {

	@Autowired
	EmployeeRepository employeeRepository;

	static List<Employee> employeeList = null;
	
	@BeforeAll
	public static void setup() {
		employeeList = new ArrayList<Employee>(
				Arrays.asList(
				 Employee.builder()
					.emailId("vibin@ecsfin.com")
					.firstName("Vibin")
					.lastName("Krishnan")
					.role("Technical Architect").build(),
				 Employee.builder()
					.emailId("sam@ecsfin.com")
					.firstName("Sam")
					.role("Senior Technical Architect").build(),
				 Employee.builder()
					.emailId("vineeth@ecsfin.com")
					.firstName("Vineeth")
					.role("Senior Technical Architect").build(),
				 Employee.builder()
					.emailId("vinod@ecsfin.com")
					.firstName("Vinod")
					.lastName("Raj")
					.role("Infra Lead").build(),
				 Employee.builder()
					.emailId("john@ecsfin.com")
					.firstName("John")
					.role("DBA").build()
				)); 
		
	}
	
	@Test
	@DisplayName("Add and Query")
	void addEmployee() {
		employeeList.stream()
				.forEach(e -> employeeRepository.save(e));
		
		List<Employee> list = employeeRepository.findAll();
		
		assertThat(list.size()).isGreaterThan(0);
	}

}
