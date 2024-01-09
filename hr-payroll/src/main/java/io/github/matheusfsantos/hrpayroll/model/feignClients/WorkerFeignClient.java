package io.github.matheusfsantos.hrpayroll.model.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.matheusfsantos.hrpayroll.model.dtos.WorkerDTO;

@Component
@FeignClient(name="hr-worker", url="localhost:8001", path="/api/workers")
public interface WorkerFeignClient {

	@GetMapping("/{workerId}")
	ResponseEntity<WorkerDTO> findById(@PathVariable(name="workerId") Long id);

}
