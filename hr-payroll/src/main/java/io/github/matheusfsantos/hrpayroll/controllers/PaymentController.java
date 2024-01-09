package io.github.matheusfsantos.hrpayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.github.matheusfsantos.hrpayroll.model.entities.Payment;
import io.github.matheusfsantos.hrpayroll.model.services.impl.PaymentServiceImpl;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentServiceImpl service;
	
	@HystrixCommand(fallbackMethod="getPaymentAlternative")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		return ResponseEntity.ok().body(this.service.getPayment(workerId, days));
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
		Payment payment = new Payment("Brann", 400.0, days);
		return ResponseEntity.ok().body(payment);
	}
	
}
