package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Pelicula;

import java.util.List;

public interface IPeliculaService {
    List<Pelicula> listarPeliculas();

    void regitrarPelicula(Pelicula peliculas);
    void eliminarPelicula(Integer id);


    Pelicula FindById(Integer id);
}
