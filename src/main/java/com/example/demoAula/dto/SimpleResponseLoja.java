package com.example.demoAula.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demoAula.model.Loja;

public class SimpleResponseLoja extends SimpleResponse{
	
	List<Loja> listaLoja;
	
	public SimpleResponseLoja() {
		this.listaLoja = new ArrayList<>();
	}

	public List<Loja> getListaLoja() {
		return listaLoja;
	}

	public void setListaLoja(List<Loja> listaLoja) {
		this.listaLoja = listaLoja;
	}

	
}
