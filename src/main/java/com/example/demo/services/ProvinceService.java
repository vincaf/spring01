package com.example.demo.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.entity.Provincia;
import com.example.demo.repositories.ProvinceRepository;

@Service
public class ProvinceService {

	private static final Logger log = LogManager.getLogger();
	
	@Autowired ProvinceRepository repository;
	
	public List<Provincia> getProvince(){
		return repository.findAll();
	}
	
}
