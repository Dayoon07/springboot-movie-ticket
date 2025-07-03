package com.e.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.e.model.dto.MovieBookingDto;
import com.e.model.dto.MovieInfoDto;
import com.e.model.dto.MovieReservationDto;
import com.e.model.dto.MovieReservationTicketDto;
import com.e.model.entity.CinemaEntity;
import com.e.model.entity.MovieEntity;
import com.e.model.entity.ReservationEntity;
import com.e.model.entity.ShowtimeEntity;
import com.e.model.entity.UserEntity;
import com.e.model.repository.CinemaRepo;
import com.e.model.repository.MovieRepo;
import com.e.model.repository.ReservationRepo;
import com.e.model.repository.ShowtimeRepo;
import com.e.model.repository.UserRepo;
import com.e.model.service.AiChatService;
import com.e.model.service.CinemaService;
import com.e.model.service.MovieService;
import com.e.model.service.ReservationService;
import com.e.model.service.ShowtimeService;
import com.e.model.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

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
	
	private final AiChatService aiChatService;
	
	private final BCryptPasswordEncoder passwordEncoder;
	
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
	public ResponseEntity<List<MovieBookingDto>> movieAll() {
		return ResponseEntity.ok(movieService.getMovieBookingList());
	}
	
	@GetMapping("/reservation/reserved/movie/all")
	public ResponseEntity<List<ReservationEntity>> getReservedFindAllMovies() {
		return ResponseEntity.ok(reservationRepo.findAll());
	}

	@PostMapping("/user/admin/login")
	public ResponseEntity<?> login(@RequestBody UserEntity entity) {
	    UserEntity user = userRepo.findByName(entity.getName()).get(0);
	    System.out.println(entity.getName());

	    if (user == null || !passwordEncoder.matches(entity.getPassword(), user.getPassword())) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(Map.of("message", "아이디 또는 비밀번호가 잘못되었습니다."));
	    }

	    System.out.println(user);
	    System.out.println("암호화 해제된 비번: " + passwordEncoder.matches(entity.getPassword(), user.getPassword()) != null ? entity.getPassword() : "틀림");
	    return ResponseEntity.ok(user);
	}

	@PostMapping("/reservation")
	public ResponseEntity<?> reservationFunc(@RequestBody MovieReservationTicketDto req) {
	    System.out.println("요청 데이터 : \n" + req);
	    String n = reservationService.reserved(req);
	    showtimeService.updateReservationMovieTicketSeat(req.getPeople(), req.getShowtimeId());
	    return ResponseEntity.ok(n);
	}
	
	@GetMapping("/occupied-seats")
    public List<String> getOccupiedSeats(@RequestParam Long showtimeId) {
        return reservationService.getOccupiedSeats(showtimeId);
    }
	
	@GetMapping("/movies")
	public ResponseEntity<List<MovieEntity>> getAllMovies() {
		return ResponseEntity.ok(movieRepo.findAll());
	}
	
	@GetMapping("/showtimes")
	public ResponseEntity<List<ShowtimeEntity>> getAllShowtime() {
		return ResponseEntity.ok(showtimeRepo.findAll());
	}
	
	@GetMapping("/cinemas")
	public ResponseEntity<List<CinemaEntity>> getAllCinema() {
		return ResponseEntity.ok(cinemaRepo.findAll());
	}
	
	@GetMapping("/movie/info/{movieId}")
	public ResponseEntity<List<MovieInfoDto>> getMovieInfo(@PathVariable Long movieId) {
		return ResponseEntity.ok(movieService.selectMovieOneInfo(movieId));
	}
	
	@GetMapping("/reservation/seats/occupied")
	public ResponseEntity<List<String>> getMovieReservationSeats(@RequestParam Long showtimeId) {
		return ResponseEntity.ok(reservationService.selectGetReservationMovieInfo(showtimeId));
	}
	
	@GetMapping("/reservation/movie/info")
	public ResponseEntity<MovieReservationDto> getReservationMovieTicket(@RequestParam String reservationCode) {
		return ResponseEntity.ok(reservationService.selectMyReservationMovieTicket(reservationCode));
	}
	
	@PostMapping("/reservation/del/movie")
	public String deleteReservationMovie(@RequestBody Map<String, Object> body) {
	    String reservationCode = (String) body.get("reservationCode");
	    int seatCount = (int) body.get("seatCount");

	    reservationService.restoreAvailableSeats(reservationCode, seatCount);
	    reservationService.cancelReservationMovieAndSeat(reservationCode);
	    return "예매가 취소 되었습니다.";
	}

	
	@GetMapping(value = "/ai/chat", produces = MediaType.TEXT_PLAIN_VALUE)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Flux<String>> generateMovieTxtVal(@RequestParam String q) {
	    System.out.println("Question: " + q);
	    
	    return ResponseEntity.ok(aiChatService.generateMovieTxtVal(q));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<MovieBookingDto>> movieSearch(@RequestParam String title) {
		return ResponseEntity.ok(movieService.movieSearch(title));
	}
	
	
	
}
