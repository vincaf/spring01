package com.example.demo.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.entity.Cliente;
import com.example.demo.repositories.ClientiRepository;

@Service
public class ClientiService {

	private static final Logger log = LogManager.getLogger();
	
	@Autowired ClientiRepository repository;
	
	public Cliente save (Cliente cliente) {
		log.trace("Start del metodo save");
		cliente = repository.save(cliente);
		log.debug("Inserito cliente {}", cliente);
		return cliente;
	}
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
}
