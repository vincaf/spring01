package com.example.demo.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.entity.Cliente;
import com.example.demo.services.ClientiService;

@RestController
@RequestMapping("/clienti")
public class ClientiRestController {
	private static final Logger log = LogManager.getLogger();
	
	@Autowired ClientiService service;
	
	@GetMapping
	public ResponseEntity< List<Cliente> > findAll(Model model) {
		log.trace("Start del metodo findAll");
		List<Cliente> clienti = getClienti();
		return new ResponseEntity<>(clienti, HttpStatus.OK);
	}
	
	private List<Cliente> getClienti(){
		return service.findAll();
	}
}
