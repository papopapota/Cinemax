package Cinemax.proyectoCinemax.controller;


import Cinemax.proyectoCinemax.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {
    @Autowired
    private IPeliculaService IPeliculaService;

    @GetMapping("/listar")
    public String listarPeliculas(Model model){
        model.addAttribute("peliculas" ,
                IPeliculaService.listarPeliculas());
        return "backoffice/pelicula/formpelicula";
    }
}
