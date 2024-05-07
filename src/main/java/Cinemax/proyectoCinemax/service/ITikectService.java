package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Boletos;

public interface ITikectService {
    void save(Boletos boletos);

    Boletos findById(Integer id);
}
