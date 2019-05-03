package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Agenda;
import fabrica.Fabrica;

public class daoAgenda {
	private EntityManager gerenciador;
	private EntityTransaction transacao;
		
	public Agenda inserir(Agenda agenda) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(agenda);
			transacao.commit();
		}catch (Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return agenda;
	}
	public Agenda consultar(Agenda agenda) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			agenda = gerenciador.find(Agenda.class, agenda.getTempolivre());
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return agenda;
	}
	public List<Agenda> buscar() {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
		
			return gerenciador.createQuery("from Agenda").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return null;
	}
	public Agenda alterar(Agenda agenda) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(agenda);
			transacao.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return agenda;
	}
	public Agenda excluir(Agenda agenda) {
		try {
			EntityManagerFactory fabrica = Fabrica.get(); 
			gerenciador = fabrica.createEntityManager(); 
			transacao = gerenciador.getTransaction(); 
			
			transacao.begin();
			agenda = gerenciador.find(Agenda.class, agenda.getIdagenda());
			gerenciador.remove(agenda);
			transacao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return agenda;
	}
}
