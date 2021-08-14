package com.sawan.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sawan.flightreservation.dto.ReservationUpdateRequest;
import com.sawan.flightreservation.entities.Reservation;
import com.sawan.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	private ReservationRepository reservationRepository;

	@RequestMapping("/reservations/{reservationId}")
	public Reservation findReservation(@PathVariable("reservationId") Long reservationId) {
		return reservationRepository.findById(reservationId).get();
	}

	@RequestMapping(value = "/reservations", method = RequestMethod.POST)
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationRepository.save(reservation);
	}

}
