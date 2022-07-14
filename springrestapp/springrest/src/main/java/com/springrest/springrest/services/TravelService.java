package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.payloads.TravelDto;

public interface TravelService {
	
	TravelDto createTravel(TravelDto travelDto);
	List<TravelDto> getTravel();
	void deleteTravel(Integer travelId);

}
