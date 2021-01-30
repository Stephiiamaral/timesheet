package com.ilia.digital.timesheet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilia.digital.timesheet.model.Registry;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Integer> {

	Optional<Registry> findByDay(String day);
	
}
