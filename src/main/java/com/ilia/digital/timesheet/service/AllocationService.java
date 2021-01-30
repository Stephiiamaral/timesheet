package com.ilia.digital.timesheet.service;

import java.time.Duration;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilia.digital.timesheet.exception.WorkTimeException;
import com.ilia.digital.timesheet.model.Allocation;
import com.ilia.digital.timesheet.repository.AllocationRepository;

@Service
public class AllocationService {

	@Autowired
	private AllocationRepository repository;

	@Transactional
	public Allocation insert(Allocation allocation) {
		if (isGreatedThanTheTimeWorked(allocation.getTime())) {
			throw new WorkTimeException("Greater than the time worked in the day");
		}
		
		//valid format
		LocalDate.parse(allocation.getDay());
		
		return repository.save(allocation);
	}
	
	private Boolean isGreatedThanTheTimeWorked(String inputDuration) {
		Duration duration = Duration.parse(inputDuration);
		//8 hours = 28800000 ms
		return duration.toMillis() > 28800000;
	}
	
}
