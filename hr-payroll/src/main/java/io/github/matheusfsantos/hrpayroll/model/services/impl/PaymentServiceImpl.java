package io.github.matheusfsantos.hrpayroll.model.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("workerId", workerId + "");
		
		WorkerDTO worker = this.restTemplate.getForObject(this.HR_WORKER_HOST.concat("/api/workers/{workerId}"), WorkerDTO.class, uriParams);
		
		if(worker != null)
			return new Payment(worker.getName(), worker.getDailyIncome(), days);
		else
			return null;
	}
	
}
