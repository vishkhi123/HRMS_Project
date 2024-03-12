package com.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entities.Employee;
import com.hrms.exceptions.ApiResponseMessage;
import com.hrms.services.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	//register
	@PostMapping("/register")
	public ResponseEntity<Employee> register(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(this.empService.register(employee), HttpStatus.ACCEPTED);
	}
	
	//update
	@PutMapping("/update/{empId}")
	public ResponseEntity<Employee> update(@PathVariable Long empId,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(this.empService.updateEmp(empId, employee),HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ApiResponseMessage> delete(@PathVariable Long empId)
	{   this.empService.deleteEmp(empId);
		ApiResponseMessage api=new ApiResponseMessage("Deleted Successfully !!", true, HttpStatus.OK);
		return new ResponseEntity<ApiResponseMessage>(api, HttpStatus.OK);
	}
	
	//getAll
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAll()
	{
		
		return new ResponseEntity<List<Employee>>(this.empService.getAll(), HttpStatus.OK);
	}
	
	//getById
	@GetMapping("/getById/{empId}")
	public ResponseEntity<Employee> getById(@PathVariable Long empId)
	{
		return new ResponseEntity<Employee>(this.empService.getById(empId), HttpStatus.OK);
	}
	
}
