package com.Karen.ProjetoDoceria.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nome;
	private String qtdemin;
	private String tempoprod;
	private String precovenda;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQtdemin() {
		return qtdemin;
	}
	public void setQtdemin(String qtdemin) {
		this.qtdemin = qtdemin;
	}
	public String getTempoprod() {
		return tempoprod;
	}
	public void setTempoprod(String tempoprod) {
		this.tempoprod = tempoprod;
	}
	public String getPrecovenda() {
		return precovenda;
	}
	public void setPrecovenda(String precovenda) {
		this.precovenda = precovenda;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
