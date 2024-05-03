package Cinemax.proyectoCinemax.controller;

import Cinemax.proyectoCinemax.model.bd.TipoUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Cinemax.proyectoCinemax.model.bd.Usuario;
import Cinemax.proyectoCinemax.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/")
public class LoginController {
	private final UsuarioService usuarioService;
	
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	//@RequestMapping("/login")
	@GetMapping("/login")
	public String LoginForm(  ) {
		//model.addAttribute("" );
		return "login";
	}

	@GetMapping("/registrar")
	public String registrar(Model model) {
		 Usuario usuario = new Usuario();
		 model.addAttribute(usuario);
		return "registrar";
	}

	@PostMapping("/registrarForm")
	public String registrarForm(@ModelAttribute Usuario usuario , RedirectAttributes redirectAttributes) {
		try {
			TipoUsuario tipoUsuario = new TipoUsuario();
			tipoUsuario.setIdTipoUsuario(1);
			usuario.setTipoUsuario(tipoUsuario);
			//usuario.setIdUsuario(null);
			usuarioService.guardar(usuario);
		}catch (Exception e){
			redirectAttributes.addFlashAttribute("successMessage","Error de Regitro: " + e.getMessage());
			return "redirect:login";
			//return "Error al Registrarte: " + e.getMessage();

		}
		redirectAttributes.addFlashAttribute("successMessage","Registro Exitoso ");
		return "redirect:login";
	}
	
	@PostMapping("/loguear")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session , RedirectAttributes redirectAttributes) {
		Usuario usuario = new Usuario();
		try {
			 usuario = usuarioService.authenticate(username, password);
		}catch (Exception e ){
			return "Error " + e.getMessage();
		}


		if (usuario != null) {
			session.setAttribute("usuario", usuario);
			if (usuario.getTipoUsuario().getIdTipoUsuario() == 1) {
				return "redirect:/actualizarUsuario";
			} else if (usuario.getTipoUsuario().getIdTipoUsuario() == 2) {
				return "redirect:/admin";
			}
		}
		return "redirect:/login?error";
	}
	
	@GetMapping("/usuario")
	public String usuarioVista(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if (usuario != null && usuario.getTipoUsuario().getIdTipoUsuario() == 1) {
			return "usuarioVista";
		} else {
			return "redirect:login";
		}
	}
	
	@GetMapping("/admin")
	public String adminVista(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if (usuario != null && usuario.getTipoUsuario().getIdTipoUsuario() == 2) {
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

	@GetMapping("/actualizarUsuario")
	public String actualizarUsuario(Model model , HttpSession session) {
		Usuario usuario = new Usuario();
		usuario = (Usuario) session.getAttribute("usuario");
		model.addAttribute(usuario);

		return "actualizarUsuario";
	}
	@PostMapping("/actualizarUsuario")
	public String actualizarUsuario(@RequestParam Usuario usuario, HttpSession session , RedirectAttributes redirectAttributes) {


		try {
			Usuario usuarupdate = (Usuario) session.getAttribute("usuario");
			Usuario usuarupdate2 = usuario;
			usuarupdate2.setIdUsuario(usuarupdate.getIdUsuario());
			 usuarioService.guardar(usuario);
		}catch (Exception e ){
			return "Error " + e.getMessage();
		}



		return "redirect:/login?error";
	}


}