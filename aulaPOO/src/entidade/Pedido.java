package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idpedido;
	private String dtvenda;
	private String temp_est_pedido;
	private String status_pedido;
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Agenda agenda;
	public long getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(long idpedido) {
		this.idpedido = idpedido;
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
}
