package com.example.demoAula.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoAula.model.Andar;
import com.example.demoAula.repository.AndarRepository;

@Service
public class AndarService {
	
	private final AndarRepository AndarRepository;

	@Autowired
	public AndarService(AndarRepository andarRepository) {
		AndarRepository = andarRepository;
	}

	public boolean addAndar(Andar aAndar) {
        if (aAndar.getId() == null){
        	AndarRepository.save(aAndar);
            return true;
        }
        return false;
	}

	public String addAndarCentroComercial(String aAndarId, String aCentroId) {

	}

	public boolean deleteAndarById(String aId) {
        try {
            Long id_long = parseLong(aId);

            if (id_long == null || id_long == NaN || AndarRepository.findById(id_long).isEmpty()){
                return false;
            }

            Andar aAndar = AndarRepository.findById(id_long).get();
            AndarRepository.delete(aAndar);

            return true;
        }catch (Exception e){
            return false;
        }
	}

	public List<Andar> getAllAndar() {
		List<Andar> listaAndar = new ArrayList<>();

		AndarRepository.findAll().forEach(listaAndar::add);

        return listaAndar;
	}

}
