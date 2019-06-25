package com.Karen.ProjetoDoceria.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Cliente extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(nullable = false, length = 12)
	@NotEmpty(message = "O RG é obrigatório")
	private String rg;
	@Column(nullable = false, length = 15)
	@NotEmpty(message = "O CPF é obrigatório")
	private String cpf;
	@Column(nullable = false, length = 20)
	@NotEmpty(message = "O telefone é obrigatório")
	private String telefone;
	@Column(nullable = false, length = 80)
	@NotEmpty(message = "O endereço é obrigatório")
	private String endereco;
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
