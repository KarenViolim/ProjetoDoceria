package telas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import dao.daoItens_Pedido;
import dao.daoPedido;
import dao.daoProduto;
import entidade.Itens_Pedido;
import entidade.Pedido;
import entidade.Produto;
import fabrica.Fabrica;

public class TelaItens_Pedido {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Fabrica.get();
		daoItens_Pedido dao = new daoItens_Pedido();
		Itens_Pedido itens_pedido = new Itens_Pedido();
		Produto produto = new Produto();
		Pedido pedido = new Pedido();
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
				System.out.println("INSERIR ITENS DO PEDIDO");
				System.out.println("QUANTIDADE: ");
				String qtde = scann.next();
				itens_pedido.setQtde(qtde);
				System.out.println("PREÇO TOTAL: ");
				String precototal = scann.next();
				itens_pedido.setPrecototal(precototal);
				listarCadastrosPedido();
				System.out.println("INSIRA O ID DO PEDIDO: ");
				Long idpedido = scann.nextLong();
				pedido.setIdpedido(idpedido);
				itens_pedido.setPedido(pedido);
				listarCadastrosProduto();
				System.out.println("INSIRA O ID DO PRODUTO: ");
				Long idprod = scann.nextLong();
				produto.setIdprod(idprod);
				itens_pedido.setProduto(produto);
				
				dao.inserir(itens_pedido);
			}
			else if (opcao == 2) {
				listarCadastrosItens_Pedido();
			}
			else if (opcao == 3) {
				listarCadastrosItens_Pedido();
				System.out.println("INSIRA O ID DOS ITENS DO PEDIDO A SER ALTERADO: ");
				itens_pedido.setIditenspedido(scann.nextLong());
				System.out.println("NOVA QUANTIDADE: ");
				itens_pedido.setQtde(scann.next());
				System.out.println("NOVO PREÇO TOTAL: ");
				itens_pedido.setPrecototal(scann.next());
				System.out.println("NOVO ID DO PEDIDO: ");
				Long idpedido = scann.nextLong();
				pedido.setIdpedido(idpedido);
				itens_pedido.setPedido(pedido);
				System.out.println("NOVO ID DO PRODUTO: ");
				Long idprod = scann.nextLong();
				produto.setIdprod(idprod);
				itens_pedido.setProduto(produto);
				
				dao.alterar(itens_pedido);
			}
			else if (opcao == 4) {
				listarCadastrosItens_Pedido();
				System.out.println("EXCLUIR ITENS DO PEDIDO");
				System.out.println("INSIRA O ID DO ITEM DO PEDIDO A SER EXCLUIDO: ");
				itens_pedido.setIditenspedido(scann.nextLong());
				dao.excluir(itens_pedido);
			}
		}while(opcao != 5);
		}
		public static void listarCadastrosItens_Pedido() {
			daoItens_Pedido dao = new daoItens_Pedido();
			System.out.println("LISTAR TODOS OS ITENS DO PEDIDO");
			List<Itens_Pedido> itensped = dao.buscar();
			
			for(Itens_Pedido itens_pedido : itensped) {
				System.out.println("ID: "+itens_pedido.getIditenspedido()+" - QUANTIDADE: "+itens_pedido.getQtde()+" - PREÇO TOTAL: "+itens_pedido.getPrecototal()+
						" - ID DO PEDIDO: "+itens_pedido.getPedido().getIdpedido()+" - NOME DO PRODUTO: "+itens_pedido.getProduto().getNome());
			}
		}
		public static void listarCadastrosPedido() {
			daoPedido dao = new daoPedido();
			System.out.println("LISTAR TODOS OS PEDIDOS");
			List<Pedido> ped = dao.buscar();
			
			for(Pedido pedido : ped) {
				System.out.println("ID: "+pedido.getIdpedido()+" - Data de Venda: "+pedido.getDtvenda()+" - Tempo Est. Pedido: "+pedido.getTemp_est_pedido()+
						" - Status do Pedido: "+pedido.getStatus_pedido()+" - Nome do Cliente: "+pedido.getCliente().getNome()+" - Data de Entrega: "+pedido.getAgenda().getDtlivre());
			}
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
