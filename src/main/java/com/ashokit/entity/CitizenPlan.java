package com.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Citizen_plan_info")
public class CitizenPlan {
	
	@Id
	@GeneratedValue
	private Integer citizeid;
	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Double benefitAmt;
	private LocalDate terminatedDate;
	private String denialReason;
	private String terminationRsn;

	

}
