package com.ihis.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Profile {

	private Integer acctId;
	private String fullName;
	private String email;
	private Long mobileNum;
	private String gender;
	private Long zzn;
	private LocalDate dob;
	
}