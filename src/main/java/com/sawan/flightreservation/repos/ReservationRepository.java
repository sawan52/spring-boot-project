package com.sawan.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawan.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
