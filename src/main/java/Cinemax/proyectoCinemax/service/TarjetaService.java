package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Tarjeta;
import Cinemax.proyectoCinemax.model.bd.Usuario;
import Cinemax.proyectoCinemax.repository.TarjetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@AllArgsConstructor
@Service
public class TarjetaService implements ITarjetaService{
    private TarjetaRepository TarjetaRepository;
    @Override
    public List<Tarjeta> listarTarjeta() {
        return TarjetaRepository.findAll();
    }

    @Override
    public void registrarTarjeta(Tarjeta tarjeta) {
        TarjetaRepository.save(tarjeta);
    }
    @Override
    public void eliminarTarjeta(Integer id) {
        TarjetaRepository.deleteById(id);
    }
    @Override
    public List<Tarjeta> listarTarjetaPorUsuario(Integer idUsuario) {
        return TarjetaRepository.findById_usuario(idUsuario);
    }


}
