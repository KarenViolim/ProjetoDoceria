package telas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import dao.daoAgenda;
import dao.daoCliente;
import dao.daoPedido;
import entidade.Agenda;
import entidade.Cliente;
import entidade.Pedido;
import fabrica.Fabrica;

public class TelaPedido {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Fabrica.get();
		
		daoPedido dao = new daoPedido();
		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		Agenda agenda = new Agenda();
		Scanner scann = new Scanner(System.in);
		
		int opcao = 0;
		do {
			System.out.println("Digite a opção desejada:");
			System.out.println("1 - Inserir");
			System.out.println("2 - Consultar");
			System.out.println("3 - Alterar");
			System.out.println("4 - Excluir");
			opcao = scann.nextInt();
			scann.nextLine();
			if (opcao == 1) {
				System.out.println("INSERIR PEDIDO");
				System.out.println("Data de venda: ");
				String dtvenda = scann.nextLine();
				pedido.setDtvenda(dtvenda);
				System.out.println("Tempo Estimado do Pedido: ");
				String temp_est_pedido = scann.nextLine();
				pedido.setTemp_est_pedido(temp_est_pedido);
				System.out.println("Status do Pedido: ");
				String status_pedido = scann.nextLine();
				pedido.setStatus_pedido(status_pedido);
				listarCadastrosCliente();
				System.out.println("Insira o ID do Cliente: ");
				Long idcliente = scann.nextLong();
				cliente.setIdcliente(idcliente);
				pedido.setCliente(cliente);
				listarCadastrosAgenda();
				System.out.println("Insira o ID da Agenda");
				Long idagenda = scann.nextLong();
				agenda.setIdagenda(idagenda);
				pedido.setAgenda(agenda);
				dao.inserir(pedido);
			}
			else if (opcao == 2) {
				listarCadastrosPedido();
			}
			else if (opcao == 3) {
				listarCadastrosPedido();
				System.out.println("INSIRA O ID DO PEDIDO A SER ALTERADO: ");
				pedido.setIdpedido(scann.nextLong());
				System.out.println("NOVA DATA DE VENDA: ");
				pedido.setDtvenda(scann.next());
				System.out.println("NOVO TEMPO ESTIMADO DO PEDIDO: ");
				pedido.setTemp_est_pedido(scann.next());
				System.out.println("NOVO STATUS DO PEDIDO: ");
				pedido.setStatus_pedido(scann.next());
				System.out.println("NOVO CLIENTE, ID: ");
				Long idcliente = scann.nextLong();
				cliente.setIdcliente(idcliente);
				pedido.setCliente(cliente);
				System.out.println("NOVA AGENDA, ID: ");
				Long idagenda = scann.nextLong();
				agenda.setIdagenda(idagenda);
				pedido.setAgenda(agenda);
				
				dao.alterar(pedido);
			}
			else if (opcao == 4) {
				listarCadastrosPedido();
				System.out.println("EXCLUIR PEDIDO");
				System.out.println("INSIRA O ID O PEDIDO A SER EXCLUIDO: ");
				pedido.setIdpedido(scann.nextLong());
				dao.excluir(pedido);
			}
		}while (opcao != 5);
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
	public static void listarCadastrosCliente() {
		daoCliente dao = new daoCliente();
		System.out.println("LISTAR TODOS OS CLIENTES");
		List<Cliente> cli = dao.buscar();
		
		for(Cliente cliente : cli) {
			System.out.println("ID: "+cliente.getIdcliente()+" Nome: "+cliente.getNome()+" RG: "+cliente.getRg()+" CPF: "+cliente.getCpf()+
					" Telefone: "+cliente.getTelefone()+" E-mail: "+cliente.getEmail()+" Cidade: "+cliente.getCidade().getNome());
		}
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
