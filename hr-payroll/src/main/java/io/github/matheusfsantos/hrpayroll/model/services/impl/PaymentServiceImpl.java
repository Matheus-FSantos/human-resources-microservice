package io.github.matheusfsantos.hrpayroll.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.matheusfsantos.hrpayroll.model.dtos.WorkerDTO;
import io.github.matheusfsantos.hrpayroll.model.entities.Payment;
import io.github.matheusfsantos.hrpayroll.model.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService<Payment> {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${hr-worker.host}")
	private String HR_WORKER_HOST;
	
	@Override
	public Payment getPayment(Long workerId, Integer days) {
		ResponseEntity<WorkerDTO> response = this.restTemplate.getForEntity(this.HR_WORKER_HOST.concat("/api/workers/" + workerId), WorkerDTO.class);
		return new Payment(response.getBody().getName(), response.getBody().getDailyIncome(), days);
	}
	
}
