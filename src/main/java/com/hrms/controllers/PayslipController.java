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

import com.hrms.entities.Payslip;
import com.hrms.exceptions.ApiResponseMessage;
import com.hrms.services.PayslipService;

@RestController
@RequestMapping("/payslip")
public class PayslipController {
	
	@Autowired
	private PayslipService payslipService;
	
	@PostMapping("/create")
	public ResponseEntity<Payslip> create(@RequestBody Payslip payslip)
	{
		return new ResponseEntity<Payslip>(this.payslipService.create(payslip), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Payslip> update(@PathVariable Long id,@RequestBody Payslip payslip)
	{
		return new ResponseEntity<Payslip>(this.payslipService.update(id, payslip), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Payslip>> getAll()
	{
		return new ResponseEntity<List<Payslip>>(this.payslipService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponseMessage> delete(@PathVariable Long id)
	{
		this.payslipService.delete(id);
		ApiResponseMessage api=new ApiResponseMessage("Deleted SuccessFully!!", true, HttpStatus.OK);		
		return new ResponseEntity<ApiResponseMessage>(api, HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Payslip> get(@PathVariable Long id)
	{	
		return new ResponseEntity<Payslip>(this.payslipService.getById(id), HttpStatus.OK);
	}

}
