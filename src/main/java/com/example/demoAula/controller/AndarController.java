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
import com.example.demoAula.dto.SimpleResponseAndar;
import com.example.demoAula.model.Andar;
import com.example.demoAula.service.AndarService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AndarController {
	
	private final AndarService AndarService;

	@Autowired
	public AndarController(AndarService andarService) {
		AndarService = andarService;
	}
	
	/*
	 * /addAndar 
	 * /addAndar/{andar_id}/centroComercial/{centro_comercial_id}
	 * /deleteAndar/{id} 
	 * /getAllAndar
	 */

	@PutMapping("/addAndar")
	public ResponseEntity<SimpleResponse> addAndar(@RequestBody Andar aAndar) {
		SimpleResponseAndar srA = new SimpleResponseAndar();
		
        if (aAndar.getNumeroAndar() <= 0){
        	srA.setMessage("Andar Tem Que Ser Superior a 0");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(srA);
        }
        if(aAndar.getNumeroMaxLojas() <= 0) {
        	srA.setMessage("Lojas Tem Que Ser Superior a 0");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(srA);
		}
        
        if (AndarService.addAndar(aAndar)){
        	srA.setAsSuccess("Centro Comercial Inserido Com Sucesso");
        	srA.setListaAndar(AndarService.getAllAndar());

        }else{
        	srA.setAsError("Erro ao inserir o Centro Comercial");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(srA);
		
	}
	
	@PutMapping("/addAndar/{andar_id}/centroComercial/{ce ntro_comercial_id}")
	public String addAndarCentroComercial(@PathVariable String aAndarId, @PathVariable String aCentroId) {
		if(aAndarId == null || aAndarId.isBlank() || aCentroId == null || aCentroId.isBlank()) {
			
		}
		return AndarService.addAndarCentroComercial(aAndarId, aCentroId);
	}
	
	@DeleteMapping("/deleteAndar/{id}")
	public SimpleResponse deleteAndarById(@PathVariable String aId) {
		SimpleResponse sr = new SimpleResponse();

        if (AndarService.deleteAndarById(aId)){
            sr.setAsSuccess("Andar Removido Com Sucesso");
        }
        else{
            sr.setAsError("Erro a Remover o Andar");
        }

        return sr;
	}
	
	@GetMapping("/getAllAndar")
	public List<Andar> getAllAndar() {
		return AndarService.getAllAndar();
	}
}
