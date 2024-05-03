package Cinemax.proyectoCinemax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Cinemax.proyectoCinemax.model.bd.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByCorreoUsuarioAndClaveUsuario(String Correo , String clave);
}