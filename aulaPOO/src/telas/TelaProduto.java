package telas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import dao.daoProduto;
import entidade.Produto;
import fabrica.Fabrica;

public class TelaProduto {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Fabrica.get();
		daoProduto dao = new daoProduto();
		Produto produto = new Produto();
		Scanner scann = new Scanner(System.in);
		
		
		int opcao = 0;
		do {
			System.out.println("DIGITE A OPÇÃO DESEJADA: ");
			System.out.println("1 - Inserir");
			System.out.println("2 - Consultar");
			System.out.println("3 - Alterar");
			System.out.println("4 - Excluir");
			opcao = scann.nextInt();
			scann.nextLine();
			if (opcao == 1) {
				System.out.println("INSERIR PRODUTO");
				System.out.println("NOME PRODUTO: ");
				String nome = scann.next();
				produto.setNome(nome);
				System.out.println("QUANTIDADE MÍNIMA: ");
				String qtdemin = scann.next();
				produto.setQtdemin(qtdemin);
				System.out.println("TEMPO DE PRODUÇÃO: ");
				String tempoprod = scann.next();
				produto.setTempoprod(tempoprod);
				System.out.println("PREÇO DE VENDA: ");
				String precovenda = scann.next();
				produto.setPrecovenda(precovenda);
				
				dao.inserir(produto);
			}
			else if (opcao == 2) {
				listarCadastrosProduto();
			}
			else if (opcao == 3) {
				listarCadastrosProduto();
				System.out.println("INSIRA O ID DO PRODUTO A SER ALTERADO: ");
				produto.setIdprod(scann.nextLong());
				System.out.println("NOVO NOME DO PRODUTO: ");
				produto.setNome(scann.next());
				System.out.println("NOVA QUANTIDADE MÍNIMA: ");
				produto.setQtdemin(scann.next());
				System.out.println("NOVO TEMPO DE PRODUÇÃO: ");
				produto.setTempoprod(scann.next());
				System.out.println("NOVO PREÇO DE VENDA: ");
				produto.setPrecovenda(scann.next());
				
				dao.alterar(produto);
			}
			else if (opcao == 4) {
				listarCadastrosProduto();
				System.out.println("EXCLUIR PRODUTO");
				System.out.println("INSIRA O ID DO PRODUTO A SER EXCLUIDO: ");
				produto.setIdprod(scann.nextLong());
				dao.excluir(produto);
			}
		}while(opcao != 5);
		}
		public static void listarCadastrosProduto() {
			daoProduto dao = new daoProduto();
			System.out.println("LISTAR TODOS OS PRODUTOS:");
			List<Produto> prod = dao.buscar();
			
			for(Produto produto : prod) {
				System.out.println("ID: "+produto.getIdprod()+" - NOME: "+produto.getNome()+" - QUANTIDADE MÍNIMA: "+produto.getQtdemin()+
						" - TEMPO PRODUÇÃO: "+produto.getTempoprod()+" - PREÇO VENDA: "+produto.getPrecovenda());
			}
		}
}
