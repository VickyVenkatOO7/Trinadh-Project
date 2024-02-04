package com.tri.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tri.project.model.UserInfo;
import com.tri.project.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserInfo userInfo = userRepo.findByEmail(email);
		
		if (userInfo != null) {
			return new CustomUserInfo(userInfo);
		}
		
		throw new UsernameNotFoundException("User not available.");
		
	}

	
}
