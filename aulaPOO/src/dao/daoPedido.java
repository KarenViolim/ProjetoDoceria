package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Pedido;
import fabrica.Fabrica;

public class daoPedido {
	private EntityManager gerenciador;
	private EntityTransaction transacao;
		
	public Pedido inserir(Pedido pedido) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(pedido);
			transacao.commit();
		}catch (Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return pedido;
	}
	public Pedido consultar(Pedido pedido) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			pedido = gerenciador.find(Pedido.class, pedido.getDtvenda());
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return pedido;
	}
	public List<Pedido> buscar() {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
		
			return gerenciador.createQuery("from Pedido").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return null;
	}
	public Pedido alterar(Pedido pedido) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(pedido);
			transacao.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return pedido;
	}
	public Pedido excluir(Pedido pedido) {
		try {
			EntityManagerFactory fabrica = Fabrica.get(); 
			gerenciador = fabrica.createEntityManager(); 
			transacao = gerenciador.getTransaction(); 
			
			transacao.begin();
			pedido = gerenciador.find(Pedido.class, pedido.getIdpedido());
			gerenciador.remove(pedido);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return pedido;
	}
}
