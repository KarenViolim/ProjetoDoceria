package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idcliente;
	private String nomec;
	private String rg;
	private String cpf;
	private String telefone;
	private String email;
	@ManyToOne
	private Cidade cidade;
	
	public long getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(long idcliente) {
		this.idcliente = idcliente;
	}
	public String getNome() {
		return nomec;
	}
	public void setNome(String nomec) {
		this.nomec = nomec;
	}
	public String getRg() {
		return rg;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
