package Cinemax.proyectoCinemax.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Cinemax.proyectoCinemax.model.bd.Usuario;
import Cinemax.proyectoCinemax.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

public class LoginController {
	private final UsuarioService usuarioService;
	
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/login")
	public String LoginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
		Usuario usuario = usuarioService.authenticate(username, password);
		if (usuario != null) {
			session.setAttribute("usuario", usuario);
			if (usuario.getIdTipo() == 1) {
				return "redirect:/usuario";
			} else if (usuario.getIdTipo() == 2) {
				return "redirect:/admin";
			}
		}
		return "redirect:/login?error";
	}
	
	@GetMapping("/usuario")
	public String usuarioVista(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if (usuario != null && usuario.getIdTipo() == 1) {
			return "usuarioVista";
		} else {
			return "redirect:login";
		}
	}
	
	@GetMapping("/admin")
	public String adminVista(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if (usuario != null && usuario.getIdTipo() == 2) {
			return "adminVista";
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}