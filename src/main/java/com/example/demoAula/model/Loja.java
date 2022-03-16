package com.example.demoAula.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Loja")
public class Loja {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
	private String nome;
	private int numeroFuncionarios, area;
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}
	
	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	public int getArea() {
		return area;
	}
	
	public void setArea(int area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Loja [id=" + id + ", nome=" + nome + ", numeroFuncionarios=" + numeroFuncionarios + ", area=" + area
				+ "]";
	}
	
}
