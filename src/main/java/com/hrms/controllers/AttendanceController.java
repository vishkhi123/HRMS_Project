package com.hrms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entities.Attendance;
import com.hrms.services.AttendanceSevice;

@RestController
@RequestMapping("/attend")
public class AttendanceController {
	
	@Autowired
	private AttendanceSevice attendanceSevice;
	
	
	@PostMapping("/create")
	public ResponseEntity<Attendance> create(@RequestBody Attendance attendance )
	{
		return new ResponseEntity<Attendance>(this.attendanceSevice.createOrUpdate(attendance), HttpStatus.OK);
	}
	
	//add Emp with Attendance
	@PostMapping("/addEmp/{empId}")
	public ResponseEntity<Attendance> addEmpWithAttend(@PathVariable Long empId,@RequestBody Attendance attendance)
	{
		return new ResponseEntity<Attendance>(this.attendanceSevice.addEmpWithAttend(empId, attendance), HttpStatus.OK);
		
	}
	
	//getAll
	@GetMapping("/getAll")
	public ResponseEntity<List<Attendance>> getAll()
	{
		return new ResponseEntity<List<Attendance>>(this.attendanceSevice.getAll(), HttpStatus.OK);
	}
	
	//getById
	public ResponseEntity<Attendance> getById(@PathVariable Long attendId)
	{
		return new ResponseEntity<Attendance>(this.attendanceSevice.getById(attendId), HttpStatus.OK);
	}
	
	
	
	
	
	
	

}
