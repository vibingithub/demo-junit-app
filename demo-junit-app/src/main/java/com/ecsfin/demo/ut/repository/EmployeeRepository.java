package com.ecsfin.demo.ut.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecsfin.demo.ut.entity.Employee;
import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	Employee findByEmailId(String emailId);
	
	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Employee> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);
	
	List<Employee> findByRole(String role);

}
