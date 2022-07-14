package com.springrest.springrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.payloads.TravelDto;
import com.springrest.springrest.services.TravelService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000")
public class TravelController {

	@Autowired
	private TravelService travelService;

	@PostMapping("/travel")
	private ResponseEntity<TravelDto> createTravel(@Valid @RequestBody TravelDto travelDto) {
		TravelDto createtravel = this.travelService.createTravel(travelDto);
		return new ResponseEntity<TravelDto>(createtravel, HttpStatus.CREATED);
	}

	@GetMapping("/travel")
	private ResponseEntity<List<TravelDto>> getTravel() {
		List<TravelDto> travels = this.travelService.getTravel();
		return new ResponseEntity<List<TravelDto>>(travels, HttpStatus.OK);
	}

	
	@DeleteMapping("/travel/{travelId}")
	private void deleteTravel(@PathVariable Integer travelId) {
		this.travelService.deleteTravel(travelId);
	}

}
