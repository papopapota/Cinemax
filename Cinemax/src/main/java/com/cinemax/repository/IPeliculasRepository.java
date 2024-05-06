package com.cinemax.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinemax.model.Peliculas;

public interface IPeliculasRepository extends JpaRepository<Peliculas,Integer> {
	
	
}
