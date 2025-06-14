package com.e.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.e.model.service.ReservationService;
import com.e.model.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final UserService userService;
	private final ReservationService reservationService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String signupPage() {
		return "user/signup";
	}
	
	@PostMapping("/signupF")
	public String signup(@RequestParam String p1, 
			@RequestParam String p2, 
			@RequestParam String p3,
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password) {
		userService.signup(name, email, password, p1 + "-" + p2 + "-" + p3);
		return "index";
	}
	
	@GetMapping("/reservation-code")
	public String reservationCodePage(Model m) {
		m.addAttribute("selectAllReservationMovieTicket", reservationService.selectAllReservationMovieTicket());
		return "reservation/reservation-code";
	}
	
	@GetMapping("/analyze")
	public String analyzePage(Model m) {
		return "analyze/analyze";
	}

}
