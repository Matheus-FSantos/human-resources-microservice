package io.github.matheusfsantos.hrworker.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
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

@RefreshScope
@RestController
@RequestMapping(value="/api/workers")
public class WorkerController {
	
	@Autowired
	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok().body(this.service.findAll());
	}
	
	@GetMapping("/{workerId}")
	public ResponseEntity<Worker> findById(@PathVariable(name="workerId") Long id) {
		logger.info("PORT = " + this.env.getProperty("local.server.port"));
		return ResponseEntity.ok().body(this.service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> create (@RequestBody NewWorkerDTO newWorker) {
		this.service.create(newWorker);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/{workerId}")
	public ResponseEntity<Void> create (@RequestBody NewWorkerDTO updatedWorker, @PathVariable(name="workerId") Long id) {
		this.service.update(updatedWorker, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/{workerId}")
	public ResponseEntity<Void> delete(@PathVariable(name="workerId") Long id) {
		this.service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
