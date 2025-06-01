package com.e.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MOVIE_PAYMENT_METHODS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentMethodEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_method_id", nullable = false, unique = true)
	private Long paymentMethodId;
	
	@Column(name = "method_name", nullable = false)
    private String methodName;
	
	@Column(name = "is_active")
    private String isActive;
}
