package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.entity.Cliente;
import com.example.demo.services.ClientiService;

@RestController
@RequestMapping("/clienti")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientiRestController {

	private static final Logger log = LogManager.getLogger();

	/* @Autowired */ ClientiService service;

	public ClientiRestController(ClientiService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity< List<Cliente> > findAll() {
		log.trace("Start del metodo findAll");
		List<Cliente> clienti = service.findAll();
		return new ResponseEntity<>(clienti, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity< Cliente > findById(@PathVariable("id") Integer id) {
		log.trace("Start del metodo findById");

		Optional<Cliente> cliente = service.findById(id);

		if (cliente.isPresent()) {
			return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity< Cliente > create(@RequestBody Cliente cliente) {
		log.trace("Start del metodo create");
		Cliente clientecreato = service.save(cliente);

		return new ResponseEntity<>(clientecreato, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity< Boolean > deleteById(@PathVariable("id") Integer id) {
		log.trace("Start del metodo deleteById");
		int deleted=service.deleteById(id);
		if(deleted==-1) {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
		if(deleted==-2) {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	// modalità alternativa per la deleteById
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete2ById(@PathVariable Integer id) {
		log.trace("Start del metodo deleteById2");
		try {
			service.deleteById2(id);
			return ResponseEntity.ok("Cliente con ID " + id + " eliminato con successo.");
		} catch (EmptyResultDataAccessException e) {
			log.trace("*****{}", e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente con ID " + id + " non trovato.");
		}

	}

	@PutMapping
	public ResponseEntity< Boolean > update(@RequestBody Cliente cliente) {
		log.trace("Start del metodo update");
		boolean updated = service.update(cliente);
		if(updated) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/count")
	public ResponseEntity< Map<String, Long> > count() {
		log.trace("Start del metodo count");
		long conteggio = service.count();
		Map<String,Long> countMap = new HashMap<>();
		countMap.put("conteggio", conteggio);
		return new ResponseEntity<>(countMap, HttpStatus.OK);
	}

}
