package com.ihis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ihis.bindings.CitizenApp;
import com.ihis.entity.CitizenAppEntity;
import com.ihis.repository.CitizenAppRepository;

@Service
public class AppRegServiceImpl implements AppRegService {
	
	@Autowired
	CitizenAppRepository citizenAppRepository;

	@Override
	public String appRegistration(CitizenApp app) {
		RestTemplate template=new RestTemplate();
		String url="https://ssa-wab-api.herokuapp.com/ssn/{}";
		
		ResponseEntity<String> forEntity = template.getForEntity(url, String.class, app.getZzn());
		String stateName=forEntity.getBody();
		
		
		if("NewJersey".equals(stateName)) {
			app.setStateName(stateName);
			CitizenAppEntity citizenAppEntity=new CitizenAppEntity();
			BeanUtils.copyProperties(app, citizenAppEntity);
			citizenAppRepository.save(citizenAppEntity);
			return "Citizen Application Created..!";

			
		}
		
		return "Citizen Not Belongs To New Jersy";
	}
	
	

	@Override
	public List<CitizenApp> viewApplication() {
		List<CitizenAppEntity> citizenAppEntities =citizenAppRepository.findAll();
		
		List<CitizenApp> citizenApps=new ArrayList<>();
		
		citizenAppEntities.forEach(entity->{
			CitizenApp app=new CitizenApp();
			BeanUtils.copyProperties(citizenAppEntities, app);
			citizenApps.add(app);
		});
		
		return citizenApps;
	}

}