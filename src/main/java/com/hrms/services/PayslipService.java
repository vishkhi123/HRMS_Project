package com.hrms.services;

import java.util.List;

import com.hrms.entities.Payslip;

public interface PayslipService {
	
	Payslip create(Payslip payslip);
	
	Payslip update(Long id,Payslip payslip);
	
	List<Payslip> getAll();
	
	void delete(Long id);
	
	Payslip getById(Long id);
	

}
