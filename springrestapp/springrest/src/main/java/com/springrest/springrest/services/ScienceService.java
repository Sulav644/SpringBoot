package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.payloads.ScienceDto;

public interface ScienceService {
	
	ScienceDto createScience(ScienceDto scienceDto);
	List<ScienceDto> getScience();
	void deleteScience(Integer scienceId);

}
