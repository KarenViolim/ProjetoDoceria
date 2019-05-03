package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrador {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idadm;
	private String usuario;
	private String email;
	private String senha;
	
	public long getIdadm() {
		return idadm;
	}
	public void setIdadm(long idadm) {
		this.idadm = idadm;
	}
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
}
