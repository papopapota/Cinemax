package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Usuario;
import Cinemax.proyectoCinemax.repository.UsuarioRepository;

public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario authenticate(String username, String password) {
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		if (usuario != null && usuario.getPassword().equals(password)) {
			return usuario;
		} else {
			return null;
		}
	}
}