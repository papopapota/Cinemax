package Cinemax.proyectoCinemax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Cinemax.proyectoCinemax.model.bd.Funcion;
import Cinemax.proyectoCinemax.service.FuncionService;

@Controller
@RequestMapping("/")
public class FuncionController {
	private final FuncionService funcionService;
	
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
		return "funcionEditar";
	}
	
	@PostMapping("/funcionEditar/{id}")
	public String editarFuncionSubmit(@PathVariable Integer id, @ModelAttribute Funcion funcion) {
		funcion.setIdFuncion(id);
		funcionService.save(funcion);
		return "redirect:/funcionLista";
	}
	
	@GetMapping("/funcionEliminar/{id}")
	public String eliminarFuncion(@PathVariable Integer id) {
		funcionService.deleteById(id);
		return "redirect:/funcionLista";
	}

}
