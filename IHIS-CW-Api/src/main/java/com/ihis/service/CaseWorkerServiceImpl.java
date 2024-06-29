package com.ihis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihis.binding.Card;
import com.ihis.binding.LoginForm;
import com.ihis.binding.Profile;
import com.ihis.entity.CaseWorkersAccounEntity;
import com.ihis.entity.EligibilityDtlsEntity;
import com.ihis.repository.AppPlanRepository;
import com.ihis.repository.CaseWorkersAcctRepository;
import com.ihis.repository.CitizenAppRepository;
import com.ihis.repository.EligibilityDtlsRepository;

@Service
public class CaseWorkerServiceImpl implements CaseWorkerService {

	@Autowired
	private CaseWorkersAcctRepository caseWorkersAcctRepository;

	@Autowired
	private AppPlanRepository appPlanRepository;

	@Autowired
	private CitizenAppRepository citizenAppRepository;

	@Autowired
	private EligibilityDtlsRepository eligibilityDtlsRepository;

	@Override
	public String loginCheck(LoginForm loginForm) {
		CaseWorkersAccounEntity accounEntity = caseWorkersAcctRepository.findByEmailAndPazzwrd(loginForm.getEmail(),
				loginForm.getPazzwrd());

		if (accounEntity != null) {
			return "LOGIN SUCCESSFULLY...!";
		}
		return "Wrong Id And Password...!";
	}

	@Override
	public String forgotpwd(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card fetchDashBoardCardData() {
		Card card = new Card();
		
		long appCount = citizenAppRepository.count();
		card.setAppsCount((int)appCount);
		
		long planCount=appPlanRepository.count();
		card.setPlansCount((int)planCount);
		
		List<EligibilityDtlsEntity> dtlsEntities=eligibilityDtlsRepository.findAll();
		
		Integer approvedCount=dtlsEntities.stream().filter(e-> e.getPlanstatus().equals("Approved")).collect(Collectors.toList()).size();
		card.setApprovedCitizenCnt(approvedCount);
		
		Integer deniedCount=dtlsEntities.stream().filter(e-> e.getPlanstatus().equals("Denied")).collect(Collectors.toList()).size();
		card.setDeniedCitizenCnt(deniedCount);
		
		return card;
	}

	@Override
	public Profile fetchProfileInfo(String email) {
		CaseWorkersAccounEntity accounEntity=caseWorkersAcctRepository.findByEmail(email);
		
		Profile profile=new Profile();
		BeanUtils.copyProperties(accounEntity, profile);
		return profile;
	}

	@Override
	public String updateProfile(Profile profile) {
		CaseWorkersAccounEntity accounEntity=new CaseWorkersAccounEntity();
		
		BeanUtils.copyProperties(profile, accounEntity);
		caseWorkersAcctRepository.save(accounEntity);
		return "Profile Updated Successfully.....!";
	}

}
