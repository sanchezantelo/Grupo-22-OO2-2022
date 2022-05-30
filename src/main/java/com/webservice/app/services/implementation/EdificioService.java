package com.webservice.app.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.repositories.IEdificioRepository;


@Service("edificioService")
public class EdificioService {
	
	@Autowired
	@Qualifier("edificioRepository")
	private IEdificioRepository edificioRepository;
	
	
}
