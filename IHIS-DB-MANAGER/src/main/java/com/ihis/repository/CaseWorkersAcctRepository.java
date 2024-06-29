package com.ihis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ihis.entity.CaseWorkersAccounEntity;

@Repository
public interface CaseWorkersAcctRepository extends JpaRepository<CaseWorkersAccounEntity, Integer> {

	public CaseWorkersAccounEntity findByEmailAndPazzwrd(String email,String pazzwrd);

	public CaseWorkersAccounEntity findByEmail(String email);

}
