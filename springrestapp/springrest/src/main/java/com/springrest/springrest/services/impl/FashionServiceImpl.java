package com.springrest.springrest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Fashion;
import com.springrest.springrest.payloads.FashionDto;
import com.springrest.springrest.repositories.FashionRepo;
import com.springrest.springrest.services.FashionService;

@Service
public class FashionServiceImpl implements FashionService {
	
	@Autowired
	private FashionRepo fashionRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public FashionDto createFashion(FashionDto fashionDto) {
		Fashion fashion = this.modelMapper.map(fashionDto, Fashion.class);
		Fashion savedfashion = this.fashionRepo.save(fashion);
		return this.modelMapper.map(savedfashion, FashionDto.class);
	}

	@Override
	public List<FashionDto> getFashion() {
		List<Fashion> fashions = this.fashionRepo.findAll();
		List<FashionDto> fashionDtos = fashions.stream().map((fashion)-> this.modelMapper.map(fashion, FashionDto.class)).collect(Collectors.toList());
		return fashionDtos;
	}

	@Override
	public void deleteFashion(Integer fashionId) {
		Fashion fashion = this.fashionRepo.findById(fashionId).orElseThrow();
		this.fashionRepo.delete(fashion);
	}

	

}
