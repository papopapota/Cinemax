package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Pelicula;
import Cinemax.proyectoCinemax.repository.PeliculaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PeliculaService implements IPeliculaService{

    private PeliculaRepository PeliculaRepository;
    @Override
    public List<Pelicula> listarPeliculas() {
        return PeliculaRepository.findAll();
    }

    @Override
    public void regitrarPelicula(Pelicula peliculas) {
        PeliculaRepository.save(peliculas);
    }
    @Override
    public void eliminarPelicula(Integer id) {
        PeliculaRepository.deleteById(id);
    }

    @Override
    public Pelicula FindById(Integer id) {
       return PeliculaRepository.findById(id).get();
    }

}
