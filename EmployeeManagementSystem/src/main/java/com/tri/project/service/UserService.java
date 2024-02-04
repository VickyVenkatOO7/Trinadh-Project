package com.tri.project.service;

import com.tri.project.model.UserInfo;

public interface UserService {
	
	public UserInfo addUser(UserInfo user);
	
	public boolean verifyEmail(String email);
}
