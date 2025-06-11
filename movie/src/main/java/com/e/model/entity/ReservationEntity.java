package com.e.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false, 
    	foreignKey = @ForeignKey(name = "fk_reservation_showtime")
    )
    private ShowtimeEntity showtime;
    
    @Lob
    @Column(name = "reservation_movie_poster_url")
    private String reservationMoviePosterUrl;

    @CreationTimestamp
    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;

    @Column(name = "total_amount", nullable = false)
    private Integer totalAmount;

    @Column(name = "reservation_status")
    private String reservationStatus;

    @Column(name = "reservation_code", unique = true)
    private String reservationCode;

    @Column(name = "reserved_seats")
    private String reservedSeats;

    @Column(name = "payment_method")
    private String paymentMethod;

    @CreationTimestamp
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "transaction_id")
    private String transactionId;
    
}
