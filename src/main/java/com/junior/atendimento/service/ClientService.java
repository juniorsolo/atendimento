package com.junior.atendimento.service;

import java.util.Optional;

import com.junior.atendimento.entity.ClientEntity;

public interface ClientService {
	
	Iterable<ClientEntity> getAll() throws ServiceException;
	Optional<ClientEntity>  getById(Integer id) throws ServiceException;
    ClientEntity save(ClientEntity client) throws ServiceException;
    ClientEntity update(ClientEntity client) throws ServiceException;
    void delete(ClientEntity client) throws ServiceException;
	
}
