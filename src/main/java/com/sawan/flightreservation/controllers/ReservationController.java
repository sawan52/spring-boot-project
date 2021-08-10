package com.sawan.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sawan.flightreservation.entities.Flight;
import com.sawan.flightreservation.repos.FlightRepository;

@Controller
public class ReservationController {

	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}

}
