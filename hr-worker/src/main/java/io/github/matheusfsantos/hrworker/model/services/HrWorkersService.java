package io.github.matheusfsantos.hrworker.model.services;

import java.util.List;
import java.util.UUID;

public interface HrWorkersService<RequestDTO, ResponseDTO> {
	
	public List<ResponseDTO> findAll();
	public ResponseDTO findById(UUID id);
	public void create(RequestDTO dtoClass);
	public void update(RequestDTO dtoClass, UUID id);
	public void delete(UUID id);
	
}
