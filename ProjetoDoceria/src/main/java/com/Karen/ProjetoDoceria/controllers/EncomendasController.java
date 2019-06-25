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

import com.Karen.ProjetoDoceria.models.Cliente;
import com.Karen.ProjetoDoceria.repository.CidadeRepository;
import com.Karen.ProjetoDoceria.repository.ClienteRepository;
import com.Karen.ProjetoDoceria.repository.EstadoRepository;

@Controller
public class EncomendasController {
	@Autowired
	public ClienteRepository repositoryCliente;
	
	@Autowired
	public CidadeRepository repositoryCidade;
	
	@Autowired
	public EstadoRepository repository;
	
	@GetMapping("/listaEncomendas")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/listaEncomendas");
		List<Cliente> cliente = repositoryCliente.findAll();
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@GetMapping("/encomendas")
	public ModelAndView add(Cliente cliente) {
		ModelAndView mv = new ModelAndView("/encomendas");
		mv.addObject("cliente", cliente);
		mv.addObject("cidade", repositoryCidade.findAll());
		mv.addObject("estado", repository.findAll());
		return mv;
	}
	@GetMapping("/editarEncomenda/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<Cliente> cliente = repositoryCliente.findById(id);
		Cliente cli = cliente.get();
		return add(cli);
	}
	@GetMapping("/removerEncomenda/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<Cliente> cliente = repositoryCliente.findById(id);
		Cliente cli = cliente.get();
		repositoryCliente.delete(cli);
		return lista();
	}
	@PostMapping("/salvarEncomenda")
	public ModelAndView salvar(@Valid Cliente cliente, BindingResult result ) {
		if(result.hasErrors()) {
		}
		repositoryCliente.saveAndFlush(cliente);
		return lista();
	}
}
