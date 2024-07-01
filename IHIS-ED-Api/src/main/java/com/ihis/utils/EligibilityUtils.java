package com.ihis.utils;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EligibilityUtils {
	
	public boolean kidsAgeEligibility(List<Integer> kidsAgeList) {
		
		for(Integer age : kidsAgeList) {
			if(age>16)
				return false;
		}
		return true;
	}

}
