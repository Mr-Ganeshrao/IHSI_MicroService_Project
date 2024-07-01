package com.ihis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ihis.entity.CitizenAppEntity;

@Repository
public interface CitizenAppRepository extends JpaRepository<CitizenAppEntity, Integer> {

	
	public CitizenAppEntity findByCaseNum(Integer caseNumber);
}
