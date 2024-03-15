package com.hrms.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="attendances")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attendanceId;
	
	private LocalDate date;
	
	private LocalTime inTime;
	
	private LocalTime outTime;
	
	private LocalTime punchIn;
	
	private LocalTime punchOut;
	
	private String behaviour;
	
	private String present;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;
	

}
