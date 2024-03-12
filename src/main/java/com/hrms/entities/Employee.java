package com.hrms.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long employeeId;

	    @NotBlank(message = "Provide Profile !!")
	    private String profile;
	    
	    @NotBlank(message = "Provide Designation !!")
	    private String designation;

	    @NotBlank(message = "Provide Employee Status !!")
	//    @Pattern(regexp = "ACCEPTED|REJECTED")
	    private String employeeStatus;
	    
	    @NotBlank(message = "Provide Department !!")
	    private String department;
	    
	    @NotBlank(message = "Provide workshift !!")
	    private String workshift;
	    
	    @NotNull(message = "Provide Joining Date !!")
	    private LocalDate joiningDate;
	    
	    @Positive(message = "Provide Salary !!")
	    private double salary;
	    
	    @Enumerated(EnumType.STRING)
	    @NotNull
	    @Valid
	    private Role role;
	
}
