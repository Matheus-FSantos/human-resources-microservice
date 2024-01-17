package io.github.matheusfsantos.hroauth.model.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.matheusfsantos.hroauth.model.entities.User;
import io.github.matheusfsantos.hroauth.model.feignClients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;

	public User findByEmail(String email) {
		User user = this.userFeignClient.search(email).getBody();
		
		if(user == null) {
			UserService.logger.error("E-mail not found: " + email);
			throw new IllegalArgumentException("User not found");
		} else {
			UserService.logger.info("E-mail found: " + email);
			return user;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userFeignClient.search(username).getBody();
		
		if(user == null) {
			UserService.logger.error("E-mail not found: " + username);
			throw new UsernameNotFoundException("User not found");
		} else {
			UserService.logger.info("E-mail found: " + username);
			return user;
		}
	}
	
}
