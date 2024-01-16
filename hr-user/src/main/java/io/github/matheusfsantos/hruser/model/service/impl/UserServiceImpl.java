package io.github.matheusfsantos.hruser.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import io.github.matheusfsantos.hruser.model.entities.User;
import io.github.matheusfsantos.hruser.model.repositories.UserRepository;
import io.github.matheusfsantos.hruser.model.service.HrUserService;

public class UserServiceImpl implements HrUserService<User> {

	@Autowired
	private UserRepository repository;

	@Override
	public User findById(Long id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public User search(String email) {
		return this.repository.findByEmail(email).orNull();
	}

}
