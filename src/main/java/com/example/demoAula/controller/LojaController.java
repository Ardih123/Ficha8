package com.example.demoAula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoAula.dto.SimpleResponse;
import com.example.demoAula.dto.SimpleResponseLoja;
import com.example.demoAula.model.Loja;
import com.example.demoAula.service.LojaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class LojaController {
	
	private final LojaService LojaService;

	@Autowired
	public LojaController(LojaService lojaService) {
		LojaService = lojaService;
	}
	
	/*
	 * /addLoja 
	 * /addLoja/{loja_id}/Andar/{andar_id} 
	 * /deleteLoja/{id} 
	 * /updateLoja
	 * /getAllLoja 
	 * /getLojaById/{id}
	 */

	@PutMapping("/addLoja")
	public ResponseEntity<SimpleResponse> addLoja(@RequestBody Loja aLoja ) {
		SimpleResponseLoja srA = new SimpleResponseLoja();
		
        if (aLoja.getNome() == null || aLoja.getNome().isBlank()){
        	srA.setMessage("Nome invalido");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(srA);
        }
        if(aLoja.getNumeroFuncionarios() <= 0) {
        	srA.setMessage("Funcionarios Tem Que Ser Superior a 0");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(srA);
		}
        if(aLoja.getArea() <= 0) {
        	srA.setMessage("Area Tem Que Ser Superior a 0");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(srA);
		}
        
        if (LojaService.addLoja(aLoja)){
        	srA.setAsSuccess("Loja Inserida Com Sucesso");
        	srA.setListaLoja(LojaService.getAllLoja());

        }else{
        	srA.setAsError("Erro ao inserir a Loja");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(srA);
	}
	
	@PutMapping("/addLoja/{loja_id}/Andar/{andar_id}")
	public String addLojaAndar(@PathVariable String aLojaId, @PathVariable String aAndarId) {
		if(aLojaId == null || aLojaId.isBlank() || aAndarId == null || aAndarId.isBlank()) {
			
		}
		return LojaService.addLojaAndar(aLojaId, aAndarId);
	}
	
	@DeleteMapping("/deleteLoja/{id}")
	public SimpleResponse deleteLojaById(@PathVariable String aId) {
		SimpleResponse sr = new SimpleResponse();

        if (LojaService.deleteLojaById(aId)){
            sr.setAsSuccess("Loja Removida Com Sucesso");
        }
        else{
            sr.setAsError("Erro a Remover a Loja");
        }

        return sr;
	}
	
	@PutMapping("/updateLoja")
	public SimpleResponse updateLoja(@RequestBody Loja aLoja) {
        SimpleResponse sr = new SimpleResponse();

        if (aLoja.getId() == null){
            sr.setAsError("Id invalido");
            return sr;
        }
        if (aLoja.getNome() == null || aLoja.getNome().isBlank()){
            sr.setAsError("Nome Invalido");
            return sr;
        }
        if (aLoja.getArea() <= 0){
            sr.setAsError("Area invalida");
            return sr;
        }
        
        boolean suc = LojaService.updateLoja(aLoja);

        if (suc){
            sr.setAsSuccess("Loja atualizada com sucesso");
        }
        else{
            sr.setAsError("Erro na atualização da Loja "+ aLoja.getId());
        }
        return sr;
	}
	
	@GetMapping("/getAllLoja")
	public List<Loja> getAllLoja() {
		return LojaService.getAllLoja();
	}
	
	@GetMapping("/getLojaById/{id}")
	public List<Loja> getLojaById(@PathVariable String aId) {
		if(aId == null || aId.isBlank()) {
			//Long idLoja = Long.valueOf(aId);
			
		}
		return LojaService.getLojaById(aId);
	}
}
