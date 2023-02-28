package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.database.entity.Cliente;
import com.example.demo.repositories.ClientiRepository;

@Service
public class ClientiService {

	private static final Logger log = LogManager.getLogger();
	
	@Autowired ClientiRepository repository;
	
	@Transactional
	public Cliente save (Cliente cliente) {
		log.trace("Start del metodo save");
		cliente = repository.save(cliente);
		log.debug("Inserito cliente {}", cliente);
		return cliente;
	}
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Optional<Cliente> findById(Integer id) {
		return repository.findById(id);
	}
	
	public long count() {
		return repository.count();
	}
	
	public void deleteById2(Integer id) {
        repository.deleteById(id);
    }
	
	@Transactional
	public Boolean update(Cliente cliente) {
		Optional<Cliente> clienteUp = this.findById(cliente.getIdCliente());		
		if (clienteUp.isEmpty()) {
			return false;
		}
		this.save(cliente);
		return true;
	}
	
	@Transactional
	public Integer deleteById(Integer id) {
		
		Optional<Cliente> cliente = this.findById(id);		
		if (cliente.isEmpty()) {
			return -1;
		}
		
		repository.deleteById(id);
		//vvv potrebbe essere superfluo
		cliente= this.findById(id);
		if(cliente.isPresent()) {
			return -2;
		}
		return 0;
		
	}
	
}
