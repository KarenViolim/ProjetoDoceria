package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idprod;
	private String nome;
	private String qtdemin;
	private String tempoprod;
	private String precovenda;
	
	public long getIdprod() {
		return idprod;
	}
	public void setIdprod(long idprod) {
		this.idprod = idprod;
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
}
