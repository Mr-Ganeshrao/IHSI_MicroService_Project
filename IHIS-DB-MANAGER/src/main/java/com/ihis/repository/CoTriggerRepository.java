package com.ihis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ihis.entity.CorrespondenceTriggerEntity;

@Repository
public interface CoTriggerRepository extends JpaRepository<CorrespondenceTriggerEntity, Integer> {

}
