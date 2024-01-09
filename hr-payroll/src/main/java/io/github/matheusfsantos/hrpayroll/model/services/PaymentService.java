package io.github.matheusfsantos.hrpayroll.model.services;

import org.springframework.stereotype.Service;

import io.github.matheusfsantos.hrpayroll.model.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Matheus", 19.99, 10);
	}
	
}
