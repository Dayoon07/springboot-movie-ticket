package com.e.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e.model.entity.MovieEntity;
import com.e.model.repository.CinemaRepo;
import com.e.model.repository.MovieRepo;
import com.e.model.repository.ReservationRepo;
import com.e.model.repository.ShowtimeRepo;
import com.e.model.repository.UserRepo;
import com.e.model.service.CinemaService;
import com.e.model.service.MovieService;
import com.e.model.service.ReservationService;
import com.e.model.service.ShowtimeService;
import com.e.model.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping(path = "/api")
@Slf4j
@RequiredArgsConstructor
@RestController
public class RestMainController {
	
	private final CinemaService cinemaService;
	private final MovieService movieService;
	private final ReservationService reservationService;
	private final ShowtimeService showtimeService;
	private final UserService userService;
	
	private final CinemaRepo cinemaRepo;
	private final MovieRepo movieRepo;
	private final ReservationRepo reservationRepo;
	private final ShowtimeRepo showtimeRepo;
	private final UserRepo userRepo;
	
	static class Asd {

		private String message;
		
		public Asd(String message) {
			this.message = message;
		}
		
		
		public String getMessage() {
			return this.message;
		}
		
	}
	
	@GetMapping
	public Asd index() {
		Asd a = new Asd("Hello World!");
		log.info("Hello World!");
		return a;
	}
	
	@GetMapping("/movie/all")
	public ResponseEntity<List<MovieEntity>> movieAll() {
		return ResponseEntity.ok(movieRepo.findAll());
	}

	
	
}
