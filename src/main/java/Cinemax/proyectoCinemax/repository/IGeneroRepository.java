package Cinemax.proyectoCinemax.repository ;

import org.springframework.data.jpa.repository.JpaRepository;

import Cinemax.proyectoCinemax.model.bd.Genero;

public interface IGeneroRepository  extends JpaRepository<Genero,Integer> {

}
