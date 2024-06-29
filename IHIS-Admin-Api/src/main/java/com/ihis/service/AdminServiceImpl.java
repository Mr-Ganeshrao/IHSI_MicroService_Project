package com.ihis.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihis.binding.AccountForm;
import com.ihis.binding.PlanForm;
import com.ihis.entity.AppPlanEntity;
import com.ihis.entity.CaseWorkersAccounEntity;
import com.ihis.repository.AppPlanRepository;
import com.ihis.repository.CaseWorkersAcctRepository;
import com.ihis.repository.PlanCategoryRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AppPlanRepository appPlanRepository;
	
	@Autowired
	CaseWorkersAcctRepository caseWorkersAcctRepository;
	
	@Autowired
	PlanCategoryRepository planCategoryRepository;

	@Override
	public String createAccount(AccountForm accountForm) {
		CaseWorkersAccounEntity entity = new CaseWorkersAccounEntity();

		BeanUtils.copyProperties(accountForm, entity);
		entity.setActivestatus("Y");
		entity.setPazzwrd(generateRandompwd());

		CaseWorkersAccounEntity save = caseWorkersAcctRepository.save(entity);
		if (save != null) {
			return "Account Created SuccessFully...!";
		}
		return "Somethings Happen Wrong....!";
	}

	@Override
	public List<CaseWorkersAccounEntity> viewAccount() {
		List<CaseWorkersAccounEntity> findAll = caseWorkersAcctRepository.findAll();
		return findAll;
	}

	@Override
	public String editAccount(AccountForm accountForm) {
		CaseWorkersAccounEntity entity=new CaseWorkersAccounEntity();
		
		BeanUtils.copyProperties(accountForm, entity);
		
		
			caseWorkersAcctRepository.save(entity);
			return "Account updated Succefully....! ";
		
	}

	@Override
	public String deleteAccount(Integer id) {
		 
		Optional<CaseWorkersAccounEntity> findById = caseWorkersAcctRepository.findById(id);
		if(findById.isPresent()) {
			CaseWorkersAccounEntity accounEntity=findById.get();
			accounEntity.setActivestatus("N");
			caseWorkersAcctRepository.save(accounEntity);
			return "Record Deleted..!";
		}

		
		return "record Not Found";
	}

	@Override
	public List<String> planCategory() {
		//List<String> findByCategoryName = categoryRepository.findByCategoryName();
		
				//return findByCategoryName;
		return null;
		
	}

	@Override
	public String createPlan(PlanForm planForm) {
		AppPlanEntity entity=new AppPlanEntity();
		
		BeanUtils.copyProperties(planForm, entity);
		
		AppPlanEntity save = appPlanRepository.save(entity);
		
		if(save!= null) {
			return "Plans Inserted Successfully...!";
		}
		return "Something Happens Wrong";
	}

	@Override
	public List<AppPlanEntity> viewPlan() {
		
		List<AppPlanEntity> findAll = appPlanRepository.findAll();
		
		return findAll;
	}

	@Override
	public String editPlan(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePlan(Integer id) {
		Optional<AppPlanEntity> findById = appPlanRepository.findById(id);
		
		if(findById.isPresent()) {
			
			AppPlanEntity entity=new AppPlanEntity();
			entity.setActiveStatus("N");
			appPlanRepository.save(entity);
			return "plan deleted successfully...!";
		}
		return "Something Happens Wrong...!";
	}
	
	

	// Auto password generation method
	private String generateRandompwd() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 6;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString;
	}

}
