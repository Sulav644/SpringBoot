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

import com.springrest.springrest.payloads.PhotographyDto;
import com.springrest.springrest.services.PhotographyService;


@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000")
public class PhotographyController {

	@Autowired
	private PhotographyService photographyService;

	@PostMapping("/photography")
	private ResponseEntity<PhotographyDto> createPhotography(@Valid @RequestBody PhotographyDto photographyDto) {
		PhotographyDto createphotography = this.photographyService.createPhotography(photographyDto);
		return new ResponseEntity<PhotographyDto>(createphotography, HttpStatus.CREATED);
	}

	@GetMapping("/photography")
	private ResponseEntity<List<PhotographyDto>> getPhotography() {
		List<PhotographyDto> photographys = this.photographyService.getPhotography();
		return new ResponseEntity<List<PhotographyDto>>(photographys, HttpStatus.OK);
	}

	
	@DeleteMapping("/photography/{photographyId}")
	private void deletePhotography(@PathVariable Integer photographyId) {
		this.photographyService.deletePhotography(photographyId);
	}

}
