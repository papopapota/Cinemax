package Cinemax.proyectoCinemax.service;

import java.util.List;

import Cinemax.proyectoCinemax.model.bd.Funcion;

public interface IFuncionService {
	List<Funcion> findAll();
    Funcion findById(Long id);
    Funcion save(Funcion usuario);
    void deleteById(Long id);
}