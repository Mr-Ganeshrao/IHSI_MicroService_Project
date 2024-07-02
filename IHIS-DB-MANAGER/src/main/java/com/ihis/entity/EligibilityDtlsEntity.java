package com.ihis.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ELIG_DTLS")
public class EligibilityDtlsEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "ELIG_ID")
	private Integer eligid;
	
	@Column(name = "CASE_NUM")
	private Integer caseNum;
	
	@Column(name = "PLAN_NAME")
	private String planname;
	
	@Column(name= "PLAN_STATUS")
	private String planstatus;
	
	@Column(name = "START_DATE")
	private Date startdate;
	
	@Column(name = "ENDDATE")
	private Date end_date;
	
	@Column(name = "BENEFIT_AMT")
	private Integer benefitamt;
	
	@Column(name = "DENIAL_REASON")
	private String denialreason;
	
	@Column(name="CREATED_DATE")
	private LocalDate createddate;
	
	@Column(name="UPDATED_DATE")
	private LocalDate updateddate;
	
	@Column(name="CREATED_BY")
	private String Createdby;
	
	@Column(name="UPDATED_BY")
	private String updatedby;

}
