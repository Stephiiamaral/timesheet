package com.ilia.digital.timesheet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ilia.digital.timesheet.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
	Optional<Report> findByMonth(String month);
}
