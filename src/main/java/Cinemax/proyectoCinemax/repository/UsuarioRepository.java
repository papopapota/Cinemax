package Cinemax.proyectoCinemax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Cinemax.proyectoCinemax.model.bd.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByCorreoUsuarioAndClaveUsuario(String Correo , String clave);

    Optional<Usuario> findById(Long id);
}