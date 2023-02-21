package com.example.demo.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.entity.Provincia;
import com.example.database.entity.Regione;
import com.example.demo.services.ProvinceService;
import com.example.demo.services.RegioniService;

@RestController
@RequestMapping("/italia")
public class ItaliaRestController {
	private static final Logger log = LogManager.getLogger();
	
	@Autowired RegioniService regioniService;
	
	@Autowired ProvinceService provinceService; 
	
	@GetMapping("/regioni")
    public ResponseEntity<List<Regione>> findAllRegioni() {
        log.trace("Start del metodo findAll regioni");
        List<Regione> regioni = regioniService.getRegioni();
        return new ResponseEntity<>(regioni, HttpStatus.OK);
    }

    @GetMapping("/province")
    public ResponseEntity<List<Provincia>> findAllProvince() {
        log.trace("Start del metodo findAll province");
        List<Provincia> province = provinceService.getProvince();
        return new ResponseEntity<>(province, HttpStatus.OK);
    }
	
}
