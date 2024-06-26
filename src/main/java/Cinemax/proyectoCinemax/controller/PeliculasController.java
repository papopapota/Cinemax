package Cinemax.proyectoCinemax.controller  ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Cinemax.proyectoCinemax.model.bd.Genero;
import Cinemax.proyectoCinemax.model.bd.Pelicula;
import Cinemax.proyectoCinemax.repository.IPeliculasRepository;

@Controller
@RequestMapping("/")
public class PeliculasController {

    @Autowired
    private IPeliculasRepository peliculasRepository;

    @GetMapping("/Index")
    public String listarPeliculas(Model model) {

        model.addAttribute("peliculas", peliculasRepository.findAll());

        return "Index"; // Devuelve la vista Index.html
    }

    @GetMapping("/peliculas")
    public String listarPeliculas2(Model model) {

        model.addAttribute("peliculas", peliculasRepository.findAll());

        return "Index"; // Devuelve la vista Index.html
    }
}
