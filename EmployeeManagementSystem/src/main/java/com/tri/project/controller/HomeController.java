package com.tri.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String Index() {
		return "Index";
	}
	
	@GetMapping("/Register")
	public String Register() {
		return "Register";
	}
	
	@GetMapping("/Login")
	public String Login() {
		return "Login";
	}
}
