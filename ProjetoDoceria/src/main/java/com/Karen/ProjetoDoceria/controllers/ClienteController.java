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
public class ClienteController {
	@Autowired
	public ClienteRepository repositoryCliente;
	
	@Autowired
	public CidadeRepository repositoryCidade;
	
	@Autowired
	public EstadoRepository repository;
	
	@GetMapping("/listarCliente")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/cliente");
		List<Cliente> cliente = repositoryCliente.findAll();
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@GetMapping("/adicionarCliente")
	public ModelAndView add(Cliente cliente) {
		ModelAndView mv = new ModelAndView("/addcliente");
		mv.addObject("cliente", cliente);
		mv.addObject("cidade", repositoryCidade.findAll());
		mv.addObject("estado", repository.findAll());
		return mv;
	}
	@GetMapping("/editarCliente/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<Cliente> cliente = repositoryCliente.findById(id);
		Cliente cli = cliente.get();
		return add(cli);
	}
	@GetMapping("/removerCliente/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<Cliente> cliente = repositoryCliente.findById(id);
		Cliente cli = cliente.get();
		repositoryCliente.delete(cli);
		return lista();
	}
	@PostMapping("/salvarCliente")
	public ModelAndView salvar(@Valid Cliente cliente, BindingResult result ) {
		if(result.hasErrors()) {
		}
		repositoryCliente.saveAndFlush(cliente);
		return lista();
	}
}
