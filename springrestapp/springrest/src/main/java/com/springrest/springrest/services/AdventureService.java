package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.payloads.AdventureDto;

public interface AdventureService {
	
	AdventureDto createAdventure(AdventureDto adventureDto);
	List<AdventureDto> getAdventure();
	void deleteAdventure(Integer adventureId);

}
