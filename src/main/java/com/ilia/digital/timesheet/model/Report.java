package com.ilia.digital.timesheet.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class Report {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String month;
	
	@Column(name = "worked_hours")
	private String workedHours;
	
	@Column(name = "exceeding_hours")
	private String exceedingHours;
	
	@Column(name = "required_time")
	private String requiredTime;
	
	@OneToMany
	private List<Registry> records;	

}
