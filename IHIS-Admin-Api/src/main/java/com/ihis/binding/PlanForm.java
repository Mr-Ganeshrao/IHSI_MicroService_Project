package com.ihis.binding;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PlanForm {

	private String plans_name;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate plan_start_date;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate plan_end_date;

	private Integer category_id;

	private String active_status;

}