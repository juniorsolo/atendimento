package com.junior.atendimento.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.junior.atendimento.entity.Client;
import com.junior.atendimento.service.ClientService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class ClienteController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping(value = "client", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> getClient() {
		try {
			Iterable<Client> list = clientService.getAll();
			if(list != null) {
				return ResponseEntity.ok().body(this.convertObjetToJson(list));
			}			
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Client get All Error!");
	}
	
	@GetMapping(value = "client/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> getClientById(@PathVariable Integer id) {
		try {
			Optional<Client> opt = clientService.getById(id);
			if(opt.isPresent()) {
				return ResponseEntity.ok().body(this.convertObjetToJson(opt.get()));
			}
		}catch (Exception e) {
			log.error(e);
		}
		return ResponseEntity.badRequest().body("Client find by ID Error!");
	}
	
	@PostMapping(value ="client" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveClient(@RequestBody Client client){
		try {
			Client save = clientService.save(client);
			if(save != null) {
				return ResponseEntity.ok().body(this.convertObjetToJson(save));
			}
		}catch (Exception e) {
			log.error(e);
		}
		return ResponseEntity.badRequest().body("Save Client Error!");
	}
	
	@PutMapping(value = "client", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateClient(@RequestBody Client client){
		try {
			Client update = clientService.update(client);
			if(update != null) {
				return ResponseEntity.ok(this.convertObjetToJson(update));
			}
		}catch (Exception e) {
			log.error(e);
		}
		return ResponseEntity.badRequest().body("Update Client Error!");
	}
	
	@DeleteMapping(value = "client", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteClient(@RequestBody Client client){
		try {
			clientService.delete(client);
			return ResponseEntity.ok("Sucess");
		}catch (Exception e) {
			log.error(e);
		}
		return ResponseEntity.badRequest().body("Update Client Error!");
	}
	
	private String convertObjetToJson(Object o) {
		Gson gson = new Gson();
		String json = gson.toJson(o);
		return json;
	}
}

