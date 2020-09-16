package com.SocietyFinancialManagement.sfm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.SocietyFinancialManagement.sfm.model.Details;
import com.SocietyFinancialManagement.sfm.service.DetailsService;


@RestController
public class DetailsContoller {
	@Autowired
	private DetailsService service; 
	
	@GetMapping("/userdetails")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Details> getdetails () {
		return service.fetchDetails();
	}
	
	@GetMapping("/finduserdetails/{userName}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Details> finduserdetails(@PathVariable String userName) {
		return service.getDetailsByUsername(userName);
	}
}
