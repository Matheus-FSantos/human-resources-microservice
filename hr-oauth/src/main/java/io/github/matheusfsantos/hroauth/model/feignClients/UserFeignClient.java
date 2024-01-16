package io.github.matheusfsantos.hroauth.model.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.matheusfsantos.hroauth.model.entities.User;

@Component
@FeignClient(name="hr-user", path="/api/users")
public interface UserFeignClient {

	@GetMapping("/search")
	ResponseEntity<User> search(@RequestParam(name="email") String email);
		
}
