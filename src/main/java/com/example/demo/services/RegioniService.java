package com.example.demo.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.entity.Cliente;
import com.example.database.entity.Regione;
import com.example.demo.repositories.ClientiRepository;
import com.example.demo.repositories.RegioniRepository;

@Service
public class RegioniService {

	private static final Logger log = LogManager.getLogger();
	
	@Autowired RegioniRepository repository;
	
	public List<Regione> getRegioni(){
		return repository.findAll();
	}
	
}
