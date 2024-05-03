package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Usuario;
import Cinemax.proyectoCinemax.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements  IUsuario{
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
}