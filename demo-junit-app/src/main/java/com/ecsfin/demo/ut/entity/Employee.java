package com.ecsfin.demo.ut.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@SequenceGenerator(name = "employeeSequence",
			sequenceName = "employeeSequence",
			initialValue = 1000,
			allocationSize = 1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "employeeSequence"
			)
	private Long employeeId;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	private String lastName;
	private String role;
	
	@Column(name = "email_id", nullable = false)
	private String emailId;
}
