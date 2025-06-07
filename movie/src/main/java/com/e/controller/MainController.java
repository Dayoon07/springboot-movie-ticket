package com.e.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.e.model.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/signup")
	public String signup(@RequestParam String p1, 
			@RequestParam String p2, 
			@RequestParam String p3,
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password) {
		userService.signup(name, email, password, p1 + "-" + p2 + "-" + p3);
		return "redirect:/";
	}
	

}
