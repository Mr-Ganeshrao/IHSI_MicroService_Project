package com.ihis.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ihis.entity.AppPlanEntity;

@Repository
public interface AppPlanRepository extends JpaRepository<AppPlanEntity, Integer> {

	
	
}
