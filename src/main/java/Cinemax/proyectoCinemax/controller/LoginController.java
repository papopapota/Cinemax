package Cinemax.proyectoCinemax.controller;

import org.springframework.web.bind.annotation.GetMapping;

import Cinemax.proyectoCinemax.service.UsuarioService;

public class LoginController {
	private final UsuarioService usuarioService;
	
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/login")
	public String LoginForm() {
		return "login";
	}
}