package com.sawan.flightreservation.services;

import com.sawan.flightreservation.dto.ReservationRequest;
import com.sawan.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);

}
