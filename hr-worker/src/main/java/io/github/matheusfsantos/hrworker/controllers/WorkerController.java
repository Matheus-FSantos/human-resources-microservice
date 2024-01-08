package io.github.matheusfsantos.hrworker.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.matheusfsantos.hrworker.model.dtos.NewWorkerDTO;
import io.github.matheusfsantos.hrworker.model.entities.Worker;
import io.github.matheusfsantos.hrworker.model.services.impl.WorkerServiceImpl;

@RestController
@RequestMapping(value="/api/workers")
public class WorkerController {
	
	@Autowired
	private WorkerServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok().body(this.service.findAll());
	}
	
	@GetMapping("/{userId }")
	public ResponseEntity<Worker> findById(@PathVariable(name="userId") UUID id) {
		return ResponseEntity.ok().body(this.service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> create (@RequestBody NewWorkerDTO newWorker) {
		this.service.create(newWorker);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<Void> create (@RequestBody NewWorkerDTO updatedWorker, @PathVariable(name="userId") UUID id) {
		this.service.update(updatedWorker, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> delete(@PathVariable(name="userId") UUID id) {
		this.service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
