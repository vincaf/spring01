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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.entity.Cliente;
import com.example.demo.services.ClientiService;

@RestController
@RequestMapping("/clienti")
public class ClientiRestController {
	private static final Logger log = LogManager.getLogger();

	@Autowired
	ClientiService service;

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(Model model) {
		log.trace("Start del metodo findAll");
		List<Cliente> clienti = getClienti();
		return new ResponseEntity<>(clienti, HttpStatus.OK);
	}

	private List<Cliente> getClienti() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable("id") Integer id) {
		log.trace("Start del metodo findById");

		Optional<Cliente> cliente = service.findById(id);

		if (cliente.isPresent()) {
			return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Cliente> create(@RequestParam Cliente cliente) {
		log.trace("Start del metodo create");
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		log.trace("Start del metodo deleteById");
		try {
			service.deleteById(id);
			return ResponseEntity.ok("Cliente con ID " + id + " eliminato con successo.");
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente con ID " + id + " non trovato.");
		}

	}

	@PutMapping
	public ResponseEntity<Boolean> update(@RequestParam Cliente cliente) {
		log.trace("Start del metodo update");
		return new ResponseEntity<>(false, HttpStatus.OK);
	}

	@GetMapping("/count")
	public ResponseEntity<Map<String, Long>> count() {
	    log.trace("Start del metodo count");
	    long numeroClienti = service.count();
	    Map<String, Long> countMap = new HashMap<>();
	    countMap.put("count", numeroClienti);
	    return new ResponseEntity<>(countMap, HttpStatus.OK);
	}
}
