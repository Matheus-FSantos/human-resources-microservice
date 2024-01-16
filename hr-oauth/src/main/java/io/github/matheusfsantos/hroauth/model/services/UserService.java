package io.github.matheusfsantos.hroauth.model.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusfsantos.hroauth.model.entities.User;
import io.github.matheusfsantos.hroauth.model.feignClients.UserFeignClient;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;

	public User findByEmail(String email) {
		User user = this.userFeignClient.search(email).getBody();
		
		if(user == null) {
			UserService.logger.error("E-mail not found: " + email);
			throw new IllegalArgumentException("User not found");
		}
		else {
			UserService.logger.info("E-mail found: " + email);
			return user;
		}
	}
	
}
