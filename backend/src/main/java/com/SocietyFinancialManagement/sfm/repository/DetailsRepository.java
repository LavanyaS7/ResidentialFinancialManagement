package com.SocietyFinancialManagement.sfm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SocietyFinancialManagement.sfm.model.Details;

public interface DetailsRepository extends JpaRepository<Details,Integer> {
	public List<Details> findByUserName(String userName);
}
