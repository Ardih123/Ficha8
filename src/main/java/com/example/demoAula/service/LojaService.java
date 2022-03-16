package com.example.demoAula.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoAula.model.Loja;
import com.example.demoAula.repository.LojaRepository;

@Service
public class LojaService {

	private final LojaRepository LojaRepository;
	
	@Autowired
	public LojaService(LojaRepository lojaRepository) {
		LojaRepository = lojaRepository;
	}

	public boolean addLoja(Loja aLoja) {
        if (aLoja.getId() == null){
        	LojaRepository.save(aLoja);
            return true;
        }
        return false;
	}

	public String addLojaAndar(String aLojaId, String aAndarId) {

	}

	public boolean deleteLojaById(String aId) {
        try {
            Long id_long = parseLong(aId);

            if (id_long == null || id_long == NaN || LojaRepository.findById(id_long).isEmpty()){
                return false;
            }

            Loja aLoja = LojaRepository.findById(id_long).get();
            LojaRepository.delete(aLoja);

            return true;
        }catch (Exception e){
            return false;
        }
	}

	public boolean updateLoja(Loja aLoja) {

	}

	public List<Loja> getAllLoja() {
		List<Loja> listaLoja = new ArrayList<>();

		LojaRepository.findAll().forEach(listaLoja::add);

        return listaLoja;
	}

	public Optional<Loja> getLojaById(Long aId) {
		return LojaRepository.findById(aId);
	}

}
