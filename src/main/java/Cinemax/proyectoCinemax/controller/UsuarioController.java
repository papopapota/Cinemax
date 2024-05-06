package Cinemax.proyectoCinemax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Cinemax.proyectoCinemax.model.bd.Usuario;
import Cinemax.proyectoCinemax.service.UsuarioService;

@Controller
@RequestMapping("/")
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/usuarioLista")
	public String listaUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.findAll());
		return "usuarioLista";
	}
	
	@GetMapping("/usuarioNuevo")
	public String nuevoUsuarioForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuarioNuevo";
	}
	
	@PostMapping("/usuarioNuevo")
	public String nuevoUsuarioSubmit(@ModelAttribute Usuario usuario) {
		usuarioService.save(usuario);
		return "redirect:/usuarioLista";
	}
	
	@GetMapping("/usuarioEditar/{id}")
	public String editarUsuarioForm(@PathVariable Long id, Model model) {
		Usuario usuario = usuarioService.findById(id);
		model.addAttribute("usuario", usuario);
		return "usuarioEditar";
	}
	
	@PostMapping("/usuarioEditar/{id}")
	public String editarUsuarioSubmit(@PathVariable Long id, @ModelAttribute Usuario usuario) {
		usuario.setIdUsuario(id);
		usuarioService.save(usuario);
		return "redirect:/usuarioLista";
	}
	
	@GetMapping("/usuarioEliminar/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
		usuarioService.deleteById(id);
		return "redirect:/usuarioLista";
	}
}
