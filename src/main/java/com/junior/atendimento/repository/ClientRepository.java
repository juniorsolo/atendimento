package com.junior.atendimento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.junior.atendimento.entity.ClientEntity;

public interface ClientRepository extends CrudRepository<ClientEntity, Integer>{
	List<ClientEntity> findAll();
}
