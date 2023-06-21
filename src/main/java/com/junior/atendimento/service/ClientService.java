package com.junior.atendimento.service;

import java.util.List;

import com.junior.atendimento.entity.Client;

public interface ClientService {
	
	List<Client> getAll();
	Client  getById(Integer id);
	
}
