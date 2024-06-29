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
@Table(name = "CITIZEN_GRADUATION_DTLS")
public class CitizenEduationDtlsEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "GRADUATION_ID")
	private Integer graduationId;
	
	@Column(name = "CASE_NUM")
	private Integer caseNum;
	
	@Column(name = "HIGHEST_DGREE")
	private String highestDgree;
	
	@Column(name = "GRADUATION_YEAR")
	private String graduationYear;
	
	@Column(name = "UNIVERSITY")
	private String uiniversity;
	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	private LocalDate updateDdate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
}
