package com.ilia.digital.timesheet.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilia.digital.timesheet.exception.ReportNotFoundException;
import com.ilia.digital.timesheet.model.Registry;
import com.ilia.digital.timesheet.model.Report;
import com.ilia.digital.timesheet.repository.ReportRepository;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository repository;

	@Transactional
	public Report generateReport(Registry registry) {
		String month = registry.getDay().substring(0, 7);
		Report report = repository.findByMonth(month).orElse(new Report());
		
		if (report.getId() == null) {
			report.setMonth(month);
			report.setRecords(new ArrayList<>());
//			report.setExceedingHours();
//			report.setWorkedHours();
//			report.setRequiredTime();
			report.getRecords().add(registry);
		}else {			
			if (!report.getRecords().contains(registry)) {
				report.getRecords().add(registry);
			}
		}
		
		return repository.save(report);
	}

	public Report getReport(String month) {
		Report report = repository.findByMonth(month).orElseThrow(() -> new ReportNotFoundException("Report not found"));
		return report;
	}

}
