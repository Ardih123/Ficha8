package com.example.demoAula.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Andar")
public class Andar {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
	private int numeroAndar, numeroMaxLojas;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="CentroComercial_id", nullable=false) private
	 * List<CentroComercial> CentroComercial;
	 * 
	 * @OneToMany(mappedBy="Andar") private List<Loja> Loja;
	 */

	public Long getId() {
		return id;
	}

	public int getNumeroAndar() {
		return numeroAndar;
	}

	public void setNumeroAndar(int numeroAndar) {
		this.numeroAndar = numeroAndar;
	}

	public int getNumeroMaxLojas() {
		return numeroMaxLojas;
	}

	public void setNumeroMaxLojas(int numeroMaxLojas) {
		this.numeroMaxLojas = numeroMaxLojas;
	}

	@Override
	public String toString() {
		return "Andar [id=" + id + ", numeroAndar=" + numeroAndar + ", numeroMaxLojas=" + numeroMaxLojas + "]";
	}
	
}
