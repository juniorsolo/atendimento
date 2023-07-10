package com.junior.atendimento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.atendimento.entity.ClientEntity;
import com.junior.atendimento.repository.ClientRepository;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository repository;
	
	@Override
	public List<ClientEntity> getAll() throws ServiceException {
		try {
			return repository.findAll();
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}

	@Override
	public Optional<ClientEntity> getById(Integer id) throws ServiceException{
		try {
			return repository.findById(id);
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}
	
	@Override
	public ClientEntity save(ClientEntity client) throws ServiceException{
		try {
			return repository.save(client);
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}
	
	@Override
	public ClientEntity update(ClientEntity client) throws ServiceException{
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
	
	@Override
	public void delete(ClientEntity client) throws ServiceException{
		try {
			if(client != null && client.getId() != null 
			  && repository.existsById(client.getId())) {
				repository.delete(client);
				return;
			}
			throw new Exception("Client not found, unable delete.");
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}
}
