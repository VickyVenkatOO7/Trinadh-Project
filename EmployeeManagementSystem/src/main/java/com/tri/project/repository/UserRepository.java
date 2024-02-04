package com.tri.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tri.project.model.UserInfo;


public interface UserRepository extends JpaRepository<UserInfo, Integer>{
	
	public boolean existsByEmail(String email);
	
	public UserInfo findByEmail(String email);
}
