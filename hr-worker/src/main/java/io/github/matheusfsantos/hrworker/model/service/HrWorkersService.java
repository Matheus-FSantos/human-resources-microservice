package io.github.matheusfsantos.hrworker.model.service;

import java.util.List;
import java.util.UUID;

public interface HrWorkersService<DTO> {
	
	public List<DTO> findAll();
	public DTO findById(UUID id);
	public void create(DTO dtoClass);
	public void update(DTO dtoClass, UUID id);
	public void delete(UUID id);
	
}
