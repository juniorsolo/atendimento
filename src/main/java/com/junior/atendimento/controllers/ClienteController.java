package com.junior.atendimento.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	
	@GetMapping("client")
	public String getClient() {
		return "return client";
	}
}
