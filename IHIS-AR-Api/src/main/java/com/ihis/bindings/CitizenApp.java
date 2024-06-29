package com.ihis.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenApp {
	
	private String fullName;
	private String email;
	private String gender;
	private LocalDate dob;
	private Integer zzn;
	private String stateName;
	private Integer caseNum;

}
