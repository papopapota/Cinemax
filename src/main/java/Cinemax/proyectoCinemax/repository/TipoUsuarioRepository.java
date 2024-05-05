package Cinemax.proyectoCinemax.repository;

import Cinemax.proyectoCinemax.model.bd.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
}
