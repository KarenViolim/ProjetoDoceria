package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Itens_Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long iditenspedido;
	private String qtde;
	private String precototal;
	@ManyToOne
	private Pedido pedido;
	@ManyToOne
	private Produto produto;
	
	public long getIditenspedido() {
		return iditenspedido;
	}
	public void setIditenspedido(long idpedido) {
		this.iditenspedido = idpedido;
	}
	public String getQtde() {
		return qtde;
	}
	public void setQtde(String qtde) {
		this.qtde = qtde;
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
}
