package com.Karen.ProjetoDoceria.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false, length = 10)
	@NotEmpty(message = "A data de venda é obrigatória")
	private String dtvenda;
	private String temp_est_pedido;
	private String status_pedido;
	@ManyToOne
	private Cliente cliente;
	@ManyToOne 
	private Funcionario funcionario;
	@ManyToOne
	private Agenda agenda;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDtvenda() {
		return dtvenda;
	}
	public void setDtvenda(String dtvenda) {
		this.dtvenda = dtvenda;
	}
	public String getTemp_est_pedido() {
		return temp_est_pedido;
	}
	public void setTemp_est_pedido(String temp_est_pedido) {
		this.temp_est_pedido = temp_est_pedido;
	}
	public String getStatus_pedido() {
		return status_pedido;
	}
	public void setStatus_pedido(String status_pedido) {
		this.status_pedido = status_pedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
