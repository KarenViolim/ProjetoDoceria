package telas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import dao.daoAgenda;
import entidade.Agenda;
import fabrica.Fabrica;

public class TelaAgenda {
	public static void main (String args[]) {
		EntityManagerFactory fabrica = Fabrica.get();

		daoAgenda dao = new daoAgenda();
		Agenda agenda = new Agenda();
		Scanner scann = new Scanner(System.in);
		//gerenciador.remove apaga, gerenciador.find busca, gerenciador.merge alterar.
		
		int opcao = 0;
		do {
			System.out.println("Digite a opção desejada:");
			System.out.println("01 - Inserir");
			System.out.println("02 - Consultar");
			System.out.println("03 - Alterar ");
			System.out.println("04 - Excluir");
			opcao = scann.nextInt();
			scann.nextLine();
			if (opcao == 1) {
				System.out.println("INSERIR AGENDA");
				System.out.println("DATA LIVRE: ");
				String dtlivre = scann.nextLine();
				agenda.setDtlivre(dtlivre);
				
				System.out.println("TEMPO LIVRE: ");
				String tempolivre = scann.nextLine();
				agenda.setTempolivre(tempolivre);;
				
				dao.inserir(agenda);
			} 
			else if (opcao == 2) {
				listarCadastrosAgenda();
			}
			else if (opcao == 3) {
				listarCadastrosAgenda();
				System.out.println("ALTERAR AGENDA");
				System.out.println("Insira o ID da agenda a ser alterado");	
				agenda.setIdagenda(scann.nextLong());
				System.out.println("Nova Data Livre: ");
				agenda.setDtlivre(scann.next());
				System.out.println("Novo Tempo Livre: ");
				agenda.setTempolivre(scann.next());
				
				System.out.println("Alterando...");
				dao.alterar(agenda);
			}
			else if (opcao == 4) {
				listarCadastrosAgenda();
				System.out.println("EXCLUIR AGENDA");
				System.out.println("Insira o id da data a ser excluida: ");
				agenda.setIdagenda(scann.nextLong());
				dao.excluir(agenda);
			}
		}while(opcao != 5);
		}
		public static void listarCadastrosAgenda() {
			daoAgenda dao = new daoAgenda();
			System.out.println("CONSULTAR AGENDA:");
			List<Agenda> agd = dao.buscar();

			for (Agenda agenda : agd) {
				System.out.println("Id: "+agenda.getIdagenda()+" Data Livre: "+agenda.getDtlivre()+" - Tempo Livre: "+agenda.getTempolivre());
			}		
		}
}
