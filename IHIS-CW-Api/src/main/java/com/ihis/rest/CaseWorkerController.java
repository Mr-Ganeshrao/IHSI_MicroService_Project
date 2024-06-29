package com.ihis.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ihis.binding.Card;
import com.ihis.binding.LoginForm;
import com.ihis.binding.Profile;
import com.ihis.service.CaseWorkerServiceImpl;

@RestController
public class CaseWorkerController {
	
	@Autowired
	CaseWorkerServiceImpl serviceImpl;
	
	@PostMapping("/loginaccount")
	public String loginAccount(@RequestBody LoginForm loginForm) {
		return serviceImpl.loginCheck(loginForm);
	}
	
	@PostMapping("/forgotpassword")
	public String forgotPwd(@RequestBody String email) {
		return serviceImpl.forgotpwd(email);
	}
	
	@GetMapping("/dashboard")
	public Card dashboard() {
		return serviceImpl.fetchDashBoardCardData();
	}
	
	@PostMapping("/fetchprofile")
	public Profile fetchProfile(@RequestBody String email) {
		return serviceImpl.fetchProfileInfo(email);
		
	}
	
	@PostMapping("/updateprofile")
	public String updateProfile(@RequestBody Profile profile) {
		return serviceImpl.updateProfile(profile);
	}
}
