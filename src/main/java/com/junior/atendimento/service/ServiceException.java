package com.junior.atendimento.service;

public class ServiceException extends Exception{

	private static final long serialVersionUID = -1002694315145218650L;
	
	ServiceException(Exception e){
		super(e);	
	}
}
