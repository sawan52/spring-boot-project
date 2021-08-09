package com.sawan.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawan.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
