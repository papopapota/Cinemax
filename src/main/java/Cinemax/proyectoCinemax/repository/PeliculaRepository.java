package Cinemax.proyectoCinemax.repository;

import Cinemax.proyectoCinemax.model.bd.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Peliculas, Integer> {
}
