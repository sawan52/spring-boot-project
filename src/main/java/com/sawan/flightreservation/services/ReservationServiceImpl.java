package com.sawan.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawan.flightreservation.dto.ReservationRequest;
import com.sawan.flightreservation.entities.Flight;
import com.sawan.flightreservation.entities.Passenger;
import com.sawan.flightreservation.entities.Reservation;
import com.sawan.flightreservation.repos.FlightRepository;
import com.sawan.flightreservation.repos.PassengerRepository;
import com.sawan.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {

		// TODO: Make Payment

		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());

		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		// reservation.setNumberOfBags(0);
		// reservation.setCreated(null);

		Reservation savedReservation = reservationRepository.save(reservation);

		return savedReservation;
	}

}
