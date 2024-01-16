package io.github.matheusfsantos.hruser.model.service;

public interface HrUserService<ResponseDTO> {
	
	public ResponseDTO findById(Long id);
	public ResponseDTO search(String email);
	
}
