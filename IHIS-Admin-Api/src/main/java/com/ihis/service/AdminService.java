package com.ihis.service;

import java.util.List;

import com.ihis.binding.AccountForm;
import com.ihis.binding.PlanForm;
import com.ihis.entity.AppPlanEntity;
import com.ihis.entity.CaseWorkersAccounEntity;

public interface AdminService {
	
	public String createAccount(AccountForm accountForm);
	public List<CaseWorkersAccounEntity> viewAccount();
	public String editAccount(AccountForm accountForm);
	public String deleteAccount(Integer id);
	
	public List<String> planCategory();
	public String createPlan(PlanForm planForm);
	public List<AppPlanEntity> viewPlan();
	public String editPlan(Integer id);
	public String deletePlan(Integer id);
	

}
