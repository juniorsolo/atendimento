package com.junior.atendimento.service;

import java.util.Optional;

import com.junior.atendimento.entity.Client;

public interface ClientService {
	
	Iterable<Client> getAll() throws ServiceException;
	Optional<Client>  getById(Integer id) throws ServiceException;
    Client save(Client client) throws ServiceException;
    Client update(Client client) throws ServiceException;
	
}
