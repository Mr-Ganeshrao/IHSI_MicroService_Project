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
@Table(name = "CITIZEN_INCOME_DTLS")
public class CitizenIncomeDtlsEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "INCOME_ID")
	private Integer incomeId;
	
	@Column(name = "CASE_NUM")
	private Integer caseNum;
	
	@Column(name = "SALARY_INCOME")
	private Double salaryIncome;
	
	@Column(name = "RENT_INCOME")
	private Double rentIncome;
	
	@Column(name = "PROPERTY_INCOME")
	private Double propertyIncome;
	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	private LocalDate updateDdate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;

}