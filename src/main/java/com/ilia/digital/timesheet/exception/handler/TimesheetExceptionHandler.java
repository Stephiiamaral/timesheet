package com.ilia.digital.timesheet.exception.handler;


import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ilia.digital.timesheet.model.Message;
import com.ilia.digital.timesheet.enums.*;
import com.ilia.digital.timesheet.exception.ConflictException;
import com.ilia.digital.timesheet.exception.ReportNotFoundException;
import com.ilia.digital.timesheet.exception.WorkTimeException;
import com.ilia.digital.timesheet.service.MessageService;

@ControllerAdvice
public class TimesheetExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageService messageService;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Message message = messageService.findByMensageType(MessageType.INVALID_FIELD);		
		return handleExceptionInternal(ex, message, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({DateTimeParseException.class})
	public ResponseEntity<Object> handleDateTimeParseException(DateTimeParseException ex, WebRequest request) {
		Message message = messageService.findByMensageType(MessageType.INVALID_DATE);		
		return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ConflictException.class})
	public ResponseEntity<Object> handleDateTimeParseException(ConflictException ex, WebRequest request) {
		Message message = messageService.findByMensageType(MessageType.DATE_CONFLICT);		
		return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	
	@ExceptionHandler({WorkTimeException.class})
	public ResponseEntity<Object> handleDateTimeParseException(WorkTimeException ex, WebRequest request) {
		Message message = messageService.findByMensageType(MessageType.TIME_GREATER_THAN_THE_TIME_WORKED);		
		return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({ReportNotFoundException.class})
	public ResponseEntity<Object> handleDateTimeParseException(ReportNotFoundException ex, WebRequest request) {
		Message message = messageService.findByMensageType(MessageType.REPORT_NOT_FOUND);		
		return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
