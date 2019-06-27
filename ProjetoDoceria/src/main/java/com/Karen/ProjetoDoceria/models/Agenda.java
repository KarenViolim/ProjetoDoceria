package com.Karen.ProjetoDoceria.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Agenda implements Serializable{
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(nullable=false, length = 10)
	@NotEmpty(message = "É obrigatório adicionar uma data livre")
	private String dataLivre;
	private String tempolivre;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDataLivre() {
		return dataLivre;
	}
	public void setDataLivre(String dataLivre) {
		this.dataLivre = dataLivre;
	}
	public String getTempolivre() {
		return tempolivre;
	}
	public void setTempolivre(String tempolivre) {
		this.tempolivre = tempolivre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
