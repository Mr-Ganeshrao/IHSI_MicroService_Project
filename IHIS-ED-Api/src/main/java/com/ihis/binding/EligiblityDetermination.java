package com.ihis.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EligiblityDetermination {

	private Integer caseNumber;
	private String holderName;
	private Integer holderZzn;
	private String planName;
	private String planStatus;
	private Integer benefitAmt;
	private String denialRsn;
	private LocalDate planStartDate;
	private LocalDate planEndDate;

}
