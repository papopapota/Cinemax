package Cinemax.proyectoCinemax.repository;

import Cinemax.proyectoCinemax.model.bd.DetalleBoleto;
import Cinemax.proyectoCinemax.model.bd.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleBoletoRepository extends JpaRepository<DetalleBoleto, Integer> {

}
