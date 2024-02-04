package com.tri.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tri.project.model.UserInfo;
import com.tri.project.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/")
	public String Index() {
		return "Index";
	}
	
	@GetMapping("/Register")
	public String Register() {
		return "Register";
	}
	
	@GetMapping("/Signin")	
	public String Login() {
		return "Login";
	}
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute UserInfo user, HttpSession session) {
		boolean emailExists = userService.verifyEmail(user.getEmail());
		
		if (emailExists) {
			session.setAttribute("msg", "Email I'd already exists.");
			System.out.println("Email I'd already exists.");
		}else {
			UserInfo userInfo = userService.addUser(user);
			if (userInfo!=null) {
				session.setAttribute("msg", "User Registration Successful.");
				System.out.println("User Registration Successful.");
			}else {
				session.setAttribute("msg", "User Registration UnSuccessful.");
				System.out.println("User Registration UnSuccessful.");
			}
		}
		session.removeAttribute("msg");
		return "redirect:/Register";
	}
}
