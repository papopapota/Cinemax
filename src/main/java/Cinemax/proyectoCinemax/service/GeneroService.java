package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Genero;
import Cinemax.proyectoCinemax.repository.GeneroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GeneroService implements IGeneroService{
    private GeneroRepository generoRepository;

    @Override
    public List<Genero> listarGenero() {
        return generoRepository.findAll();
    }
}
