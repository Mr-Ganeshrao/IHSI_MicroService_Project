package com.ihis.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CITIZEN_PLANS")
public class CitizenPlansEntity {
	
	
	@Id
	@GeneratedValue
	@Column(name = "CITIZEN_ID")
	private Integer citizenId;
	
	@Column(name="CASE_NUM")
	private Integer caseNum;
	
	@Column(name="PLAN_ID")
	private Integer planId;

	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	private LocalDate updateDdate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
}
