package io.github.matheusfsantos.hrworker.model.services;

import java.util.List;

public interface HrWorkersService<RequestDTO, ResponseDTO> {
	
	public List<ResponseDTO> findAll();
	public ResponseDTO findById(Long id);
	public void create(RequestDTO dtoClass);
	public void update(RequestDTO dtoClass, Long id);
	public void delete(Long id);
	
}
