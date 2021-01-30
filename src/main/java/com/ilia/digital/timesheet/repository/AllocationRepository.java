package com.ilia.digital.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ilia.digital.timesheet.model.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Integer> {

}
