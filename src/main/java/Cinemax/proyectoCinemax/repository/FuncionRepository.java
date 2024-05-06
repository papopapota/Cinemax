package Cinemax.proyectoCinemax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Cinemax.proyectoCinemax.model.bd.Funcion;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Long> {

}
