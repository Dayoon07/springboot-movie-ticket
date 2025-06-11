package com.e.model.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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

        // 중복 좌석 체크 예시 (optional, 단순 비교)
        if (reservationRepo.existsByShowtimeAndReservedSeatsContaining(dto.getShowtimeId(), dto.getSeats().get(0))) {
            throw new IllegalArgumentException("이미 예약된 좌석이 포함되어 있습니다.");
        }

        // 사용자 조회 (로그인 기반인 경우)
        UserEntity user = userRepo.findById(dto.getUserId())
            .orElseThrow(() -> new IllegalArgumentException("사용자 정보를 찾을 수 없습니다."));

        // 상영 정보 조회
        ShowtimeEntity showtime = showtimeRepo.findById(dto.getShowtimeId())
            .orElseThrow(() -> new IllegalArgumentException("상영 정보를 찾을 수 없습니다."));

        // 예약 정보 생성
        ReservationEntity entity = ReservationEntity.builder()
            .user(user)
            .showtime(showtime)
            .reservedSeats(String.join(",", dto.getSeats()))
            .reservationMoviePosterUrl(dto.getPoster())
            .totalAmount(dto.getTotalAmount())
            .reservationStatus("CONFIRMED")
            .reservationCode("RES" + System.currentTimeMillis())
            .paymentMethod(dto.getPaymentMethod())
            .transactionId("TX-" + UUID.randomUUID()) // 임시 트랜잭션 ID
            .build();

        reservationRepo.save(entity);
    }
	
	
	
	
	
	
	
	
}
