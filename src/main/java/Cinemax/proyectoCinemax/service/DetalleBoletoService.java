package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.DetalleBoleto;
import Cinemax.proyectoCinemax.repository.DetalleBoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleBoletoService {
    @Autowired
    DetalleBoletoRepository detalleBoletoRepo  ;

    public void save (DetalleBoleto detalleBoleto){
        detalleBoletoRepo.save(detalleBoleto);
    }
}
