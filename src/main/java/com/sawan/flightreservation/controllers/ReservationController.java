package com.sawan.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sawan.flightreservation.dto.ReservationRequest;
import com.sawan.flightreservation.entities.Flight;
import com.sawan.flightreservation.entities.Reservation;
import com.sawan.flightreservation.repos.FlightRepository;
import com.sawan.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation flightBooked = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Flight Booked successfully and ID is: " + flightBooked.getId());
		return "reservationConfirmation";
	}

}
