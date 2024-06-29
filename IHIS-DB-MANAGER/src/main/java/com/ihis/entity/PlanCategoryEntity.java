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
@Table(name = "PLAN_CATEGORY_DTLS")
public class PlanCategoryEntity {
	
	
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name = "CATEGORY_NAME")
	private String categotyName;
	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	private LocalDate updateDdate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;

}
