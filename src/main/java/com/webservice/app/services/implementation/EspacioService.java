package com.webservice.app.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.webservice.app.repositories.IEspacioRepository;


@Service("espacioService")
public class EspacioService {

	@Autowired
	@Qualifier("espacioRepository")
	private IEspacioRepository espacioRepository;
	
}
