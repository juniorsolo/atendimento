package com.junior.atendimento.service;

import java.util.Optional;

import com.junior.atendimento.entity.Client;

public interface ClientService {
	
	Iterable<Client> getAll();
	Optional<Client>  getById(Integer id);
    Client save(Client client);
	
}
