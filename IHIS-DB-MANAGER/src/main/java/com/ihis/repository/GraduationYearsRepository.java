package com.ihis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ihis.entity.GraduationYearEntiy;

@Repository
public interface GraduationYearsRepository extends JpaRepository<GraduationYearEntiy, Integer> {
	
	public List<String> findByYear();

}
