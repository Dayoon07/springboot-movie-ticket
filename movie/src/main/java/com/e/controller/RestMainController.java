package com.e.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e.model.dto.ReservationRequestDto;
import com.e.model.entity.MovieEntity;
import com.e.model.entity.ReservationEntity;
import com.e.model.entity.ShowtimeEntity;
import com.e.model.entity.UserEntity;
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
		Asd message = new Asd("Hello World!");
		return message;
	}
	
	@GetMapping("/movie/all")
	public ResponseEntity<List<MovieEntity>> movieAll() {
		return ResponseEntity.ok(movieRepo.findAll());
	}

	@PostMapping("/user/admin/login")
	public ResponseEntity<?> login(@RequestBody UserEntity entity) {
	    UserEntity user = userRepo.findByNameAndPassword(entity.getName(), entity.getPassword());
	    if (user == null) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(Map.of("message", "아이디 또는 비밀번호가 잘못되었습니다."));
	    }
	    return ResponseEntity.ok(user);
	}
	
	@PostMapping("/reservation")
	public ResponseEntity<?> createReservation(@RequestBody ReservationRequestDto request) {
	    Optional<UserEntity> userOpt = userRepo.findById(request.getUserId());
	    Optional<ShowtimeEntity> showtimeOpt = showtimeRepo.findById(request.getShowtimeId());

	    if (userOpt.isEmpty() || showtimeOpt.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	            .body("잘못된 사용자 또는 상영 시간 정보입니다.");
	    }

	    ReservationEntity reservation = ReservationEntity.builder()
	            .userId(userOpt.get())
	            .showtimeId(showtimeOpt.get())
	            .reservedSeats(request.getReservedSeats())
	            .totalAmount(request.getTotalAmount())
	            .paymentMethod(request.getPaymentMethod())
	            .paymentStatus(request.getPaymentStatus())
	            .reservationStatus("CONFIRMED")
	            .reservationCode(UUID.randomUUID().toString())
	            .build();

	    reservationRepo.save(reservation);

	    return ResponseEntity.ok(Map.of("message", "예매 완료", "code", reservation.getReservationCode()));
	}
	
}
