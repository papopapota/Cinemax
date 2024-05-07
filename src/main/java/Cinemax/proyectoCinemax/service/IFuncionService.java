package Cinemax.proyectoCinemax.service;

<<<<<<< HEAD
import java.util.List;

import Cinemax.proyectoCinemax.model.bd.Funcion;

public interface IFuncionService {
	List<Funcion> findAll();
    Funcion findById(Long id);
    Funcion save(Funcion usuario);
    void deleteById(Long id);




    List<Funcion> findByPeliculaIdPelicula(int id);
}
