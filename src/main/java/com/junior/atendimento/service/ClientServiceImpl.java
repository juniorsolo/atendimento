package com.junior.atendimento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.atendimento.entity.Client;
import com.junior.atendimento.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepository repository;
	
	@Override
	public List<Client> getAll() {
		try {
		System.out.println("chamouuu service!!!!");
		return repository.findAll();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Optional<Client> getById(Integer id) {
		return repository.findById(id);
	}
	
	@Override
	public Client save(Client client) {
		return repository.save(client);
	}
	
}
