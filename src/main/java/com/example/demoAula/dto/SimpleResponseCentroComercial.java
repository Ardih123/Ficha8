package com.example.demoAula.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demoAula.model.CentroComercial;

public class SimpleResponseCentroComercial extends SimpleResponse{

	List<CentroComercial> listaCentroComercial;

	public SimpleResponseCentroComercial() {
		this.listaCentroComercial = new ArrayList<>();
	}

	public List<CentroComercial> getListaCentroComercial() {
		return listaCentroComercial;
	}

	public void setListaCentroComercial(List<CentroComercial> listaCentroComercial) {
		this.listaCentroComercial = listaCentroComercial;
	}
	
	
}
