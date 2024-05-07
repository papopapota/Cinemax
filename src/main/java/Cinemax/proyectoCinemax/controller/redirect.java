package Cinemax.proyectoCinemax.controller  ;

import Cinemax.proyectoCinemax.repository.IPeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class redirect implements ErrorController {

    @Autowired
    private IPeliculasRepository peliculasRepository;

    @RequestMapping("/")
    public String redirec() {
        return "redirect:/peliculas/peliculas";
    }

  
}