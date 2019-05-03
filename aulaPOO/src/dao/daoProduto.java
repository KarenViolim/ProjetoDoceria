package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Produto;
import fabrica.Fabrica;

public class daoProduto {
	private EntityManager gerenciador;
	private EntityTransaction transacao;
		
	public Produto inserir(Produto produto) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(produto);
			transacao.commit();
		}catch (Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return produto;
	}
	public Produto consultar(Produto produto) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			produto = gerenciador.find(Produto.class, produto.getNome());
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return produto;
	}
	public List<Produto> buscar() {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
		
			return gerenciador.createQuery("from Produto").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return null;
	}
	public Produto alterar(Produto produto) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(produto);
			transacao.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return produto;
	}
	public Produto excluir(Produto produto) {
		try {
			EntityManagerFactory fabrica = Fabrica.get(); 
			gerenciador = fabrica.createEntityManager(); 
			transacao = gerenciador.getTransaction(); 
			
			transacao.begin();
			produto = gerenciador.find(Produto.class, produto.getIdprod());
			gerenciador.remove(produto);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return produto;
	}
}
