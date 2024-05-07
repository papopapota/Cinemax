package Cinemax.proyectoCinemax.repository;

import Cinemax.proyectoCinemax.model.bd.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
}