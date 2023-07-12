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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.junior.atendimento.entity.ClientEntity;
import com.junior.atendimento.service.ClientService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class ClienteController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping(value = "client", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> getAllClient() {
		try {
			Iterable<ClientEntity> list = clientService.getAll();
			if(list != null) {
				return ResponseEntity.ok().body(this.convertObjectToJson(list));
			}			
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Client get All Error!");
	}
	
	@GetMapping(value = "client/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> getClientById(@PathVariable Integer id) {
		try {
			Optional<ClientEntity> opt = clientService.getById(id);
			if(opt.isPresent()) {
				return ResponseEntity.ok().body(this.convertObjectToJson(opt.get()));
			}
		}catch (Exception e) {
			log.error(e);
		}
		return ResponseEntity.badRequest().body("Client find by ID Error!");
	}
	
	@PostMapping(value ="client" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveClient(@RequestBody ClientEntity client){
		try {
			ClientEntity save = clientService.save(client);
			if(save != null) {
				return ResponseEntity.ok().body(this.convertObjectToJson(save));
			}
		}catch (Exception e) {
			log.error(e);
		}
		return ResponseEntity.badRequest().body("Save Client Error!");
	}
	
	@PutMapping(value = "client", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateClient(@RequestBody ClientEntity client){
		try {
			ClientEntity update = clientService.update(client);
			if(update != null) {
				return ResponseEntity.ok(this.convertObjectToJson(update));
			}
		}catch (Exception e) {
			log.error(e);
		}
		return ResponseEntity.badRequest().body("Update Client Error!");
	}
	
	@DeleteMapping(value = "client", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteClient(@RequestBody ClientEntity client){
		try {
			clientService.delete(client);
			return ResponseEntity.ok("Sucess");
		}catch (Exception e) {
			log.error(e);
		}
		return ResponseEntity.badRequest().body("Update Client Error!");
	}
	
	private String convertObjectToJson(Object o) throws JsonProcessingException {
		ObjectMapper mapper = JsonMapper.builder()
			    .addModule(new JavaTimeModule())
			    .build();
		String json = mapper.writeValueAsString(o);
		return json;
	}
}

