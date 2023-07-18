package com.junior.atendimento.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.junior.atendimento.entity.ClientEntity;
import com.junior.atendimento.entity.CustomerServiceEntity;
import com.junior.atendimento.service.CustomerService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "customer" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<CustomerServiceEntity> save(@RequestBody CustomerServiceEntity customerEntity){
		try {
			CustomerServiceEntity saved = customerService.save(customerEntity);
			return ResponseEntity.ok().body(saved);
		}catch (Exception e) {
			log.error(e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping(value = "customer",  produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> getAllCustomer() {
		try {
			List<CustomerServiceEntity> list = customerService.getAll();
			
			if(list != null) {
				return ResponseEntity.ok().body(this.convertObjectToJson(list));
			}			
		}catch (Exception e) {
			log.error(e.getMessage());
		}
		return ResponseEntity.badRequest().body(null);
	}
	
	@GetMapping(value = "customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> getCustomerById(@PathVariable Integer id) {
		try {
			Optional<CustomerServiceEntity> opt = customerService.getById(id);
			if(opt.isPresent()) {
				return ResponseEntity.ok().body(this.convertObjectToJson(opt.get()));
			}
		}catch (Exception e) {
			log.error(e);
		}
		return ResponseEntity.badRequest().body("Client find by ID Error!");
	}
	
	private String convertObjectToJson(Object o) throws JsonProcessingException {
		ObjectMapper mapper = JsonMapper.builder()
			    .addModule(new JavaTimeModule())
			    .build();
		String json = mapper.writeValueAsString(o);
		return json;
	}
}
