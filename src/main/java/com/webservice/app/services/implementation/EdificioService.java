package com.webservice.app.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.repositories.IEdificioRepository;
import com.webservice.app.services.IEdificioService;


@Service("edificioService")
public class EdificioService implements IEdificioService{
	
	@Autowired
	@Qualifier("edificioRepository")
	private IEdificioRepository edificioRepository;
	
	
}
