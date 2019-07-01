package com.Karen.ProjetoDoceria.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Karen.ProjetoDoceria.models.ItensPedido;
import com.Karen.ProjetoDoceria.repository.ItensPedidoRepository;
import com.Karen.ProjetoDoceria.repository.PedidoRepository;
import com.Karen.ProjetoDoceria.repository.ProdutoRepository;

@Controller
public class ItensPedidoController {
	@Autowired 
	public ItensPedidoRepository repositoryItens;
	
	@Autowired
	public PedidoRepository repositoryPedido;
	
	@Autowired
	public ProdutoRepository repositoryProduto;
	
	@GetMapping("/listarItens")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/itens");
		List<ItensPedido> itenspedido = repositoryItens.findAll();
		mv.addObject("itens", itenspedido);
		return mv;
	}
	
	@GetMapping("/adicionarItens")
	public ModelAndView add(ItensPedido itenspedido) {
		ModelAndView mv = new ModelAndView("/additens");
		mv.addObject("itens", itenspedido);
		mv.addObject("pedido", repositoryPedido.findAll());
		mv.addObject("produto", repositoryProduto.findAll());
		return mv;
	}
	@GetMapping("/editarItens/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<ItensPedido> itenspedido = repositoryItens.findById(id);
		ItensPedido itens = itenspedido.get();
		return add(itens);
	}
	@GetMapping("/removerItens/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<ItensPedido> itenspedido = repositoryItens.findById(id);
		ItensPedido itens = itenspedido.get();
		repositoryItens.delete(itens);
		return lista();
	}
	@PostMapping("/salvarItens")
	public ModelAndView salvar(@Valid ItensPedido itenspedido, BindingResult result ) {
		if(result.hasErrors()) {
		}
		repositoryItens.saveAndFlush(itenspedido);
		return lista();
	}
}
