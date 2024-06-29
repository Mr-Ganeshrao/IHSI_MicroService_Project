package com.ihis.service;

import java.util.List;

import com.ihis.bindings.CitizenApp;

public interface AppRegService {
	
	public String appRegistration(CitizenApp app);
	public List<CitizenApp> viewApplication();

}
