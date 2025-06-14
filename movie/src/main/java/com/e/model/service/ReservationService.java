package com.e.model.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.e.model.dto.MovieReservationDto;
import com.e.model.dto.MovieReservationTicketDto;
import com.e.model.entity.MovieEntity;
import com.e.model.entity.ReservationEntity;
import com.e.model.entity.ShowtimeEntity;
import com.e.model.entity.UserEntity;
import com.e.model.mapper.ReservationMapper;
import com.e.model.repository.ReservationRepo;
import com.e.model.repository.ShowtimeRepo;
import com.e.model.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
	
	private final ReservationRepo reservationRepo;
	private final UserRepo userRepo;
	private final ShowtimeRepo showtimeRepo;
	
	private final ReservationMapper reservationMapper;
	
	public List<String> getOccupiedSeats(Long showtimeId) {
        List<String> seatStrings = reservationMapper.findReservedSeatsByShowtimeId(showtimeId);
        
        return seatStrings.stream()
                .filter(Objects::nonNull)
                .flatMap(s -> Arrays.stream(s.split(",")))
                .distinct()
                .collect(Collectors.toList());
    }
	
	public void reserved(MovieReservationTicketDto dto) {
	    // 사용자 조회
	    UserEntity user = userRepo.findById(dto.getUserId())
	        .orElseThrow(() -> new IllegalArgumentException("사용자 정보를 찾을 수 없습니다."));

	    // 상영 정보 조회
	    ShowtimeEntity showtime = showtimeRepo.findById(dto.getShowtimeId())
	        .orElseThrow(() -> new IllegalArgumentException("상영 정보를 찾을 수 없습니다."));

	    // 중복 좌석 체크
	    if (reservationRepo.existsByShowtimeAndReservedSeatsContaining(showtime, dto.getSeats().get(0))) {
	        throw new IllegalArgumentException("이미 예약된 좌석이 포함되어 있습니다.");
	    }

	    // 예약 정보 생성
	    ReservationEntity entity = ReservationEntity.builder()
	        .user(user)
	        .showtime(showtime)
	        .reservedSeats(String.join(",", dto.getSeats()))
	        .reservationMoviePosterUrl(dto.getMoviePosterImageUrl())
	        .totalAmount(dto.getTotalPrice())
	        .reservationStatus("CONFIRMED")
	        .reservationCode(randVariable())
	        .paymentMethod(dto.getPaymentMethod())
	        .build();

	    reservationRepo.save(entity);
	}
	
	public String randVariable() {
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("MMdd"));

		Random random = new Random();
		int random4_1 = random.nextInt(9000) + 1000; // 1000-9999
		int random4_2 = random.nextInt(9000) + 1000; // 1000-9999
		int random3 = random.nextInt(900) + 100; // 100-999

		String s = String.format("%s-%04d-%04d-%03d", today, random4_1, random4_2, random3);
		System.out.println(s);
		return s;
	}

	public List<String> selectGetReservationMovieInfo(Long showtimeId) {
		List<String> seatStrings = reservationMapper.selectGetReservationMovieInfo(showtimeId);
		List<String> allReservedSeats = seatStrings.stream()
		    .filter(Objects::nonNull)
		    .flatMap(seats -> Arrays.stream(seats.split(",")))
		    .map(String::trim)
		    .collect(Collectors.toList());
		return allReservedSeats;
	}
	
	public MovieReservationDto selectMyReservationMovieTicket(String reservationCode) {
		return reservationMapper.selectMyReservationMovieTicket(reservationCode);
	}
	
	public List<MovieReservationDto> selectAllReservationMovieTicket() {
		return reservationMapper.selectAllReservationMovieTicket();
	}
	
}
