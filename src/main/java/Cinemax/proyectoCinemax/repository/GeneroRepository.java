package Cinemax.proyectoCinemax.repository;

import Cinemax.proyectoCinemax.model.bd.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}
