package com.ihis.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ihis.bindings.CitizenApp;
import com.ihis.service.AppRegService;

@RestController
public class AppRegController {
	
	
	@Autowired
	AppRegService appRegService;
	
	
	@PostMapping("/createapplicaion")
	public ResponseEntity<String> createApp(@RequestBody CitizenApp citizenApp){
		
		String appRegistration = appRegService.appRegistration(citizenApp);
		
		return new ResponseEntity<>(appRegistration, HttpStatus.OK);
		
	}
	
	@GetMapping("/viewapplications")
	public ResponseEntity<List<CitizenApp>> viewApplication(){
		
		List<CitizenApp> viewApplication = appRegService.viewApplication();
		
		return new ResponseEntity<>(viewApplication, HttpStatus.OK);
		
	}
}
