package com.e.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.e.model.dto.MovieReservationTicketDto;
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
	public ResponseEntity<List<MovieEntity>> movieAll() {
		return ResponseEntity.ok(movieRepo.findAll());
	}

	@PostMapping("/user/admin/login")
	public ResponseEntity<?> login(@RequestBody UserEntity entity) {
	    // 이름으로 사용자 검색
	    UserEntity user = userRepo.findByName(entity.getName()).get(0);

	    // 사용자 존재 여부 및 비밀번호 검증
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
	    try {
	        System.out.println("예약 요청 데이터: " + req);
	        
	        // 예약 데이터 검증
	        if (req.getMovie() == null || req.getMovie().trim().isEmpty()) {
	            return ResponseEntity.badRequest().body(Map.of(
	                "success", false,
	                "message", "영화 정보가 필요합니다."
	            ));
	        }
	        
	        if (req.getSeats() == null || req.getSeats().isEmpty()) {
	            return ResponseEntity.badRequest().body(Map.of(
	                "success", false,
	                "message", "좌석 정보가 필요합니다."
	            ));
	        }
	        
	        if (req.getPeople() != req.getSeats().size()) {
	            return ResponseEntity.badRequest().body(Map.of(
	                "success", false,
	                "message", "인원수와 선택한 좌석 수가 일치하지 않습니다."
	            ));
	        }
	        
	        // 여기서 실제 비즈니스 로직 처리
	        // 1. 좌석 중복 체크
	        // 2. 데이터베이스에 예약 정보 저장
	        // 3. 결제 처리 등
	        
	        // 예약 ID 생성 (실제로는 DB에서 생성된 ID 사용)
	        String reservationId = "RES" + System.currentTimeMillis();
	        
	        // 성공 응답
	        Map<String, Object> response = new HashMap<>();
	        response.put("success", true);
	        response.put("message", "예약이 성공적으로 완료되었습니다.");
	        response.put("reservationId", reservationId);
	        response.put("movie", req.getMovie());
	        response.put("date", req.getDate());
	        response.put("time", req.getTime());
	        response.put("seats", req.getSeats());
	        response.put("totalAmount", req.getTotalAmount());
	        response.put("cinema", req.getCinema());
	        
	        return ResponseEntity.ok(response);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
	            "success", false,
	            "message", "서버 오류가 발생했습니다: " + e.getMessage()
	        ));
	    }
	}
	
	@GetMapping("/occupied-seats")
    public List<String> getOccupiedSeats(@RequestParam Long showtimeId) {
        return reservationService.getOccupiedSeats(showtimeId);
    }
	
}
