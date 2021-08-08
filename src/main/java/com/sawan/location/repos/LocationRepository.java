package com.sawan.location.repos;

import org.springframework.data.repository.CrudRepository;

import com.sawan.location.entities.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {

}
