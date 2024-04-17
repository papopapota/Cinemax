package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Peliculas;
import Cinemax.proyectoCinemax.repository.PeliculaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PeliculaService implements IPeliculaService{

    private PeliculaRepository PeliculaRepository;
    @Override
    public List<Peliculas> listarPeliculas() {
        return PeliculaRepository.findAll();
    }

    @Override
    public void regitrarPelicula(Peliculas peliculas) {
        PeliculaRepository.save(peliculas);
    }
}
