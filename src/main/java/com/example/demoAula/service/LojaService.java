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

	private final LojaRepository lojaRepository;
	
	@Autowired
	public LojaService(LojaRepository lojaRepository) {
		this.lojaRepository = lojaRepository;
	}

	public boolean addLoja(Loja aLoja) {
        if (aLoja.getId() == null){
        	lojaRepository.save(aLoja);
            return true;
        }
        return false;
	}

	public String addLojaAndar(String aLojaId, String aAndarId) {
		return "";
	}

	public boolean deleteLojaById(String aId) {
        try {
            Long id_long = parseLong(aId);

            if (id_long == null || id_long == NaN || lojaRepository.findById(id_long).isEmpty()){
                return false;
            }

            Loja aLoja = lojaRepository.findById(id_long).get();
            lojaRepository.delete(aLoja);

            return true;
        }catch (Exception e){
            return false;
        }
	}

	public boolean updateLoja(Loja aLoja) {
        if (aLoja.getId() == null || lojaRepository.findById(aLoja.getId()).isEmpty()){
            return false;
        }

        Loja loja = lojaRepository.findById(aLoja.getId()).get();

        if (loja.getNome() != null || !loja.getNome().isBlank()){
        	loja.setNome(aLoja.getNome());
        }
        if (aLoja.getArea()>0){
        	loja.setArea(aLoja.getArea());
        }
        if (aLoja.getNumeroFuncionarios()>0){
        	loja.setNumeroFuncionarios(aLoja.getNumeroFuncionarios());
        }

        lojaRepository.save(loja);

        return true;
	}

	public List<Loja> getAllLoja() {
		List<Loja> listaLoja = new ArrayList<>();

		lojaRepository.findAll().forEach(listaLoja::add);

        return listaLoja;
	}

	public Optional<Loja> getLojaById(Long aId) {
		return lojaRepository.findById(aId);
	}

}
