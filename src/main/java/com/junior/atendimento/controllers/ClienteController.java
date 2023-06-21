package com.junior.atendimento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junior.atendimento.service.ClientService;

@RestController
public class ClienteController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping("client")
	public String getClient() {
		clientService.getAll();
		return "return client";
	}
}
