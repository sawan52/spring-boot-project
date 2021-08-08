package com.sawan.location.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sawan.location.entities.Location;
import com.sawan.location.service.LocationService;

@Controller
public class LocationController {

	@Autowired
	private LocationService service;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location savedLocation = service.saveLocation(location);
		String msg = "Location saved with id: " + savedLocation.getId();
		modelMap.addAttribute("msg", msg);
		return "createLocation";
	}

}
