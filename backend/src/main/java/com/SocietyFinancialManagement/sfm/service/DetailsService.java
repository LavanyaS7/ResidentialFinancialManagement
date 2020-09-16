package com.SocietyFinancialManagement.sfm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SocietyFinancialManagement.sfm.model.Details;
import com.SocietyFinancialManagement.sfm.repository.DetailsRepository;


@Service
public class DetailsService {
	@Autowired
	private DetailsRepository repo;
	
	public List<Details> getDetailsByUsername(String userName) {
		List<Details> detail;
		detail=repo.findByUserName(userName);
		return detail;
	}

	public List<Details> fetchDetails() {
		return repo.findAll();
	}
}
