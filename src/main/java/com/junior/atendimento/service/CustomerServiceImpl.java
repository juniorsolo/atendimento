package com.junior.atendimento.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junior.atendimento.entity.CustomerServiceEntity;
import com.junior.atendimento.repository.CustomerServiceRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerServiceRepository customerServRepo;
	
	@Override
	public List<CustomerServiceEntity> getAll() throws ServiceException {
		try {
			return customerServRepo.findAll();
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}

	@Override
	public Optional<CustomerServiceEntity> getById(Integer id) throws ServiceException {
		try {
			return customerServRepo.findById(id);
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}

	@Override
	public CustomerServiceEntity save(CustomerServiceEntity customer) throws ServiceException {
		try {
			customer.setDataOpen(LocalDateTime.now().toLocalDate());
			customer.setTimeOpen(LocalTime.now());
			return customerServRepo.save(customer);
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}

	@Override
	public CustomerServiceEntity update(CustomerServiceEntity customer) throws ServiceException {
		try {
			if(customer != null && customer.getId() != null 
			  && customerServRepo.existsById(customer.getId())) {
				return customerServRepo.save(customer);
			}
			throw new Exception("Customer not found, unable to update.");
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}

	@Override
	public void delete(CustomerServiceEntity customer) throws ServiceException {
		try {
			if(customer != null && customer.getId() != null 
			  && customerServRepo.existsById(customer.getId())) {
				customerServRepo.delete(customer);
				return;
			}
			throw new Exception("Client not found, unable delete.");
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
		
	}

}
