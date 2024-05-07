package Cinemax.proyectoCinemax.repository ;

import org.springframework.data.jpa.repository.JpaRepository;

import Cinemax.proyectoCinemax.model.bd.Pelicula;

public interface IPeliculasRepository extends JpaRepository<Pelicula,Integer> {
	
	
}
