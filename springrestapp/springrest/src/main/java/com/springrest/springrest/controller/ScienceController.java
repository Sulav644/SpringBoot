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

import com.springrest.springrest.payloads.ScienceDto;
import com.springrest.springrest.services.ScienceService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000")
public class ScienceController {

	@Autowired
	private ScienceService scienceService;

	@PostMapping("/science")
	private ResponseEntity<ScienceDto> createScience(@Valid @RequestBody ScienceDto scienceDto) {
		ScienceDto createscience = this.scienceService.createScience(scienceDto);
		return new ResponseEntity<ScienceDto>(createscience, HttpStatus.CREATED);
	}

	@GetMapping("/science")
	private ResponseEntity<List<ScienceDto>> getScience() {
		List<ScienceDto> sciences = this.scienceService.getScience();
		return new ResponseEntity<List<ScienceDto>>(sciences, HttpStatus.OK);
	}

	
	@DeleteMapping("/science/{scienceId}")
	private void deleteScience(@PathVariable Integer scienceId) {
		this.scienceService.deleteScience(scienceId);
	}

}
