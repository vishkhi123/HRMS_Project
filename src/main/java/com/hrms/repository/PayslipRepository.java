package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.Payslip;

public interface PayslipRepository extends JpaRepository<Payslip, Long> {

}
