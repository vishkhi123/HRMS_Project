package com.hrms.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payslip {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String profile; // could be Rida Rihana (BD)
   
    private String payrun; // could be E2HZP3
    
    private String payrunPeriod; // could be 1-30 Apr
   
    private String payrunType; // could be default
   
    private String status; // could be E2HZP3
    
    private Double salary; // could be 10000.00
    
    private Double netSalary; // could be 14000.00
    
    private LocalDate payDate; // could be 2022-05-01
    
    private Integer month; // 1-12
    
    private Double allowances; // could be 5000.00
    
    private Double deductions; // could be 1000.00

  
    

}
