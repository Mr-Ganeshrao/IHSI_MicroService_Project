package com.ihis.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihis.binding.Childs;
import com.ihis.binding.CitizenIncome;
import com.ihis.binding.Education;
import com.ihis.binding.Kids;
import com.ihis.binding.PlanSelection;
import com.ihis.binding.Summary;
import com.ihis.entity.AppPlanEntity;
import com.ihis.entity.CitizenChildDtlsEntity;
import com.ihis.entity.CitizenEduationDtlsEntity;
import com.ihis.entity.CitizenIncomeDtlsEntity;
import com.ihis.entity.CitizenPlansEntity;
import com.ihis.repository.AppPlanRepository;
import com.ihis.repository.CitizenChildDtlsRepository;
import com.ihis.repository.CitizenEduationDtlsRepository;
import com.ihis.repository.CitizenIncomeDtlsRepository;
import com.ihis.repository.CitizenPlansRepository;
import com.ihis.repository.GraduationYearsRepository;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {

	@Autowired
	AppPlanRepository appPlanRepository;
	@Autowired
	CitizenPlansRepository citizenPlansRepository;
	@Autowired
	CitizenIncomeDtlsRepository citizenIncomeDtlsRepository;
	@Autowired
	CitizenEduationDtlsRepository citizenEduationDtlsRepository;
	@Autowired
	GraduationYearsRepository graduationYearsRepository;
	@Autowired
	CitizenChildDtlsRepository CitizenChildDtlsRepository;

	@Override
	public Map<Integer, String> planName() {
		List<AppPlanEntity> findAll = appPlanRepository.findAll();

		Map<Integer, String> map = new HashMap<>();

		findAll.forEach(e -> map.put(e.getPlanId(), e.getPlansName()));
		return map;
	}

	@Override
	public String planSelection(PlanSelection planSelection) {

		CitizenPlansEntity entity = new CitizenPlansEntity();
		BeanUtils.copyProperties(planSelection, entity);

		citizenPlansRepository.save(entity);
		return "Plan Selected Successfully ....!";
	}

	@Override
	public String incomeDtls(CitizenIncome citizenIncome) {
		CitizenIncomeDtlsEntity entity = new CitizenIncomeDtlsEntity();

		BeanUtils.copyProperties(citizenIncome, entity);

		citizenIncomeDtlsRepository.save(entity);
		return "Income Details Added Successfully...!";
	}

	@Override
	public List<String> graduationYear() {
		List<String> findByYear = graduationYearsRepository.findByYear();
		return findByYear;
	}

	@Override
	public String EducationDtls(Education education) {
		CitizenEduationDtlsEntity eduationDtlsEntity = new CitizenEduationDtlsEntity();

		BeanUtils.copyProperties(education, eduationDtlsEntity);

		citizenEduationDtlsRepository.save(eduationDtlsEntity);

		return "Education deatils Added SuccessFully...!";
	}

	@Override
	public String kidsDtls(Childs childs) {
		List<Kids> kidsList = childs.getChilds();

		kidsList.forEach(child -> {
			CitizenChildDtlsEntity childDtlsEntity = new CitizenChildDtlsEntity();
			BeanUtils.copyProperties(child, childDtlsEntity);
			CitizenChildDtlsRepository.save(childDtlsEntity);
		});

		return "Kids Added Successfully....!";
	}

	@Override
	public Summary showSummary(Integer caseNumber) {

		Summary summary = new Summary();

		// get income data using caseNum & set to summary
		CitizenIncomeDtlsEntity incomeDtlsEntity = citizenIncomeDtlsRepository.findByCaseNum(caseNumber);
		CitizenIncome citizenIncome = new CitizenIncome();
		BeanUtils.copyProperties(incomeDtlsEntity, citizenIncome);

		summary.setCitizenIncome(citizenIncome);

		// get education data using caseNum & set to summary
		CitizenEduationDtlsEntity eduationDtlsEntity = citizenEduationDtlsRepository.findByCaseNum(caseNumber);
		Education education = new Education();
		BeanUtils.copyProperties(eduationDtlsEntity, education);

		summary.setEducation(education);

		// get child data using caseNum & set to Summary
		List<CitizenChildDtlsEntity> findByCaseNum = CitizenChildDtlsRepository.findByCaseNum(caseNumber);

		List<Kids> kidsList = new ArrayList<>();
		findByCaseNum.forEach(childEntity -> {
			Kids kids = new Kids();
			BeanUtils.copyProperties(childEntity, kids);
			kidsList.add(kids);

		});

		Childs childs = new Childs();
		childs.setCaseNumber(caseNumber);
		childs.setChilds(kidsList);

		summary.setChilds(childs);

		return summary;
	}

}