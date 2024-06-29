package com.ihis.service;

import java.util.List;
import java.util.Map;

import com.ihis.binding.Childs;
import com.ihis.binding.CitizenIncome;
import com.ihis.binding.Education;
import com.ihis.binding.PlanSelection;
import com.ihis.binding.Summary;

public interface DataCollectionService {
	
	public Map<Integer, String> planName();
	public String planSelection(PlanSelection planSelection);
	
	public String incomeDtls(CitizenIncome citizenIncome);
	
	public List<String> graduationYear();
	public String EducationDtls(Education education);
	
	public String kidsDtls(Childs childs);
	
	public Summary showSummary(Integer caseNumber);
	

}
