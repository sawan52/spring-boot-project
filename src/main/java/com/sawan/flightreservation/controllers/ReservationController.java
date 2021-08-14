package com.sawan.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {

		LOGGER.info("showCompleteReservation() invoked with the Flight Id: " + flightId);

		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);

		LOGGER.info("Flight is:" + flight);

		return "completeReservation";

	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {

		LOGGER.info("completeReservation()  " + request);

		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation done successfully and the ID is " + reservation.getId());
		return "reservationConfirmation";

	}

}
