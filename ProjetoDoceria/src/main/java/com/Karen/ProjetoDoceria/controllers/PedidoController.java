package com.Karen.ProjetoDoceria.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Karen.ProjetoDoceria.models.ItensPedido;
import com.Karen.ProjetoDoceria.models.Pedido;
import com.Karen.ProjetoDoceria.repository.AgendaRepository;
import com.Karen.ProjetoDoceria.repository.ClienteRepository;
import com.Karen.ProjetoDoceria.repository.ItensPedidoRepository;
import com.Karen.ProjetoDoceria.repository.PedidoRepository;
import com.Karen.ProjetoDoceria.repository.ProdutoRepository;

@Controller
public class PedidoController {
	@Autowired
	public PedidoRepository repositoryPedido;
	
	@Autowired
	public ItensPedidoRepository repositoryItens;
	
	@Autowired
	public ClienteRepository repositoryCliente;
	
	@Autowired
	public ProdutoRepository repositoryProduto;
	
	private Pedido pedido = new Pedido();
	private ItensPedido itensPedido = new ItensPedido();
	private List<ItensPedido> listaItensPedido = new ArrayList<>();
	
	
//	@GetMapping("/listarPedidos")
//	public ModelAndView lista() {
//		ModelAndView mv = new ModelAndView("/pedido");
//		List<Pedido> pedido = repositoryPedido.findAll();
//		mv.addObject("pedido", pedido);
//		return mv;
//	}
	
	@GetMapping("/adicionarPedido")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("/pedidoadd");
		mv.addObject("pedido", this.pedido);
		mv.addObject("itensPedido", this.itensPedido);
		mv.addObject("cliente", repositoryCliente.findAll());
		mv.addObject("produto", repositoryProduto.findAll());
		return mv;
	}
//	@GetMapping("/editarPedido/{id}")
//	public ModelAndView editar(@PathVariable("id") Long id){
//		Optional<Pedido> pedido = repositoryPedido.findById(id);
//		Pedido p = pedido.get();
//		return add(p);
//	}
//	@GetMapping("/removerPedido/{id}")
//	public ModelAndView remover(@PathVariable("id") Long id){
//		Optional<Pedido> pedido = repositoryPedido.findById(id);
//		Pedido p = pedido.get();
//		repositoryPedido.delete(p);
//		return lista();
//	}
	@PostMapping("/salvarPedido")
	public ModelAndView salvar(@Valid Pedido pedido, @Valid ItensPedido itensPedido, 
			BindingResult result, String acao ) {
		
		this.pedido = pedido;
		
		if (acao.equals("item")) {
			listaItensPedido.add(itensPedido);
		} else if (acao.equals("salvar")) {
			System.out.println("Teste");
			//SALVAR A VENDA NO BANCO DE DADOS..
			this.pedido.setDataVenda(new Date());
			repositoryPedido.saveAndFlush(this.pedido);
			for(ItensPedido it:listaItensPedido) {
				it.setPedido(this.pedido);
				repositoryItens.saveAndFlush(it);
			}
			this.pedido = new Pedido();
			this.listaItensPedido = new ArrayList<>();
		}
		
		System.out.println("Quantidade Itens: " + listaItensPedido.size());
		System.out.println(this.pedido.getStatusPedido());
		System.out.println(itensPedido.getQuantidade());
		return add();
	}
}
