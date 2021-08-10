package com.sawan.flightcheckin.integration;

import com.sawan.flightcheckin.integration.dto.Reservation;
import com.sawan.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);

}
