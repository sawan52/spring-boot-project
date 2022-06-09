package com.sawan.flightreservation.services.impl;

import com.sawan.flightreservation.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sawan.flightreservation.dto.ReservationRequest;
import com.sawan.flightreservation.entities.Flight;
import com.sawan.flightreservation.entities.Passenger;
import com.sawan.flightreservation.entities.Reservation;
import com.sawan.flightreservation.repos.FlightRepository;
import com.sawan.flightreservation.repos.PassengerRepository;
import com.sawan.flightreservation.repos.ReservationRepository;
import com.sawan.flightreservation.util.EmailUtil;
import com.sawan.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${com.sawan.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private PDFGenerator pdfGenerator;

	@Autowired
	private EmailUtil emailUtil;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {

		LOGGER.info("Inside bookFlight()");
		// Make Payment

		Long flightId = request.getFlightId();

		LOGGER.info("Fetching  flight for flight id:" + flightId);

		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());

		LOGGER.info("Saving the passenger:" + passenger);

		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);

		LOGGER.info("Saving the reservation:" + reservation);

		Reservation savedReservation = reservationRepository.save(reservation);

		String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";

		LOGGER.info("Generating the Itinerary" + filePath);

		pdfGenerator.generateItinerary(savedReservation, filePath);

		LOGGER.info("Emailing the Itinerary");

		emailUtil.sendItinerary(passenger.getEmail(), filePath);

		return savedReservation;
	}
}
