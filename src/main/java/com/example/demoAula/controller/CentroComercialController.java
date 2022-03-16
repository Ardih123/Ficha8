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
import com.example.demoAula.dto.SimpleResponseCentroComercial;
import com.example.demoAula.model.CentroComercial;
import com.example.demoAula.service.CentroComercialService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CentroComercialController {

	private final CentroComercialService CentroComercialService;

	@Autowired
	public CentroComercialController(CentroComercialService centroComercialService) {
		CentroComercialService = centroComercialService;
	}
	
	/*
	 * /addCentroComercial 
	 * /deleteCentroComercial/{id} 
	 * /getAllCentroComercial
	 * /getCentroComercialById/{id}
	 */
	
	@PutMapping("/addCentroComercial")
	public ResponseEntity<SimpleResponse> addCentroComercial(@RequestBody CentroComercial aCentroComercial) {
		SimpleResponseCentroComercial srCC = new SimpleResponseCentroComercial();
		
        if (aCentroComercial.getNumeroMaxAndar() <= 0){
        	srCC.setMessage("Andar Tem Que Ser Superior a 0");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(srCC);
        }
        if(aCentroComercial.getNome() == null || aCentroComercial.getNome().isBlank()) {
			srCC.setMessage("Nome invalido");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(srCC);
		}
        if(aCentroComercial.getMorada() == null || aCentroComercial.getMorada().isBlank()) {
			srCC.setMessage("Morada invalido");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(srCC);
		}
        
        if (CentroComercialService.addCentroComercial(aCentroComercial)){
        	srCC.setAsSuccess("Centro Comercial Inserido Com Sucesso");
        	srCC.setListaCentroComercial(CentroComercialService.getAllCentroComercial());

        }else{
        	srCC.setAsError("Erro ao inserir o Centro Comercial");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(srCC);
	}
	
	@DeleteMapping("/deleteCentroComercial/{id}")
	public SimpleResponse deleteCentroComercialById(@PathVariable String aId) {
        SimpleResponse sr = new SimpleResponse();

        if (CentroComercialService.deleteCentroComercialById(aId)){
            sr.setAsSuccess("Centro Comercial Removido Com Sucesso");
        }
        else{
            sr.setAsError("Erro a Remover o Centro Comercial");
        }

        return sr;
	}
	
	@GetMapping("/getAllCentroComercial")
	public List<CentroComercial> getAllCentroComercial() {
		return CentroComercialService.getAllCentroComercial();
	}
	
	@GetMapping("/getCentroComercialById/{id}")
	public List<CentroComercial> getCentroComercialById(@PathVariable String aId) {
		if(aId == null || aId.isBlank()) {
			//Long idCentroComercial = Long.valueOf(aId);
			
		}
		return CentroComercialService.getCentroComercialById(aId);
	}
	
}
