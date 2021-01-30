package com.ilia.digital.timesheet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilia.digital.timesheet.model.Allocation;
import com.ilia.digital.timesheet.service.AllocationService;

@RestController
@RequestMapping(path = "/v1/alocacoes")
public class AllocationController {
	
	@Autowired
	private AllocationService service;

	@PostMapping
	public ResponseEntity<Allocation> insert(@Valid @RequestBody Allocation allocation){
		Allocation allocationSaved = service.insert(allocation);
		return ResponseEntity.status(HttpStatus.CREATED).body(allocationSaved);
	}
	
}
