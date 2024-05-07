package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Sala;
import Cinemax.proyectoCinemax.repository.SalaRepository;

import java.util.List;

import Cinemax.proyectoCinemax.model.bd.Sala;
import org.springframework.stereotype.Service;

@Service
public class SalaService implements  ISalaService {
	private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @Override
	public List<Sala> findAll() {
		// TODO Auto-generated method stub

		return salaRepository.findAll();
	}

	@Override
	public Sala findById(Integer id) {
		// TODO Auto-generated method stub
		return salaRepository.findById(id).get();
	}

	@Override
	public Sala save(Sala sala) {
		// TODO Auto-generated method stub
		return salaRepository.save(sala);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
