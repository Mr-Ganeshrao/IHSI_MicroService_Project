package com.ihis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ihis.entity.CorrespondenceTriggerEntity;

@Repository
public interface CoTriggerRepository extends JpaRepository<CorrespondenceTriggerEntity, Integer> {
  
	public List<CorrespondenceTriggerEntity> findByTrgStatus(String status);
}
