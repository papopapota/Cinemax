package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Peliculas;
import Cinemax.proyectoCinemax.model.bd.Usuario;

import java.util.List;

public interface IPeliculaService {
    List<Peliculas> listarPeliculas();

    void regitrarPelicula(Peliculas peliculas);
    void eliminarPelicula(Integer id);


}