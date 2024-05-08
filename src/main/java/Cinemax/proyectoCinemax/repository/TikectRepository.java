package Cinemax.proyectoCinemax.repository;

import Cinemax.proyectoCinemax.model.bd.Boletos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TikectRepository extends JpaRepository<Boletos, Integer> {
    List<Boletos> findByUsuarioIdUsuario(Long id_usuario);

}
