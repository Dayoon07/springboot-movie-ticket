package com.e.model.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentVo {
	private Long paymentId;
    private Long userId;
    private Long movieId;
    private Long reservationId;
    private Long paymentMethodId;
    private LocalDate paymentDate;
    private int amount;
    private String paymentStatus;
    private String transactionId;
}
