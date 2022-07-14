package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.payloads.HealthDto;

public interface HealthService {
	
	HealthDto createHealth(HealthDto healthDto);
	List<HealthDto> getHealth();
	void deleteHealth(Integer healthId);

}
