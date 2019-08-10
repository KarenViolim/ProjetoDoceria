package com.Karen.ProjetoDoceria.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String quantidademin;
	private String tempoprod;
	private BigDecimal valorunitario;
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
	public String getQuantidademin() {
		return quantidademin;
	}
	public void setQuantidademin(String quantidademin) {
		this.quantidademin = quantidademin;
	}
	public String getTempoprod() {
		return tempoprod;
	}
	public void setTempoprod(String tempoprod) {
		this.tempoprod = tempoprod;
	}
	public BigDecimal getValorunitario() {
		return valorunitario;
	}
	public void setValorunitario(BigDecimal valorunitario) {
		this.valorunitario = valorunitario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
