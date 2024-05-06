package Cinemax.proyectoCinemax.repository ;

import org.springframework.data.jpa.repository.JpaRepository;

import Cinemax.proyectoCinemax.model.bd.Peliculas;

public interface IPeliculasRepository extends JpaRepository<Peliculas,Integer> {
	
	
}
