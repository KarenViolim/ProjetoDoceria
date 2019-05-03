package principal;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import fabrica.Fabrica;
import telas.TelaAdministrador;
import telas.TelaAgenda;
import telas.TelaCidade;
import telas.TelaCliente;
import telas.TelaEstado;
import telas.TelaItens_Pedido;
import telas.TelaPedido;
import telas.TelaProduto;

public class TelaPrincipal {
	public static void main(String args[]) {
		EntityManagerFactory fabrica = Fabrica.get();
		Scanner scann = new Scanner(System.in);
		
		System.out.println("INSIRA O NÚMERO DA TABELA QUE DESEJA GERENCIAR:");
		System.out.println("1 - Gerenciar Estado");
		System.out.println("2 - Gerenciar Cidade");
		System.out.println("3 - Gerenciar Cliente");
		System.out.println("4 - Gerenciar Agenda");
		System.out.println("5 - Gerenciar Pedido");
		System.out.println("6 - Gerenciar Produto");
		System.out.println("7 - Gerenciar Itens Pedido");
		System.out.println("8 - Gerenciar Administrador");
		int op = scann.nextInt();
		scann.nextLine();
		if(op == 1) {
			TelaEstado estado = new TelaEstado();
		}
		else if (op == 2) {
			TelaCidade cidade = new TelaCidade();
		}
		else if (op == 3) {
			TelaCliente cliente = new TelaCliente();
		}
		else if (op == 4) {
			TelaAgenda agenda = new TelaAgenda();
		}
		else if (op == 5) {
			TelaPedido pedido = new TelaPedido();
		}
		else if (op == 6) {
			TelaProduto produto = new TelaProduto();
		}
		else if (op == 7) {
			TelaItens_Pedido itens_pedido = new TelaItens_Pedido(); 
		}
		else if (op == 8) {
			TelaAdministrador administrador = new TelaAdministrador();
		}
	}
}
