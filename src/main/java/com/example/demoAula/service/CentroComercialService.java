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
	
	private final CentroComercialRepository CentroComercialRepository;
	
	@Autowired
	public CentroComercialService(CentroComercialRepository centroComercialRepository) {
		CentroComercialRepository = centroComercialRepository;
	}

	public boolean addCentroComercial(CentroComercial aCentroComercial) {
        if (aCentroComercial.getId() == null){
        	CentroComercialRepository.save(aCentroComercial);
            return true;
        }
        return false;
	}

	public boolean deleteCentroComercialById(String aId) {
        try {
            Long id_long = parseLong(aId);

            if (id_long == null || id_long == NaN || CentroComercialRepository.findById(id_long).isEmpty()){
                return false;
            }

            CentroComercial aCentroComercial = CentroComercialRepository.findById(id_long).get();
            CentroComercialRepository.delete(aCentroComercial);

            return true;
        }catch (Exception e){
            return false;
        }
	}

	public List<CentroComercial> getAllCentroComercial() {
		List<CentroComercial> listaCentroComercial = new ArrayList<>();

		CentroComercialRepository.findAll().forEach(listaCentroComercial::add);

        return listaCentroComercial;
	}

	public Optional<CentroComercial> getCentroComercialById(Long aId) {
		return CentroComercialRepository.findById(aId);
	}

}
