package io.github.matheusfsantos.hruser.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.matheusfsantos.hruser.model.entities.User;
import io.github.matheusfsantos.hruser.model.service.impl.UserServiceImpl;

@RestController
@RequestMapping(value="/api/users")
public class UserController {

	@Autowired
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private Environment env;
	
	@Autowired
	private UserServiceImpl service;
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> findById(@PathVariable(name="userId") Long id) {
		logger.info("PORT = " + this.env.getProperty("local.server.port"));
		return ResponseEntity.ok().body(this.service.findById(id));
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> search(@RequestParam(name="email") String email) {
		return ResponseEntity.ok().body(this.service.search(email));
	}
	
}
