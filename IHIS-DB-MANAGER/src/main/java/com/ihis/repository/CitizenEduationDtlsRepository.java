package com.ihis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ihis.entity.CitizenEduationDtlsEntity;

@Repository
public interface CitizenEduationDtlsRepository extends JpaRepository<CitizenEduationDtlsEntity, Integer> {

	public CitizenEduationDtlsEntity findByCaseNum(Integer caseNum);
	
}
