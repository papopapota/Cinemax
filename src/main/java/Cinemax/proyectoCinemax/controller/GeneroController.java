package Cinemax.proyectoCinemax.controller;

import Cinemax.proyectoCinemax.model.bd.Genero;
import Cinemax.proyectoCinemax.service.IGeneroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/genero")
public class GeneroController {
    private IGeneroService IGeneroService;

    @GetMapping("/list")
    public String listarGenero(Model model){
        model.addAttribute("generos",
                IGeneroService.listarGenero());
        return "backoffice/pelicula/formpelicula";
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Genero> listGenero(){
        return IGeneroService.listarGenero();
    }

}
