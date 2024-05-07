package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Asiento;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IAsientoService  {
    void save(Asiento asiento);

    List<Asiento> listaAsientoByFuncion(int id);
}
