package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Estado;
import fabrica.Fabrica;

public class daoEstado {
	private EntityManager gerenciador;
	private EntityTransaction transacao;
		
	public Estado inserir(Estado estado) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(estado);
			transacao.commit();
		}catch (Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return estado;
	}
	
	public Estado consultar(Estado estado) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			estado = gerenciador.find(Estado.class, estado.getNome());
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return estado;
	}
	
	public List<Estado> buscar() {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
		
			return gerenciador.createQuery("from Estado").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return null;
	}
	
	public Estado alterar(Estado estado) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(estado);
			transacao.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return estado;
	}
	
	public Estado excluir(Estado estado) {
		try {
			EntityManagerFactory fabrica = Fabrica.get(); 
			gerenciador = fabrica.createEntityManager(); 
			transacao = gerenciador.getTransaction(); 
			
			transacao.begin();
			estado = gerenciador.find(Estado.class, estado.getId());
			gerenciador.remove(estado);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return estado;
		
	}
}
