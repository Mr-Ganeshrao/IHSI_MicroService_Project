package com.ihis.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ihis.binding.AccountForm;
import com.ihis.binding.PlanForm;
import com.ihis.entity.AppPlanEntity;
import com.ihis.entity.CaseWorkersAccounEntity;
import com.ihis.service.AdminService;
import com.ihis.service.AdminServiceImpl;

@RestController
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminService;
	
	@PostMapping("/submitaccount")
	public String createAccount(@RequestBody AccountForm accountForm) {
		
		String createAccount = adminService.createAccount(accountForm);
		 
		return createAccount;
	}
	
	@GetMapping("/viewaccounts")
	public List<CaseWorkersAccounEntity> viewAccount(){
		
		List<CaseWorkersAccounEntity> viewAccount = adminService.viewAccount();
		return viewAccount;
	}
	
	@PostMapping("/editaccount")
	public String editAccount(@RequestBody AccountForm accountForm) {
		String editAccount = adminService.editAccount(accountForm);
		return editAccount;
	}
	
	@DeleteMapping("/deleteacccount/{id}")
	public String deleteAccount(@PathVariable("id") Integer id) {
		String deleteAccount = adminService.deleteAccount(id);
		return deleteAccount;
		
	}
	
	@GetMapping("/plancategory")
	public List<String> planCategory(){
		
		List<String> planCategory = adminService.planCategory();
		return planCategory;
	}
	
	@PostMapping("/submitplans")
	public String createPlan(@RequestBody PlanForm planForm) {
		String createPlan = adminService.createPlan(planForm);
		return createPlan;
	}
	
	@GetMapping("/viewplans")
	public List<AppPlanEntity> viewPlans(){
		List<AppPlanEntity> viewPlan = adminService.viewPlan();
		return viewPlan;
	}
	
	@PostMapping("/editplan/{id}")
	public String editPlan(@PathVariable("id") Integer id) {
		
		String editPlan = adminService.editPlan(id);
		return editPlan;
		
	}
	
	@DeleteMapping("/deleteplan/{id}")
	public String deletPlan(@PathVariable("id") Integer id) {
		String deletePlan = adminService.deletePlan(id);
		return deletePlan;
		
	}
	

}