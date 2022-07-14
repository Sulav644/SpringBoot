package com.springrest.springrest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Adventure;
import com.springrest.springrest.payloads.AdventureDto;
import com.springrest.springrest.repositories.AdventureRepo;
import com.springrest.springrest.services.AdventureService;

@Service
public class AdventureServiceImpl implements AdventureService {
	
	@Autowired
	private AdventureRepo adventureRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public AdventureDto createAdventure(AdventureDto adventureDto) {
		Adventure adventure = this.modelMapper.map(adventureDto, Adventure.class);
		Adventure savedadventure = this.adventureRepo.save(adventure);
		return this.modelMapper.map(savedadventure, AdventureDto.class);
	}

	@Override
	public List<AdventureDto> getAdventure() {
		List<Adventure> adventures = this.adventureRepo.findAll();
		List<AdventureDto> adventureDtos = adventures.stream().map((adventure)-> this.modelMapper.map(adventure, AdventureDto.class)).collect(Collectors.toList());
		return adventureDtos;
	}

	@Override
	public void deleteAdventure(Integer adventureId) {
		Adventure adventure = this.adventureRepo.findById(adventureId).orElseThrow();
		this.adventureRepo.delete(adventure);
	}

	

}
