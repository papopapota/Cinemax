package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Tarjeta;

import java.util.List;

public interface ITarjetaService {
    List<Tarjeta> listarTarjeta();

    void registrarTarjeta(Tarjeta tarjeta);
    void eliminarTarjeta(Integer id);
    List<Tarjeta> listarTarjetaPorUsuario(Integer id_usuario);

}
