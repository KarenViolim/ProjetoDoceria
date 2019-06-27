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

import com.Karen.ProjetoDoceria.models.Pedido;
import com.Karen.ProjetoDoceria.repository.ClienteRepository;
import com.Karen.ProjetoDoceria.repository.PedidoRepository;

@Controller
public class PedidoController {
	@Autowired
	public PedidoRepository repositoryPedido;
	
	@Autowired
	public ClienteRepository repositoryCliente;
	
	@GetMapping("/listarPedidos")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/listarPedidos");
		List<Pedido> pedido = repositoryPedido.findAll();
		mv.addObject("pedido", pedido);
		return mv;
	}
	
	@GetMapping("/cadastrarPedido")
	public ModelAndView add(Pedido pedido) {
		ModelAndView mv = new ModelAndView("/cadastrarPedido");
		mv.addObject("pedido", pedido);
		mv.addObject("cliente", repositoryCliente.findAll());
		return mv;
	}
	@GetMapping("/editarPedido/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<Pedido> pedido = repositoryPedido.findById(id);
		Pedido p = pedido.get();
		return add(p);
	}
	@GetMapping("/removerPedido/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<Pedido> pedido = repositoryPedido.findById(id);
		Pedido p = pedido.get();
		repositoryPedido.delete(p);
		return lista();
	}
	@PostMapping("/salvarPedido")
	public ModelAndView salvar(@Valid Pedido pedido, BindingResult result ) {
		if(result.hasErrors()) {
		}
		repositoryPedido.saveAndFlush(pedido);
		return lista();
	}
}
