package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.entity.Cliente;

@Repository
public interface ClientiRepository extends JpaRepository<Cliente, Integer> {

}
