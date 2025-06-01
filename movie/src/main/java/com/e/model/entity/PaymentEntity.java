package com.e.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MOVIE_PAYMENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false, unique = true)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_payment_user"))
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "movie_id", foreignKey = @ForeignKey(name = "fk_payment_movie"))
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn(name = "reservation_id", foreignKey = @ForeignKey(name = "fk_payment_reservation"))
    private ReservationEntity reservationId;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", foreignKey = @ForeignKey(name = "fk_payment_method"))
    private PaymentMethodEntity paymentMethodId;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "transaction_id")
    private String transactionId;
    
}
