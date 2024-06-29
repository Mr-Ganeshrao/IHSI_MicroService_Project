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
@Table(name = "CITIZEN_APP_DTLS")
public class CitizenAppEntity {
	
	
	@Id
	@GeneratedValue
	@Column(name = "citizen_id")
	private Integer ctitizenId;
	
	@Column(name = "CASE_NUM")
	private Integer caseNum;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "EMAIL_ID")
	private String email;
	
	@Column(name = "MOB_NUM")
	private long mobno;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "zzN")
	private Integer zzn;
	
	@Column(name = "ACTIVE_SW")
	private Character activeStatus;
	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	private LocalDate updateDdate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	

}
