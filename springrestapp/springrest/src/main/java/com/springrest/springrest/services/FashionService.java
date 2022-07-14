package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.payloads.FashionDto;

public interface FashionService {
	
	FashionDto createFashion(FashionDto fashionDto);
	List<FashionDto> getFashion();
	void deleteFashion(Integer fashionId);

}
