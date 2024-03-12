package com.hrms.services;

import java.util.List;

import com.hrms.entities.Employee;

public interface EmployeeService {
	
	//create
	Employee register(Employee employee);
	
	//update
	Employee updateEmp(Long empId,Employee emp);
	
	//Delete
	void deleteEmp(Long empId);
	
	//getAll
	List<Employee> getAll();
	
	//getById
	Employee getById(Long empId);

}
