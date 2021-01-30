package com.ilia.digital.timesheet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilia.digital.timesheet.model.Message;
import com.ilia.digital.timesheet.enums.*;
import com.ilia.digital.timesheet.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository repository;

	public Message findByMensageType(MessageType messageType) {
		return repository.findById(messageType.getCode()).orElse(new Message(0, "Não foi possivel realizar a ação"));
	}
	
}
