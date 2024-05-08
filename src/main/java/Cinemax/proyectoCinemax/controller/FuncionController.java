package Cinemax.proyectoCinemax.controller;

import Cinemax.proyectoCinemax.model.bd.Funcion;
import Cinemax.proyectoCinemax.repository.IPeliculasRepository;
import Cinemax.proyectoCinemax.repository.SalaRepository;
import Cinemax.proyectoCinemax.service.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class FuncionController {
    private final FuncionService funcionService;

    @Autowired
    private IPeliculasRepository repoPeli;

    @Autowired
    private SalaRepository repoSala;


    public FuncionController(FuncionService funcionService) {
        this.funcionService = funcionService;
    }

    @GetMapping("/funcionLista")
    public String listaFunciones(Model model) {
        model.addAttribute("funciones", funcionService.findAll());
        return "funcionLista";
    }

    @GetMapping("/funcionNuevo")
    public String nuevaFuncionForm(Model model) {
        model.addAttribute("funcion", new Funcion());
        model.addAttribute("peliculas", repoPeli.findAll());
        model.addAttribute("salas", repoSala.findAll());

        return "funcionNuevo";
    }

    @PostMapping("/funcionNuevo")
    public String nuevaFuncionSubmit(@ModelAttribute Funcion funcion) {
        funcionService.save(funcion);
        return "redirect:/funcionLista";
    }

    @GetMapping("/funcionEditar/{id}")
    public String editarFuncionForm(@PathVariable Integer id, Model model) {
        Funcion funcion = funcionService.findById(id);
        model.addAttribute("funcion", funcion);
        model.addAttribute("peliculas", repoPeli.findAll());
        model.addAttribute("salas", repoSala.findAll());

        return "funcionEditar";
    }

    @PostMapping("/funcionEditar/{id}")
    public String editarFuncionSubmit(@PathVariable Integer id, @ModelAttribute Funcion funcion, Model model) {
        try {
            funcion.setIdFuncion(id);
            funcionService.save(funcion);
        }catch (Exception e){
            model.addAttribute("mensaje", "ERROR AL REGISTRAR");
        }

        return "redirect:/funcionLista";
    }

    @GetMapping("/funcionEliminar/{id}")
    public String eliminarFuncion(@PathVariable Integer id) {
        funcionService.deleteById(id);
        return "redirect:/funcionLista";
    }

}
