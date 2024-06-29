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
@Table(name = "APP_PALN_DTLS")
public class AppPlanEntity {
	
	@Id
	@GeneratedValue
	@Column(name="PLAN_ID")
	private Integer planId;
	
	@Column(name="PLANS_NAME")
	private String plansName;
	
	@Column(name="PLANS_START_DATE")
	private Date planStartDate;
	
	@Column(name="PLANS_END_DATE")
	private Date planEndDate;
	
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="ACTIVE_SW")
	private String activeStatus;
	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	private LocalDate updateDdate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	

}
