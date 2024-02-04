package com.tri.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tri.project.model.UserInfo;
import com.tri.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	
	@Override
	public boolean verifyEmail(String email) {
		return userRepo.existsByEmail(email);
	}
	
	
	@Override
	public UserInfo addUser(UserInfo user) {
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setQualification("Qualification_User");
		return userRepo.save(user);
	}

}
