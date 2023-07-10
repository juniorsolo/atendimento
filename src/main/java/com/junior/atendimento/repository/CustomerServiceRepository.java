package com.junior.atendimento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.junior.atendimento.entity.CustomerServiceEntity;

public interface CustomerServiceRepository extends CrudRepository<CustomerServiceEntity, Integer>{
	public List<CustomerServiceEntity> getAll();
}
