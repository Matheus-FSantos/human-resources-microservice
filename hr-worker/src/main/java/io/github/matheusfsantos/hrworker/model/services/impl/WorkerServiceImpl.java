package io.github.matheusfsantos.hrworker.model.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.matheusfsantos.hrworker.model.dtos.NewWorkerDTO;
import io.github.matheusfsantos.hrworker.model.entities.Worker;
import io.github.matheusfsantos.hrworker.model.repositories.WorkerRepository;
import io.github.matheusfsantos.hrworker.model.services.HrWorkersService;

@Service
public class WorkerServiceImpl implements HrWorkersService<NewWorkerDTO, Worker> {

	@Autowired
	private WorkerRepository repository;
	
	@Override
	public List<Worker> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Worker findById(UUID id) {
		List<Worker> workers = this.findAll();
		
		for(Worker worker : workers) {
			if(worker.getId().equals(id))
				return worker;
		}
		
		return null;
	}

	@Override
	public void create(NewWorkerDTO dtoClass) {
		Worker newWorker = new Worker(dtoClass);
		this.repository.save(newWorker);
	}

	@Override
	public void update(NewWorkerDTO dtoClass, UUID id) {
		if(this.repository.existsById(id)) {
			Worker oldWorker = this.findById(id);
			Worker updatedWorker = new Worker(oldWorker.getId(), dtoClass, oldWorker.getCreatedAt());
			this.repository.save(updatedWorker);
		}
	}

	@Override
	public void delete(UUID id) {
		if(this.repository.existsById(id))
			this.repository.deleteById(id);
	}

}
