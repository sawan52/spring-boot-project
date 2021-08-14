package com.sawan.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawan.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
