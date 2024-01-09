package io.github.matheusfsantos.hrpayroll.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusfsantos.hrpayroll.model.dtos.WorkerDTO;
import io.github.matheusfsantos.hrpayroll.model.entities.Payment;
import io.github.matheusfsantos.hrpayroll.model.feignClients.WorkerFeignClient;
import io.github.matheusfsantos.hrpayroll.model.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService<Payment> {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	@Override
	public Payment getPayment(Long workerId, Integer days) {		
		WorkerDTO worker = workerFeignClient.findById(workerId).getBody();
		
		if(worker != null)
			return new Payment(worker.getName(), worker.getDailyIncome(), days);
		else
			return null;
	}
	
}
