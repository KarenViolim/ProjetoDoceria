package telas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import dao.daoEstado;
import entidade.Estado;
import fabrica.Fabrica;

public class TelaEstado {
	public static void main (String args[]) {
		EntityManagerFactory fabrica = Fabrica.get();
		daoEstado dao = new daoEstado();
		Estado estado = new Estado();
		Scanner scann = new Scanner(System.in);
		
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
				System.out.println("INSERIR ESTADO");
				System.out.println("NOME: ");
				String nome = scann.nextLine();
				estado.setNome(nome);
				
				System.out.println("SIGLA: ");
				String sigla = scann.nextLine();
				estado.setSigla(sigla);
				
				dao.inserir(estado);
			} 
			else if (opcao == 2) {
				listarCadastrosEstado();
			}
			else if (opcao == 3) {
				listarCadastrosEstado();
				System.out.println("ALTERAR CADASTRO");
				System.out.println("Insira o ID do cadastro a ser alterado");	
				estado.setId(scann.nextLong());
				System.out.println("Novo nome: ");
				estado.setNome(scann.next());
				System.out.println("Nova sigla: ");
				estado.setSigla(scann.next());
				
				System.out.println("Alterando...");
				dao.alterar(estado);
			}
			else if (opcao == 4) {
				listarCadastrosEstado();
				System.out.println("EXCLUIR CADASTRO");
				System.out.println("Insira o id do Estado a ser excluido: ");
				estado.setId(scann.nextLong());
				dao.excluir(estado);
			}
		}while(opcao != 5);
		}
		public static void listarCadastrosEstado() {
			daoEstado dao = new daoEstado();
			System.out.println("LISTAR TODOS ESTADOS");
			List<Estado> est = dao.buscar();

			for (Estado estado : est) {
				System.out.println("Id: "+estado.getId()+" Estado: "+estado.getNome()+" - "+estado.getSigla());
			}		
		}
}

