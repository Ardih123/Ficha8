package com.example.demoAula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoAula.dto.SimpleResponse;
import com.example.demoAula.dto.SimpleResponseAndar;
import com.example.demoAula.model.Andar;
import com.example.demoAula.service.AndarService;

@RestController
public class AndarController {
	
	private final AndarService andarService;

	@Autowired
	public AndarController(AndarService andarService) {
		this.andarService = andarService;
	}
	
	/*
	 * /addAndar 
	 * /addAndar/{andar_id}/centroComercial/{centro_comercial_id}
	 * /deleteAndar/{id} 
	 * /getAllAndar
	 */

	@PostMapping("/addAndar")
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
        
        if (andarService.addAndar(aAndar)){
        	srA.setAsSuccess("Centro Comercial Inserido Com Sucesso");
        	srA.setListaAndar(andarService.getAllAndar());

        }else{
        	srA.setAsError("Erro ao inserir o Centro Comercial");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(srA);
		
	}
	
	@PostMapping("/addAndar/{aAndarId}/centroComercial/{aCentroId}")
	public String addAndarCentroComercial(@PathVariable String aAndarId, @PathVariable String aCentroId) {
		if(aAndarId == null || aAndarId.isBlank() || aCentroId == null || aCentroId.isBlank()) {
			
		}
		return andarService.addAndarCentroComercial(aAndarId, aCentroId);
	}
	
	@DeleteMapping("/deleteAndar/{aId}")
	public SimpleResponse deleteAndarById(@PathVariable String aId) {
		SimpleResponse sr = new SimpleResponse();

        if (andarService.deleteAndarById(aId)){
            sr.setAsSuccess("Andar Removido Com Sucesso");
        }
        else{
            sr.setAsError("Erro a Remover o Andar");
        }

        return sr;
	}
	
	@GetMapping("/getAllAndar")
	public List<Andar> getAllAndar() {
		return andarService.getAllAndar();
	}
}
