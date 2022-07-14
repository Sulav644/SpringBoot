package com.springrest.springrest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Health;
import com.springrest.springrest.payloads.HealthDto;
import com.springrest.springrest.repositories.HealthRepo;
import com.springrest.springrest.services.HealthService;

@Service
public class HealthServiceImpl implements HealthService {
	
	@Autowired
	private HealthRepo healthRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public HealthDto createHealth(HealthDto healthDto) {
		Health health = this.modelMapper.map(healthDto, Health.class);
		Health savedhealth = this.healthRepo.save(health);
		return this.modelMapper.map(savedhealth, HealthDto.class);
	}

	@Override
	public List<HealthDto> getHealth() {
		List<Health> healths = this.healthRepo.findAll();
		List<HealthDto> healthDtos = healths.stream().map((health)-> this.modelMapper.map(health, HealthDto.class)).collect(Collectors.toList());
		return healthDtos;
	}

	@Override
	public void deleteHealth(Integer healthId) {
		Health health = this.healthRepo.findById(healthId).orElseThrow();
		this.healthRepo.delete(health);
	}

	

}
