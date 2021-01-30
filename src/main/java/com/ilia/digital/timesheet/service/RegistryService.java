package com.ilia.digital.timesheet.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilia.digital.timesheet.exception.ConflictException;
import com.ilia.digital.timesheet.model.Moment;
import com.ilia.digital.timesheet.model.Registry;
import com.ilia.digital.timesheet.repository.RegistryRepository;

@Service
public class RegistryService {
	
	@Autowired
	private RegistryRepository repository;
	
	@Autowired
	private ReportService reportService;

	@Transactional
	public Registry insert(Moment moment) {
		LocalDateTime dayTime = LocalDateTime.parse(moment.getDateTime());
		
		LocalDate day = dayTime.toLocalDate();
		LocalTime time = dayTime.toLocalTime();		

		Registry registry = repository.findByDay(day.toString()).orElse(new Registry());
		
		if (registry.getId() == null) {
			registry.setDay(day.toString());
			registry.setSchedules(new ArrayList<>());
		}
		
		if(registry.getSchedules().contains(time.toString())) {
			throw new ConflictException("Horários já registrado");
		}
		
		registry.getSchedules().add(time.toString());
		
		Registry registrySaved = repository.save(registry);
		reportService.generateReport(registry);
		
		return registrySaved;
	}

}
