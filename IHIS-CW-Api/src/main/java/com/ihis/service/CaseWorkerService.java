package com.ihis.service;

import com.ihis.binding.Card;
import com.ihis.binding.LoginForm;
import com.ihis.binding.Profile;

public interface CaseWorkerService {
	
	public String loginCheck(LoginForm loginForm);
	
	public String forgotpwd(String email);
	
	public Card fetchDashBoardCardData();
	
	public Profile fetchProfileInfo(String email);
	
	public String updateProfile(Profile profile);
	
	

}
