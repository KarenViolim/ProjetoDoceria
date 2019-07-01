package com.Karen.ProjetoDoceria.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Funcionario extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(nullable = false, length = 25)
	@NotEmpty(message = "O usuário é obrigatório")
	private String usuario;
	@Column(nullable = false, length = 80)
	@NotEmpty(message = "O e-mail é obrigatório")
	private String email;
	@Column(nullable = false, length = 8)
	@NotEmpty(message = "A senha é obrigatório")
	private String senha;
	@Column(nullable = false, length = 30)
	@NotEmpty(message = "O cargo é obrigatório")
	private String cargo;
	@Column(nullable = false, length = 8)
	@NotNull
	private Double salario;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
