package io.github.matheusfsantos.hrpayroll.model.services;

public interface PaymentService<T> {

	T getPayment(Long workerId, Integer days);
	
}
