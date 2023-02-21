package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.entity.Provincia;

@Repository
public interface ProvinceRepository extends JpaRepository<Provincia, Integer> {

}
