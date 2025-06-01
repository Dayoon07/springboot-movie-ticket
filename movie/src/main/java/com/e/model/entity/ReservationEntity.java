package com.e.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MOVIE_RESERVATIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_reservation_user"))
    private UserEntity userId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "showtime_id", nullable = false, foreignKey = @ForeignKey(name = "fk_reservation_showtime"))
    private ShowtimeEntity showtimeId;

    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;

    @Column(name = "total_amount", nullable = false)
    private int totalAmount;

    @Column(name = "reservation_status")
    private String reservationStatus;

    @Column(name = "reservation_code", unique = true)
    private String reservationCode;
    
}
