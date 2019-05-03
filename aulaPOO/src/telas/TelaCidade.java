package telas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import dao.daoCidade;
import dao.daoEstado;
import entidade.Cidade;
import entidade.Estado;
import fabrica.Fabrica;

public class TelaCidade {
	public static void main (String args[]) {
		EntityManagerFactory fabrica = Fabrica.get();
	
		daoCidade dao = new daoCidade();
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		Scanner scann = new Scanner(System.in);
		
		int opcao = 0;
		do {
			System.out.println("Digite a opção desejada:");
			System.out.println("01 - Inserir");
			System.out.println("02 - Consultar");
			System.out.println("03 - Alterar ");
			System.out.println("04 - Excluir");
			System.out.println("05 - Sair");
			opcao = scann.nextInt();
			scann.nextLine();
			if (opcao == 1) {
				System.out.println("INSERIR CIDADE");
				System.out.println("NOME: ");
				String nome = scann.nextLine();
				cidade.setNome(nome);

				listarCadastrosEstado();
				System.out.println("Insira o ID: ");
				long id = scann.nextLong();
				estado.setId(id);
				cidade.setEstado(estado);
				dao.inserir(cidade);
			} 
			else if (opcao == 2) {
				listarCadastrosCidade();
			}
			else if (opcao == 3) {
				listarCadastrosCidade();
				System.out.println("ALTERAR CADASTRO");
				System.out.println("Insira o ID da Cidade a ser alterado");	
				cidade.setId(scann.nextLong());
				System.out.println("Novo nome: ");
				cidade.setNome(scann.next());
				System.out.println("Novo estado, ID: ");
				long id = scann.nextLong();
				estado.setId(id);
				cidade.setEstado(estado);

				dao.alterar(cidade);
			}
			else if (opcao == 4) {
				listarCadastrosCidade();
				System.out.println("EXCLUIR CADASTRO");
				System.out.println("Insira o id da Cidade a ser excluido: ");
				cidade.setId(scann.nextLong());
				dao.excluir(cidade);
			}
		}while(opcao != 6);
		//gerenciador.remove apaga, gerenciador.find busca, gerenciador.merge alterar.
		}
	public static void listarCadastrosCidade() {
		daoCidade dao = new daoCidade();
		System.out.println("LISTAR TODAS CIDADES");
		List<Cidade> cid = dao.buscar();
			
		for(Cidade cidade : cid) {
			System.out.println("Id: "+cidade.getId()+" Cidade: "+cidade.getNome()+" Estado: "+cidade.getEstado().getSigla());
		}
		}
	
	public static void listarCadastrosEstado() {
		daoEstado dao = new daoEstado();
		Estado estado = new Estado();
		List<Estado> lista = dao.buscar();
			
		for (Estado est : lista) {
			System.out.println("Id: "+est.getId()+" Estado: "+est.getNome()+" - "+est.getSigla());
		}
	}
	}
