package com.ecsfin.demo.ut.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ecsfin.demo.ut.entity.Employee;
import com.ecsfin.demo.ut.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerMockTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	EmployeeService employeeService;
	
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
	void getEmployees() throws Exception {
		when(employeeService.getEmployees()).thenReturn(employeeList);
		
		mockMvc.perform(get("/api/employee"))
			.andDo(print())
			.andExpect(status().isOk());
	}

}
