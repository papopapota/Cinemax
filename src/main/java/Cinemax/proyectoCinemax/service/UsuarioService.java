package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Usuario;
import Cinemax.proyectoCinemax.repository.UsuarioRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements  IUsuarioService{
	private final UsuarioRepository usuarioRepository;

	public void guardar(Usuario usuario){
		usuarioRepository.save(usuario);
	}
	public Usuario EncontrarUserById(long id){
		return usuarioRepository.findById(id).get();
	}

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario authenticate(String email, String password) {

		Usuario usuario = usuarioRepository.findByCorreoUsuarioAndClaveUsuario(email , password);
		
		if (usuario != null && usuario.getClaveUsuario().equals(password)) {
			return usuario;
		} else {
			return null;
		}
	}

	public String updateUser(Usuario usuario){

		try {
			usuarioRepository.save(usuario);
		}catch (Exception e){
			return "No se pudo Actualizar el usuario";
		}
        return "Se actualizo el Usuario con exito";
    }

	@Override
	public Usuario EncontrarUserById(Integer id) {
		return usuarioRepository.findById(id.longValue()).orElse(null);
	}


	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return null;
	}

	public Usuario findById(Integer id) {
		return usuarioRepository.findById(Long.valueOf(id)).orElse(null);
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}
}