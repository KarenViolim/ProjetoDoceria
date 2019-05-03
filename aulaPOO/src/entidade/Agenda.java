package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agenda {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idagenda;
	private String dtlivre;
	private String tempolivre;
	
	public long getIdagenda() {
		return idagenda;
	}
	public void setIdagenda(long idagenda) {
		this.idagenda = idagenda;
	}
	public String getDtlivre() {
		return dtlivre;
	}
	public void setDtlivre(String dtlivre) {
		this.dtlivre = dtlivre;
	}
	public String getTempolivre() {
		return tempolivre;
	}
	public void setTempolivre(String tempolivre) {
		this.tempolivre = tempolivre;
	}
}
