package com.sawan.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawan.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
