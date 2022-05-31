package com.webservice.app.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.repositories.IEspacioRepository;
import com.webservice.app.services.IEspacioService;


@Service("espacioService")
public class EspacioService implements IEspacioService{

	@Autowired
	@Qualifier("espacioRepository")
	private IEspacioRepository espacioRepository;
	
}
