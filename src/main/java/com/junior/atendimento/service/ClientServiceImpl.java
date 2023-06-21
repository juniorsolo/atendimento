package com.junior.atendimento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.junior.atendimento.entity.Client;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService{
	
	@Override
	public List<Client> getAll() {
		System.out.println("chamouuu service!!!!");
		return null;
	}

	@Override
	public Client getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
