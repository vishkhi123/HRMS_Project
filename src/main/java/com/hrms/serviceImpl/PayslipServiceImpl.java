package com.hrms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.entities.Payslip;
import com.hrms.exceptions.ResourceNotFoundException;
import com.hrms.repository.PayslipRepository;
import com.hrms.services.PayslipService;

@Service
public class PayslipServiceImpl implements PayslipService  {
	
	@Autowired
	private PayslipRepository payslipRepository;

	@Override
	public Payslip create(Payslip payslip) {
		// TODO Auto-generated method stub
		payslip.setSalary(payslip.getNetSalary()+payslip.getAllowances()-payslip.getDeductions());
		return payslipRepository.save(payslip);
	}

	@Override
	public Payslip update(Long id, Payslip payslip) {
		// TODO Auto-generated method stub
		Payslip saved=this.payslipRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PaySlip Not found by this Id!!!") );
		saved.setAllowances(payslip.getAllowances());
		saved.setDeductions(payslip.getDeductions());
		saved.setMonth(payslip.getMonth());
		saved.setNetSalary(payslip.getNetSalary());
		saved.setPayDate(payslip.getPayDate());
		saved.setPayrun(payslip.getPayrun());
		saved.setPayrunPeriod(payslip.getPayrunPeriod());
		saved.setPayrunType(payslip.getPayrunType());
		saved.setProfile(payslip.getProfile());
		saved.setSalary(payslip.getNetSalary()+payslip.getAllowances()-payslip.getDeductions());
		saved.setStatus(payslip.getStatus());
		
		return this.payslipRepository.save(saved);
	}

	@Override
	public List<Payslip> getAll() {
		// TODO Auto-generated method stub
		return this.payslipRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Payslip saved=this.payslipRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PaySlip Not found by this Id!!!") );
		this.payslipRepository.delete(saved);
		
	}

	@Override
	public Payslip getById(Long id) {
		// TODO Auto-generated method stub
		Payslip saved=this.payslipRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PaySlip Not found by this Id!!!") );
		
		return saved;
	}

}
