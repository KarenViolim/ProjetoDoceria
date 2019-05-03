package telas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;

import dao.daoAdministrador;
import dao.daoAgenda;
import entidade.Administrador;
import entidade.Agenda;
import fabrica.Fabrica;

public class TelaAdministrador {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Fabrica.get();
		daoAdministrador dao = new daoAdministrador();
		Administrador administrador = new Administrador();
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
				System.out.println("INSERIR ADMINISTRADOR");
				System.out.println("USUÁRIO: ");
				String usuario = scann.nextLine();
				administrador.setUsuario(usuario);
				System.out.println("E-MAIL: ");
				String email = scann.nextLine();
				administrador.setEmail(email);
				System.out.println("SENHA: ");
				String senha = scann.nextLine();
				administrador.setSenha(senha);
				
				dao.inserir(administrador);
			}
			if (opcao == 2) {
				listarCadastrosAdministrador();
			}
			if (opcao == 3) {
				listarCadastrosAdministrador();
				System.out.println("ALTERAR ADMINISTRADOR");
				System.out.println("INSIRA O ID DO ADMINISTRADOR QUE DESEJA ALTERAR: ");
				Long idadm = scann.nextLong();
				administrador.setIdadm(idadm);
				System.out.println("NOVO USUÁRIO: ");
				String usuario = scann.next();
				administrador.setUsuario(usuario);
				System.out.println("NOVO E-MAIL: ");
				String email = scann.next();
				administrador.setEmail(email);
				System.out.println("NOVA SENHA: ");
				String senha = scann.next();
				administrador.setSenha(senha);
				
				dao.alterar(administrador);
			}
			if (opcao == 4) {
				listarCadastrosAdministrador();
				System.out.println("EXCLUIR ADMINISTRADOR");
				System.out.println("INSIRA O ID DO ADMINISTRADOR QUE DESEJA EXCLUIR: ");
				administrador.setIdadm(scann.nextLong());
				dao.excluir(administrador);
			}
		}while (opcao != 5);
	}
	public static void listarCadastrosAdministrador() {
		daoAdministrador dao = new daoAdministrador();
		System.out.println("CONSULTAR ADMINISTRADOR:");
		List<Administrador> adm = dao.buscar();

		for (Administrador administrador : adm) {
			System.out.println("Id: "+administrador.getIdadm()+" Usuário: "+administrador.getUsuario()+" - E-mail: : "+administrador.getEmail()+" - Senha:"+administrador.getSenha());
		}		
	}
}
