package com.junior.atendimento.repository;

import org.springframework.data.repository.CrudRepository;

import com.junior.atendimento.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{

}
