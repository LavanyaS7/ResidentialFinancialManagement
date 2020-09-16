package com.SocietyFinancialManagement.sfm.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.SocietyFinancialManagement.sfm.model.User;
import com.SocietyFinancialManagement.sfm.service.RegistrationService;

@RestController
public class RegistrationController {
@Autowired
public JavaMailSender javaMailSender;
@Autowired
private RegistrationService service;
@Autowired
private BCryptPasswordEncoder passwordEncoder;

@PostMapping("/registeruser")
@CrossOrigin(origins = "http://localhost:4200")
public User registerUser(@RequestBody User user) throws Exception{
    String tempEmailId=user.getEmailId();
    SimpleMailMessage message = new SimpleMailMessage();
    if(tempEmailId!=null && !"".equals(tempEmailId)) {
    	User userobj=service.fetchUserByEmailId(tempEmailId);
    	if(userobj!=null) {
    		throw new Exception("user with "+tempEmailId+" already exists");
    	}
    }
	User userobj=null;	
	message.setTo(user.getEmailId());
	message.setSubject("Registration Confirmation");
	message.setText("Dear "+user.getUserName()+",\n\n"+"Welcome to Sea Meridian's Residential Association!!\nWe're glad you joined us. Have a great day!! \n\nThank You!");
	javaMailSender.send(message);
	String password=user.getPassword();
	String encryptPWD=passwordEncoder.encode(password);
	user.setPassword(encryptPWD);
	userobj=service.saveUser(user);
	return userobj ;
}
@PostMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public User loginUser(@RequestBody User user) throws Exception {
	String tempEmailId=user.getEmailId();
	String tempPassword=user.getPassword();
	User userobj= service.fetchUserByEmailId(tempEmailId);
	if(passwordEncoder.matches(tempPassword, userobj.getPassword()))
		return userobj;
	else 
		throw new Exception("Invalid Credentials") ;
}
}
