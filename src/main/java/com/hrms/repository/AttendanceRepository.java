package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
