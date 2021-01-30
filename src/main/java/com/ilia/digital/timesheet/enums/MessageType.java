package com.ilia.digital.timesheet.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageType {
	
	INVALID_DATE(1),
	INVALID_FIELD(2),
	FORBIDEN(3),
	DATE_CONFLICT(4),
	TIME_GREATER_THAN_THE_TIME_WORKED(5),
	REPORT_NOT_FOUND(6);
	
	private final int code;
}
