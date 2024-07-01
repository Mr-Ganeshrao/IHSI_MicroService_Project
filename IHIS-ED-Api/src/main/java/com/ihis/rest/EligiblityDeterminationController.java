package com.ihis.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ihis.binding.EligiblityDetermination;
import com.ihis.service.EligiblityDeterminationService;

@RestController
public class EligiblityDeterminationController {
	
	@Autowired
	EligiblityDeterminationService determinationService;
	
	@PostMapping("/checkeligibilitydermination/{casenum}")
	public ResponseEntity<EligiblityDetermination> checkEligDetermination(@PathVariable Integer caseNumber){
		
		
		EligiblityDetermination checkEligiblityDetermination = determinationService.CheckEligiblityDetermination(caseNumber);
		
		return new ResponseEntity<> (checkEligiblityDetermination,HttpStatus.OK);
	}

}
