package com.ilia.digital.timesheet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ilia.digital.timesheet.model.Moment;
import com.ilia.digital.timesheet.model.Registry;
import com.ilia.digital.timesheet.service.RegistryService;

@RestController
@RequestMapping(path = "/v1/batidas")
public class RegistryController {
	
	@Autowired
	private RegistryService service;
	
	@PostMapping
	public ResponseEntity<Registry> insert(@Valid @RequestBody Moment moment) {
		Registry registry = service.insert(moment);
		return ResponseEntity.status(HttpStatus.CREATED).body(registry);
	}
	
}
