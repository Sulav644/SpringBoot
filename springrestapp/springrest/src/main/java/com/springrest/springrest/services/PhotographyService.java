package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.payloads.PhotographyDto;

public interface PhotographyService {
	
	PhotographyDto createPhotography(PhotographyDto photographyDto);
	List<PhotographyDto> getPhotography();
	void deletePhotography(Integer photographyId);

}
