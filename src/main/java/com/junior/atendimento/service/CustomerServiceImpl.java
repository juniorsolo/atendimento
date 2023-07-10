package com.junior.atendimento.service;

import java.time.LocalDateTime;
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
	public Iterable<CustomerServiceEntity> getAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CustomerServiceEntity> getById(Integer id) throws ServiceException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public CustomerServiceEntity save(CustomerServiceEntity customer) throws ServiceException {
		try {
			customer.setDataTime(LocalDateTime.now());
			return customerServRepo.save(customer);
		}catch (Exception e) {
			log.error(e);
			throw new ServiceException(e);
		}
	}

	@Override
	public CustomerServiceEntity update(CustomerServiceEntity customer) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CustomerServiceEntity customer) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

}
