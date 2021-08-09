package com.sawan.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawan.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
