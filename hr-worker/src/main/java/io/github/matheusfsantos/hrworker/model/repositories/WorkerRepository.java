package io.github.matheusfsantos.hrworker.model.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.matheusfsantos.hrworker.model.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, UUID> { }
