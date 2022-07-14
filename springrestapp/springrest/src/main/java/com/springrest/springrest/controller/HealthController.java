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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.payloads.HealthDto;
import com.springrest.springrest.services.HealthService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins="http://localhost:3000")
public class HealthController {

	@Autowired
	private HealthService healthService;

	@PostMapping("/health")
	private ResponseEntity<HealthDto> createhealth(@Valid @RequestBody HealthDto healthDto) {
		HealthDto createhealth = this.healthService.createHealth(healthDto);
		return new ResponseEntity<HealthDto>(createhealth, HttpStatus.CREATED);
	}

	@GetMapping("/health")
	private ResponseEntity<List<HealthDto>> getHealth() {
		List<HealthDto> healths = this.healthService.getHealth();
		return new ResponseEntity<List<HealthDto>>(healths, HttpStatus.OK);
	}

	
	@DeleteMapping("/health/{healthId}")
	private void deletehealth(@PathVariable Integer healthId) {
		this.healthService.deleteHealth(healthId);
	}

}
