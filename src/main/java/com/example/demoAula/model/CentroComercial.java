package com.example.demoAula.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CentroComercial")
public class CentroComercial {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
	private String nome, morada;
	private int numeroMaxAndar;
	
	@OneToMany(mappedBy="CentroComercial")
	private List<Andar> Andar;
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMorada() {
		return morada;
	}
	
	public void setMorada(String morada) {
		this.morada = morada;
	}
	
	public int getNumeroMaxAndar() {
		return numeroMaxAndar;
	}
	
	public void setNumeroMaxAndar(int numeroMaxAndar) {
		this.numeroMaxAndar = numeroMaxAndar;
	}
	
	@Override
	public String toString() {
		return "CentroComercial [id=" + id + ", nome=" + nome + ", morada=" + morada + ", numeroMaxAndar="
				+ numeroMaxAndar + "]";
	}
	
}
