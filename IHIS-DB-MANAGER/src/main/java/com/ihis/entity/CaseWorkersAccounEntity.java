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
@Table(name = "CW_ACCOUNT_DTLS")
public class CaseWorkersAccounEntity {
	
	@Id
	@GeneratedValue
	@Column(name="AC_ID")
	private Integer acid;
	
	@Column(name="FULL_NAME")
	private String fullName;
	
	@Column(name = "EMAIL_ID")
	private String email;
	
	@Column(name = "PAZZWRD")
	private String pazzwrd;
	
	@Column(name = "MOB_NO")
	private Long mobno;
	
	@Column(name = "GENDER")
	private String Gender;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name="zzN")
	private Integer zzn;
	
	@Column(name="ACTIVE_SW")
	private String activestatus;
	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	private LocalDate updateDdate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	

	
	

}
