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

import com.springrest.springrest.payloads.AdventureDto;
import com.springrest.springrest.services.AdventureService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000")
public class AdventureController {

	@Autowired
	private AdventureService adventureService;

	@PostMapping("/adventure")
	private ResponseEntity<AdventureDto> createAdventure(@Valid @RequestBody AdventureDto adventureDto) {
		AdventureDto createadventure = this.adventureService.createAdventure(adventureDto);
		return new ResponseEntity<AdventureDto>(createadventure, HttpStatus.CREATED);
	}

	@GetMapping("/adventure")
	private ResponseEntity<List<AdventureDto>> getAdventure() {
		List<AdventureDto> adventures = this.adventureService.getAdventure();
		return new ResponseEntity<List<AdventureDto>>(adventures, HttpStatus.OK);
	}

	
	@DeleteMapping("/adventure/{adventureId}")
	private void deleteAdventure(@PathVariable Integer adventureId) {
		this.adventureService.deleteAdventure(adventureId);
	}

}
