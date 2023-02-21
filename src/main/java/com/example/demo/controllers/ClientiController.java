package com.example.demo.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.database.entity.Cliente;
import com.example.demo.repositories.ClientiRepository;
import com.example.demo.services.ClientiService;

@Controller
@RequestMapping("/clienti")
public class ClientiController {
	
	private static final Logger log = LogManager.getLogger();

	@Autowired
	ClientiRepository repository;
	
	@Autowired ClientiService service;
	
	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("lista.clienti", getClienti());
		return "clienti"; // aggancia /jsp/clienti.jsp
	}
	
	@PostMapping
	public String create(Model model,
			@RequestParam String nome,
			@RequestParam String cognome,
			@RequestParam String email,
			@RequestParam String indirizzo,
			@RequestParam String citta,
			@RequestParam String provincia,
			@RequestParam String cap
			) {
		log.trace("Start del metodo create");
		log.debug("Dati del cliente nome={} cognome={} email={} indirizzo={} citta={} provincia={} cap={}", nome, cognome, email, indirizzo, citta, provincia, cap);
		Cliente cliente = Cliente.createCliente(nome, cognome, email, indirizzo, citta, cap, provincia);
		cliente = service.save(cliente);
		model.addAttribute("lista.clienti", getClienti());
		return "clienti"; // aggancia /jsp/clienti.jsp
	}
	
	private List<Cliente> getClienti(){
		return service.findAll();
	}
}
