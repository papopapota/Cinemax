package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Boletos;

import java.util.List;

public interface ITikectService {
    void save(Boletos boletos);

    Boletos findById(Integer id);
    List<Boletos> listaBoletosByIdUsuario(Long id_usuario);
}
