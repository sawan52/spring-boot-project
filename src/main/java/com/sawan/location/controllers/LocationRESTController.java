package com.sawan.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sawan.location.entities.Location;
import com.sawan.location.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

	@Autowired
	private LocationRepository repository;

	@GetMapping
	public List<Location> getAllLocations() {
		return repository.findAll();
	}

}
