package com.ihis.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihis.binding.EligiblityDetermination;
import com.ihis.entity.AppPlanEntity;
import com.ihis.entity.CitizenAppEntity;
import com.ihis.entity.CitizenChildDtlsEntity;
import com.ihis.entity.CitizenEduationDtlsEntity;
import com.ihis.entity.CitizenIncomeDtlsEntity;
import com.ihis.entity.CitizenPlansEntity;
import com.ihis.entity.CorrespondenceTriggerEntity;
import com.ihis.entity.EligibilityDtlsEntity;
import com.ihis.repository.AppPlanRepository;
import com.ihis.repository.CitizenAppRepository;
import com.ihis.repository.CitizenChildDtlsRepository;
import com.ihis.repository.CitizenEduationDtlsRepository;
import com.ihis.repository.CitizenIncomeDtlsRepository;
import com.ihis.repository.CitizenPlansRepository;
import com.ihis.repository.CoTriggerRepository;
import com.ihis.repository.EligibilityDtlsRepository;
import com.ihis.utils.EligibilityUtils;

@Service
public class EigiblityDeterminationServiceImpl implements EligiblityDeterminationService {

	@Autowired
	private AppPlanRepository appPlanRepository;
	@Autowired
	private CitizenAppRepository citizenAppRepository;
	@Autowired
	private CitizenIncomeDtlsRepository citizenIncomeDtlsRepository;
	@Autowired
	private CitizenChildDtlsRepository citizenChildDtlsRepository;
	@Autowired
	private CitizenPlansRepository citizenPlansRepository;
	@Autowired
	private CitizenEduationDtlsRepository citizenEduationDtlsRepository;
	@Autowired
	private EligibilityDtlsRepository eligibilityDtlsRepository;
	@Autowired
	private CoTriggerRepository coTriggerRepository;
	@Autowired
	private EligibilityUtils utils;

	@Override
	public EligiblityDetermination CheckEligiblityDetermination(Integer caseNumber) {

		String planStatus = null;

		LocalDate today = LocalDate.now();

		// geting planId
		CitizenPlansEntity planEntity = citizenPlansRepository.findByCaseNum(caseNumber);
		Integer planId = planEntity.getPlanId();

		// geting planName
		Optional<AppPlanEntity> optional = appPlanRepository.findById(planId);
		AppPlanEntity appPlanEntity = optional.get();
		String plansName = appPlanEntity.getPlansName();

		// geting income
		CitizenIncomeDtlsEntity incomeEntity = citizenIncomeDtlsRepository.findByCaseNum(caseNumber);
		Double salaryIncome = incomeEntity.getSalaryIncome();
		Double propertyIncome = incomeEntity.getPropertyIncome();

		// geting child count
		List<CitizenChildDtlsEntity> listOfChilds = citizenChildDtlsRepository.findByCaseNum(caseNumber);
		Integer childCount = listOfChilds.size();

		// citizen details
		CitizenAppEntity citizenDtls = citizenAppRepository.findByCaseNum(caseNumber);
		Integer citizenAge = Period.between(citizenDtls.getDob(), today).getYears();

		// citizen education Details
		CitizenEduationDtlsEntity findByCaseNum = citizenEduationDtlsRepository.findByCaseNum(caseNumber);
		String graduationYear = findByCaseNum.getGraduationYear();

		// get kidS age
		List<Integer> ageList = new ArrayList<>();

		listOfChilds.forEach(child -> {
			Integer age = Period.between(child.getChildDob(), today).getYears();
			ageList.add(age);
		});

		// condition to check age
		boolean isAgeOk = utils.kidsAgeEligibility(ageList);

		EligiblityDetermination binding = new EligiblityDetermination();
		binding.setCaseNumber(caseNumber);
		binding.setBenefitAmt(400);
		binding.setHolderName(citizenDtls.getFullName());
		binding.setHolderZzn(citizenDtls.getZzn());
		binding.setPlanName(plansName);

		if ("SNAP".equals(plansName) && salaryIncome > 300) {
			binding.setPlanStatus("Denied");
			binding.setDenialRsn("For SNAP Income Is Greater 300$");
		}
		if ("CCAP".equals(plansName) && salaryIncome > 300) {
			if (childCount > 0 && isAgeOk) {
				binding.setPlanStatus("Denied");
				binding.setDenialRsn("For CCAP Income Is Greater 300$");
			}
		}
		if ("Medicaid".equals(plansName) && salaryIncome > 300) {
			if (propertyIncome != 0) {
				binding.setPlanStatus("Denied");
				binding.setDenialRsn("Medicaid not applicable since income is available");
			}
		}
		if ("Medicare".equals(plansName) && citizenAge < 65) {
			binding.setPlanStatus("Denied");
			binding.setDenialRsn("Age has to be greater than or equal to 65 years");
		}

		if ("NJW".equals(plansName) && (graduationYear == null)) {
			binding.setPlanStatus("Denied");
			binding.setDenialRsn("NJW is not applicable for non-graduates");
		}

		if (binding.getPlanStatus() == null) {
			binding.setPlanStatus("Approved");
			binding.setDenialRsn("NA");
			binding.setPlanStartDate(today);
			binding.setPlanEndDate(today.plusMonths(3));
		} else {
			binding.setPlanStartDate(null);
			binding.setPlanEndDate(null);
		}
		//save data into eligibility Determination table
		saveEligDtls(binding);
		
		//save data into cotrigger table
		saveCoTriggerDtls(binding);

		return binding;

	}
	
	private void saveEligDtls(EligiblityDetermination binding) {
		EligibilityDtlsEntity entity =new EligibilityDtlsEntity();
		BeanUtils.copyProperties(binding, entity);
		eligibilityDtlsRepository.save(entity);
		
	}
	
	private void saveCoTriggerDtls(EligiblityDetermination binding) {
		CorrespondenceTriggerEntity entity=new CorrespondenceTriggerEntity();
		entity.setCaseNum(binding.getCaseNumber());
		entity.setTrgStatus("Pending");
		entity.setNotice(null);
	}
	
}
