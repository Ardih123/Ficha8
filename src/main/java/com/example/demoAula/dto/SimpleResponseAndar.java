package com.example.demoAula.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demoAula.model.Andar;

public class SimpleResponseAndar extends SimpleResponse{

	List<Andar> listaAndar;
	
	public SimpleResponseAndar() {
		this.listaAndar = new ArrayList<>();
	}

	public List<Andar> getListaAndar() {
		return listaAndar;
	}

	public void setListaAndar(List<Andar> listaAndar) {
		this.listaAndar = listaAndar;
	}
	
	
}
