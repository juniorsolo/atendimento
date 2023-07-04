package com.junior.atendimento.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.junior.atendimento.entity.Client;
import com.junior.atendimento.service.ClientService;

@RestController
public class ClienteController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping(value = "client", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> getClient() {

		Iterable<Client> list = clientService.getAll();
		if(list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			return ResponseEntity.ok().body(json);
		}
		return ResponseEntity.badRequest().body("Error");
	}
	
	@GetMapping(value = "client/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> getClientById(@PathVariable Integer id) {

		Optional<Client> optional = clientService.getById(id);
		if(optional.isPresent()) {
			Gson gson = new Gson();
			String json = gson.toJson(optional.get());
			return ResponseEntity.ok().body(json);
		}
		return ResponseEntity.badRequest().body("Error");
	}
}
