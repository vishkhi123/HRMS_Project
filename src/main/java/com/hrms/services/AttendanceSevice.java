package com.hrms.services;

import java.util.List;

import com.hrms.entities.Attendance;

public interface AttendanceSevice {
	
	//create 
	Attendance createOrUpdate(Attendance attendance);
	
	//add Employee with attendance
	Attendance addEmpWithAttend(Long empId,Attendance attendance);
	
	//get By Id
	Attendance getById(Long attendId);
	
	//get All
	List<Attendance>  getAll();
}
