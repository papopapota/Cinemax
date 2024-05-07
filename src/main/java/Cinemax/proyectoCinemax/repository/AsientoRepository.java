package Cinemax.proyectoCinemax.repository;

import Cinemax.proyectoCinemax.model.bd.Asiento;
import Cinemax.proyectoCinemax.model.bd.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento, Integer> {
    List<Asiento> findByFuncionIdFuncion(int id);
}
