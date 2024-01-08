package io.github.matheusfsantos.hrworker.model.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusfsantos.hrworker.model.entities.Worker;
import io.github.matheusfsantos.hrworker.model.repositories.WorkerRepository;
import io.github.matheusfsantos.hrworker.model.service.HrWorkersService;

@Service
public class WorkerServiceImpl implements HrWorkersService<Worker> {

	@Autowired
	private WorkerRepository repository;
	
	@Override
	public List<Worker> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Worker findById(UUID id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public void create(Worker dtoClass) {
		dtoClass.updateCreatedAt();
		dtoClass.updateUpdatedAt();
		this.repository.save(dtoClass);
	}

	@Override
	public void update(Worker dtoClass, UUID id) { }

	@Override
	public void delete(UUID id) {
		if(this.repository.existsById(id))
			this.repository.deleteById(id);
	}

}
