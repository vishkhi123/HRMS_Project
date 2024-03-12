package com.hrms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.entities.Employee;
import com.hrms.exceptions.ResourceNotFoundException;
import com.hrms.repository.EmployeeRepository;
import com.hrms.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public Employee register(Employee employee) {
		// TODO Auto-generated method stub
		Employee savedEmp=this.empRepository.save(employee);
		return savedEmp;
	}

	@Override
	public Employee updateEmp(Long empId, Employee emp) {
		// TODO Auto-generated method stub
		Employee updateEmp=this.empRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found By this ID"));
		updateEmp.setDepartment(emp.getDepartment());
		updateEmp.setDesignation(emp.getDesignation());
		updateEmp.setEmployeeStatus(emp.getEmployeeStatus());
		updateEmp.setJoiningDate(emp.getJoiningDate());
		updateEmp.setProfile(emp.getProfile());
		updateEmp.setRole(emp.getRole());
		updateEmp.setSalary(emp.getSalary());
		updateEmp.setWorkshift(emp.getWorkshift());
		Employee updatedEmp=this.empRepository.save(updateEmp);
		return updatedEmp;
	}

	@Override
	public void deleteEmp(Long empId) {
		// TODO Auto-generated method stub
		Employee Emp=this.empRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found By this ID"));
		this.empRepository.deleteById(empId);
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		List<Employee> emps=this.empRepository.findAll();
		return emps;
	}

	@Override
	public Employee getById(Long empId) {
		// TODO Auto-generated method stub
		Employee Emp=this.empRepository.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found By this ID"));
		
		return Emp;
	}

}
