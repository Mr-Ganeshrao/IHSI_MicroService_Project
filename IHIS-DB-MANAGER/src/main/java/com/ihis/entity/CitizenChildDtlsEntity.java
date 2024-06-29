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
@Table(name = "CITIZEN_CHILD_DTLS")
public class CitizenChildDtlsEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "CHILD_ID")
	private Integer childId;
	
	@Column(name = "CASE_NUM")
	private Integer caseNum;
	
	@Column(name = "CHILD_NAME")
	private	 String childName;
	
	@Column(name = "CHILD_DOB")
	private Date childDob;
	
	@Column(name = "CHIld_ZZN")
	private Integer childzzn;
	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	private LocalDate updateDdate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	

}
