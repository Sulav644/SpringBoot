package com.springrest.springrest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Travel;
import com.springrest.springrest.payloads.TravelDto;
import com.springrest.springrest.repositories.TravelRepo;
import com.springrest.springrest.services.TravelService;

@Service
public class TravelServiceImpl implements TravelService {
	
	@Autowired
	private TravelRepo travelRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public TravelDto createTravel(TravelDto travelDto) {
		Travel travel = this.modelMapper.map(travelDto, Travel.class);
		Travel savedtravel = this.travelRepo.save(travel);
		return this.modelMapper.map(savedtravel, TravelDto.class);
	}

	@Override
	public List<TravelDto> getTravel() {
		List<Travel> travels = this.travelRepo.findAll();
		List<TravelDto> travelDtos = travels.stream().map((travel)-> this.modelMapper.map(travel, TravelDto.class)).collect(Collectors.toList());
		return travelDtos;
	}

	@Override
	public void deleteTravel(Integer travelId) {
		Travel travel = this.travelRepo.findById(travelId).orElseThrow();
		this.travelRepo.delete(travel);
	}

	

}
