package Cinemax.proyectoCinemax.repository;

import Cinemax.proyectoCinemax.model.bd.Tarjeta;
import Cinemax.proyectoCinemax.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {
    @Query("SELECT t FROM Tarjeta t WHERE t.id_usuario.idUsuario = :idUsuario")
    List<Tarjeta> findById_usuario(Integer idUsuario);
}