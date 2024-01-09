package io.github.matheusfsantos.hrpayroll.model.services.impl;

import org.springframework.stereotype.Service;

import io.github.matheusfsantos.hrpayroll.model.entities.Payment;
import io.github.matheusfsantos.hrpayroll.model.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService<Payment> {
	
	@Override
	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Matheus", 19.99, 10);
	}
	
}
