package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Asiento;
import Cinemax.proyectoCinemax.repository.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoService implements  IAsientoService {
    @Autowired

    private AsientoRepository asientoRepository;

    @Override
    public void save(Asiento asiento){
        asientoRepository.save(asiento);
    }

    @Override
    public List<Asiento> listaAsientoByFuncion(int id){
      return  asientoRepository.findByFuncionIdFuncion(id);
    }
}
