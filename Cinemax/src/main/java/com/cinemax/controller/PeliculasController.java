package com.cinemax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cinemax.model.Genero;
import com.cinemax.model.Peliculas;
import com.cinemax.repository.IPeliculasRepository;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

    @Autowired
    private IPeliculasRepository peliculasRepository;

    @GetMapping("/peliculas")
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculasRepository.findAll());

        return "Index"; // Devuelve la vista Index.html
    }
}
