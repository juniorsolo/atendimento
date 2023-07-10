package com.junior.atendimento.service;

import java.util.Optional;
import com.junior.atendimento.entity.CustomerServiceEntity;

public interface CustomerService {
	Iterable<CustomerServiceEntity> getAll() throws ServiceException;
	Optional<CustomerServiceEntity>  getById(Integer id) throws ServiceException;
	CustomerServiceEntity save(CustomerServiceEntity customer) throws ServiceException;
	CustomerServiceEntity update(CustomerServiceEntity customer) throws ServiceException;
    void delete(CustomerServiceEntity customer) throws ServiceException;
	
}
