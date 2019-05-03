package telas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import dao.daoCidade;
import dao.daoCliente;
import entidade.Cidade;
import entidade.Cliente;
import fabrica.Fabrica;

public class TelaCliente {
	public static void main(String[] args) {
	EntityManagerFactory fabrica = Fabrica.get(); 
	
	daoCliente dao = new daoCliente();
	Cidade cidade = new Cidade();
	Cliente cliente = new Cliente();
	Scanner scann = new Scanner(System.in);
	
	int opcao = 0;
	do{
		System.out.println("Digite a opção desejada:");
		System.out.println("01 - Inserir");
		System.out.println("02 - Consultar");
		System.out.println("03 - Alterar ");
		System.out.println("04 - Excluir");
		opcao = scann.nextInt();
		scann.nextLine();
		if (opcao == 1) {
			System.out.println("INSERIR CLIENTE");
			System.out.println("NOME: ");
			String nomec = scann.nextLine();
			cliente.setNome(nomec);
			
			System.out.println("RG: ");
			String rg = scann.nextLine();
			cliente.setRg(rg);
			
			System.out.println("CPF: ");
			String cpf = scann.nextLine();
			cliente.setCpf(cpf);
			
			System.out.println("TELEFONE: ");
			String telefone = scann.nextLine();
			cliente.setTelefone(telefone);
			
			System.out.println("E-MAIL: ");
			String email = scann.nextLine();
			cliente.setEmail(email);
			
			listarCadastrosCidade();
			System.out.println("INSIRA O ID DA CIDADE: ");
			Long id = scann.nextLong();
			cidade.setId(id);
			cliente.setCidade(cidade);
			
			dao.inserir(cliente);
		}
		else if (opcao == 2) {
			listarCadastrosCliente();
		}
		else if (opcao == 3) {
			listarCadastrosCliente();
			System.out.println("INSIRA O ID DO CLIENTE A SER ALTERADO: ");
			cliente.setIdcliente(scann.nextLong());
			System.out.println("NOVO NOME: ");
			cliente.setNome(scann.next());
			System.out.println("NOVO RG: ");
			cliente.setRg(scann.next());
			System.out.println("NOVO CPF: ");
			cliente.setCpf(scann.next());
			System.out.println("NOVO TELEFONE: ");
			cliente.setTelefone(scann.next());
			System.out.println("NOVO E-MAIL: ");
			cliente.setEmail(scann.next());
			
			System.out.println("NOVA CIDADE, ID: ");
			long id = scann.nextLong();
			cidade.setId(id);
			cliente.setCidade(cidade);
			
			dao.alterar(cliente);
		}
		else if (opcao == 4) {
			listarCadastrosCliente();
			System.out.println("EXCLUIR CADASTRO");
			System.out.println("INSIRA O ID DO CLIENTE A SER EXCLUIDO: ");
			cliente.setIdcliente(scann.nextLong());
			dao.excluir(cliente);
		}
	}while(opcao != 5);
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
	public static void listarCadastrosCidade() {
		daoCidade dao = new daoCidade();
		System.out.println("LISTAR TODAS CIDADES");
		List<Cidade> cid = dao.buscar();
			
		for(Cidade cidade : cid) {
			System.out.println("Id: "+cidade.getId()+" Cidade: "+cidade.getNome()+" Estado: "+cidade.getEstado().getSigla());
		}
		}
}
