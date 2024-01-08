package io.github.matheusfsantos.hrworker.model.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.matheusfsantos.hrworker.model.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, UUID> { }
