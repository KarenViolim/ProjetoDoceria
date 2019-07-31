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
public class ItensPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String quantidade;
	private String precototal;
	@ManyToOne
	private Pedido pedido;
	@ManyToOne
	private Produto produto;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQtde(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getPrecototal() {
		return precototal;
	}
	public void setPrecototal(String precototal) {
		this.precototal = precototal;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
