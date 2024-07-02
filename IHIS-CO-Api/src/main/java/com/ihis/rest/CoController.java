package com.ihis.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ihis.service.CorrespondenceServiceImpl;

@RestController
public class CoController {

	@Autowired
	private CorrespondenceServiceImpl service;
	
	@GetMapping("/notice")
	public ResponseEntity<Map<String, Integer>> generatenotice() {
		
		Map<String, Integer> generatedNotices = service.generatedNotices();	
		
		return new ResponseEntity<>(generatedNotices,HttpStatus.OK);
	}
}
