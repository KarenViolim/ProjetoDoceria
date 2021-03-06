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

import com.Karen.ProjetoDoceria.models.Estado;
import com.Karen.ProjetoDoceria.repository.EstadoRepository;

@Controller
public class EstadoController {
	@Autowired
	public EstadoRepository repository;
	
	@GetMapping("/listarEstado")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/estado");
		List<Estado> estado = repository.findAll();
		mv.addObject("estado", estado);
		return mv;
	}
	
	@GetMapping("/adicionarEstado")
	public ModelAndView add(Estado estado) {
		ModelAndView mv = new ModelAndView("/addestado");
		mv.addObject("estado", estado);
		return mv;
	}
	@GetMapping("/editarEstado/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<Estado> estado = repository.findById(id);
		Estado e = estado.get();
		return add(e);
		
	}
	@GetMapping("/removerEstado/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<Estado> estado = repository.findById(id);
		Estado e = estado.get();
		repository.delete(e);
		return lista();
		
	}
	@PostMapping("/salvarEstado")
	public ModelAndView salvar(@Valid Estado estado, BindingResult result ) {
		if(result.hasErrors()) {
			
		}
		repository.saveAndFlush(estado);
		return lista();
	}

}