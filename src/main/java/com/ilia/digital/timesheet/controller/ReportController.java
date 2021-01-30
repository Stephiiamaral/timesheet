package com.ilia.digital.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilia.digital.timesheet.model.Report;
import com.ilia.digital.timesheet.service.ReportService;

@RestController
@RequestMapping(path = "/v1/folhas-de-ponto")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping(path = "/{month}")
	public ResponseEntity<Report> generateReport(@PathVariable(required = true) String month){	
		Report report = reportService.getReport(month);
		return ResponseEntity.ok(report);
	}

}
