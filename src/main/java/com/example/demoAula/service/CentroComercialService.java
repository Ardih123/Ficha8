package com.example.demoAula.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoAula.model.CentroComercial;
import com.example.demoAula.repository.CentroComercialRepository;

@Service
public class CentroComercialService {
	
	private final CentroComercialRepository centroComercialRepository;
	
	@Autowired
	public CentroComercialService(CentroComercialRepository centroComercialRepository) {
		this.centroComercialRepository = centroComercialRepository;
	}

	public boolean addCentroComercial(CentroComercial aCentroComercial) {
        if (aCentroComercial.getId() == null){
        	centroComercialRepository.save(aCentroComercial);
            return true;
        }
        return false;
	}

	public boolean deleteCentroComercialById(String aId) {
        try {
            Long id_long = parseLong(aId);

            if (id_long == null || id_long == NaN || centroComercialRepository.findById(id_long).isEmpty()){
                return false;
            }

            CentroComercial aCentroComercial = centroComercialRepository.findById(id_long).get();
            centroComercialRepository.delete(aCentroComercial);

            return true;
        }catch (Exception e){
            return false;
        }
	}

	public List<CentroComercial> getAllCentroComercial() {
		List<CentroComercial> listaCentroComercial = new ArrayList<>();

		centroComercialRepository.findAll().forEach(listaCentroComercial::add);

        return listaCentroComercial;
	}

	public Optional<CentroComercial> getCentroComercialById(Long aId) {
		return centroComercialRepository.findById(aId);
	}

}
