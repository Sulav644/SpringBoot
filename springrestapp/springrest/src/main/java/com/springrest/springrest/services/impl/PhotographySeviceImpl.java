package com.springrest.springrest.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Photography;
import com.springrest.springrest.payloads.PhotographyDto;
import com.springrest.springrest.repositories.PhotographyRepo;
import com.springrest.springrest.services.PhotographyService;

@Service
public class PhotographySeviceImpl implements PhotographyService {
	
	@Autowired
	private PhotographyRepo photographyRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PhotographyDto createPhotography(PhotographyDto photographyDto) {
		Photography photography = this.modelMapper.map(photographyDto, Photography.class);
		Photography savedphotography = this.photographyRepo.save(photography);
		return this.modelMapper.map(savedphotography, PhotographyDto.class);
	}

	@Override
	public List<PhotographyDto> getPhotography() {
		List<Photography> photographys = this.photographyRepo.findAll();
		List<PhotographyDto> photographyDtos = photographys.stream().map((photography)-> this.modelMapper.map(photography, PhotographyDto.class)).collect(Collectors.toList());
		return photographyDtos;
	}

	@Override
	public void deletePhotography(Integer photographyId) {
		Photography photography = this.photographyRepo.findById(photographyId).orElseThrow();
		this.photographyRepo.delete(photography);
	}

	

}
