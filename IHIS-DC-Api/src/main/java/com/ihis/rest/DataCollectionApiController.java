package com.ihis.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ihis.binding.Childs;
import com.ihis.binding.CitizenIncome;
import com.ihis.binding.Education;
import com.ihis.binding.PlanSelection;
import com.ihis.binding.Summary;
import com.ihis.service.DataCollectionService;


@RestController
public class DataCollectionApiController {

	@Autowired
	DataCollectionService collectionService;
	
	@GetMapping("/planname")
	public ResponseEntity<Map<Integer, String>> getPlanName(){
		
		Map<Integer, String> planName = collectionService.planName();
		
		return new ResponseEntity<>(planName, HttpStatus.OK) ;
		
	}
	
	@PostMapping("/submitplanselection")
	public ResponseEntity<String> getPlanSelection(@RequestBody PlanSelection planSelection){
		
		String planSelection2 = collectionService.planSelection(planSelection);
		
		return new ResponseEntity<>(planSelection2, HttpStatus.OK);
	}
	
	@PostMapping("/submitincomedtls")
	public ResponseEntity<String> getIncomeDtls(@RequestBody CitizenIncome citizenIncome){
		
		String incomeDtls = collectionService.incomeDtls(citizenIncome);
		
		return new ResponseEntity<>(incomeDtls,HttpStatus.OK);
	} 
	
	@GetMapping("/graduationyear")
	public ResponseEntity<List<String>> getGraduationYear(){
		
		List<String> graduationYear = collectionService.graduationYear();
		
		return new ResponseEntity<>(graduationYear, HttpStatus.OK);
	}
	
	@PostMapping("/submiteducaton")
	public ResponseEntity<String> getEducationDtls(@RequestBody Education education){
		
		String educationDtls = collectionService.EducationDtls(education);
		
		return new ResponseEntity<>(educationDtls,HttpStatus.OK);
	}
	
	@PostMapping("/submitkids")
	public ResponseEntity<String> getKidDtls(@RequestBody Childs childs) {
		
		String kidsDtls = collectionService.kidsDtls(childs);
		
		return new ResponseEntity<>(kidsDtls,HttpStatus.OK);
	}
	
	@GetMapping("/summary/{casenum}")
	public ResponseEntity<Summary> getSummary(@PathVariable Integer caseNumber){
		Summary showSummary = collectionService.showSummary( caseNumber);
		
		return new ResponseEntity<>(showSummary , HttpStatus.OK);
	}
}
