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

import com.springrest.springrest.payloads.FashionDto;
import com.springrest.springrest.services.FashionService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000")
public class FashionController {

	@Autowired
	private FashionService fashionService;

	@PostMapping("/fashion")
	private ResponseEntity<FashionDto> createFashion(@Valid @RequestBody FashionDto fashionDto) {
		FashionDto createfashion = this.fashionService.createFashion(fashionDto);
		return new ResponseEntity<FashionDto>(createfashion, HttpStatus.CREATED);
	}

	@GetMapping("/fashion")
	private ResponseEntity<List<FashionDto>> getFashion() {
		List<FashionDto> fashions = this.fashionService.getFashion();
		return new ResponseEntity<List<FashionDto>>(fashions, HttpStatus.OK);
	}

	
	@DeleteMapping("/fashion/{fashionId}")
	private void deleteFashion(@PathVariable Integer fashionId) {
		this.fashionService.deleteFashion(fashionId);
	}

}
