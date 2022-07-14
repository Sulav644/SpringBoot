package com.springrest.springrest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Science;
import com.springrest.springrest.payloads.ScienceDto;
import com.springrest.springrest.repositories.ScienceRepo;
import com.springrest.springrest.services.ScienceService;

@Service
public class ScienceServiceImpl implements ScienceService {
	
	@Autowired
	private ScienceRepo scienceRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ScienceDto createScience(ScienceDto scienceDto) {
		Science science = this.modelMapper.map(scienceDto, Science.class);
		Science savedscience = this.scienceRepo.save(science);
		return this.modelMapper.map(savedscience, ScienceDto.class);
	}

	@Override
	public List<ScienceDto> getScience() {
		List<Science> sciences = this.scienceRepo.findAll();
		List<ScienceDto> scienceDtos = sciences.stream().map((science)-> this.modelMapper.map(science, ScienceDto.class)).collect(Collectors.toList());
		return scienceDtos;
	}

	@Override
	public void deleteScience(Integer scienceId) {
		Science science = this.scienceRepo.findById(scienceId).orElseThrow();
		this.scienceRepo.delete(science);
	}

	

}
