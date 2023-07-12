package com.junior.atendimento.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customer_service")
@Data
public class CustomerServiceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDate dataOpen;
	
	private LocalTime timeOpen;
	
	private String problem;
	
	private String solution;
	
	@ManyToOne
	@JsonBackReference
	private ClientEntity client;
	
	
}
