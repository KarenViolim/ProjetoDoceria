package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Itens_Pedido;
import fabrica.Fabrica;

public class daoItens_Pedido {
	private EntityManager gerenciador;
	private EntityTransaction transacao;
		
	public Itens_Pedido inserir(Itens_Pedido itens_pedido) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(itens_pedido);
			transacao.commit();
		}catch (Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return itens_pedido;
	}
	public Itens_Pedido consultar(Itens_Pedido itens_pedido) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			itens_pedido = gerenciador.find(Itens_Pedido.class, itens_pedido.getPedido());
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return itens_pedido;
	}
	public List<Itens_Pedido> buscar() {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
		
			return gerenciador.createQuery("from Itens_Pedido").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return null;
	}
	public Itens_Pedido alterar(Itens_Pedido itens_pedido) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(itens_pedido);
			transacao.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return itens_pedido;
	}
	public Itens_Pedido excluir(Itens_Pedido itens_pedido) {
		try {
			EntityManagerFactory fabrica = Fabrica.get(); 
			gerenciador = fabrica.createEntityManager(); 
			transacao = gerenciador.getTransaction(); 
			
			transacao.begin();
			itens_pedido = gerenciador.find(Itens_Pedido.class, itens_pedido.getIditenspedido());
			gerenciador.remove(itens_pedido);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return itens_pedido;
	}
}
