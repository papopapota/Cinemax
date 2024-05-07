package Cinemax.proyectoCinemax.repository;

import Cinemax.proyectoCinemax.model.bd.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Integer> {

    List<Funcion> findByPeliculaIdpelicula(int id );
}
