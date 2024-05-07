package Cinemax.proyectoCinemax.service;

import java.util.List;

import Cinemax.proyectoCinemax.model.bd.Sala;

public interface ISalaService {
	List<Sala> findAll();
    Sala findById(Integer id);
    Sala save(Sala sala);
    void deleteById(Integer id);
}
