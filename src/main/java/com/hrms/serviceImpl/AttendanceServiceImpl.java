package com.hrms.serviceImpl;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.entities.Attendance;
import com.hrms.entities.Employee;
import com.hrms.exceptions.ResourceNotFoundException;
import com.hrms.repository.AttendanceRepository;
import com.hrms.repository.EmployeeRepository;
import com.hrms.services.AttendanceSevice;

@Service
public class AttendanceServiceImpl implements AttendanceSevice {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public Attendance createOrUpdate(Attendance attendance) {
		// TODO Auto-generated method stub
		 this.calculateBehaviour(attendance);
		Attendance saved=this.attendanceRepository.save(attendance);
		
		return saved;
	}
	
	 private void calculateBehaviour(Attendance attendance) {
	        if (attendance.getPunchIn() == null || attendance.getPunchOut() == null) {
	            attendance.setBehaviour(null);
	            attendance.setPresent("ABSENT");
	            return;
	        }

	        long punchInToInTimeMinutes = Duration.between(attendance.getPunchIn(), attendance.getInTime()).toMinutes();
	        long punchOutToOutTimeMinutes = Duration.between(attendance.getOutTime(), attendance.getPunchOut()).toMinutes();

	        if (punchInToInTimeMinutes > 60 || punchOutToOutTimeMinutes > 60) {
	            attendance.setBehaviour("Early");
	            attendance.setPresent("PRESENT");
	        } else if (punchInToInTimeMinutes >= 5 || punchOutToOutTimeMinutes >= 5) {
	            attendance.setBehaviour("Regular");
	            attendance.setPresent("PRESENT");
	        } else {
	            attendance.setBehaviour("Late");
	            attendance.setPresent("PRESENT");
	        }
	    }
	
	

	@Override
	public Attendance addEmpWithAttend(Long empId, Attendance attendance) {
		// TODO Auto-generated method stub
		Employee emp=this.empRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee  Not Found By This Id !!"));
		attendance.setEmployee(emp);
		this.calculateBehaviour(attendance);
		Attendance saved=this.attendanceRepository.save(attendance);
		
		return saved;
	}

	@Override
	public Attendance getById(Long attendId) {
		// TODO Auto-generated method stub
		Attendance attend=this.attendanceRepository.findById(attendId).orElseThrow(()-> new ResourceNotFoundException("Attendance Id Not Found  !!"));
		return attend;
	}

	@Override
	public List<Attendance> getAll() {
		// TODO Auto-generated method stub
		List<Attendance> attendances=this.attendanceRepository.findAll();
		return attendances;
	}

}
