package com.junior.atendimento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.atendimento.entity.Client;
import com.junior.atendimento.repository.ClientRepository;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepository repository;
	
	@Override
	public List<Client> getAll() throws ServiceException {
		try {
			return repository.findAll();
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}

	@Override
	public Optional<Client> getById(Integer id) throws ServiceException{
		try {
			return repository.findById(id);
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}
	
	@Override
	public Client save(Client client) throws ServiceException{
		try {
			return repository.save(client);
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}
	
	@Override
	public Client update(Client client) throws ServiceException{
		try {
			if(client != null && client.getId() != null 
			  && repository.existsById(client.getId())) {
				return repository.save(client);
			}
			throw new Exception("Client not found, unable to update.");
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}
	
}
