package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Boletos;
import Cinemax.proyectoCinemax.repository.TikectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TikectService implements  ITikectService {

    @Autowired
    TikectRepository tikectRepository;
    @Override
    public void save(Boletos boletos){
        tikectRepository.save(boletos);
    }

    @Override
    public Boletos findById(Integer id) {
        return tikectRepository.findById(id).get();
    }


}
