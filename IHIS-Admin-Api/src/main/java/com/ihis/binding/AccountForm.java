package com.ihis.binding;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class AccountForm {

	private Integer ac_id;
	
	private String full_Name;

	private String email_id;

	private Long mob_no;

	private Character Gender;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dob;

	private Integer ssn;

}
