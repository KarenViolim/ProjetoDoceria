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

import com.Karen.ProjetoDoceria.models.Agenda;
import com.Karen.ProjetoDoceria.repository.AgendaRepository;

@Controller
public class AgendaController{
	@Autowired
	public AgendaRepository repositoryAgenda;
	
	@GetMapping("/listarAgenda")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/agenda");
		List<Agenda> agenda = repositoryAgenda.findAll();
		mv.addObject("agenda", agenda);
		return mv;
	}
	
	@GetMapping("/adicionarAgenda")
	public ModelAndView add(Agenda agenda) {
		ModelAndView mv = new ModelAndView("/addagenda");
		mv.addObject("agenda", agenda);
		return mv;
	}
	@GetMapping("/editarAgenda/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<Agenda> agenda = repositoryAgenda.findById(id);
		Agenda ag = agenda.get();
		return add(ag);
	}
	@GetMapping("/removerAgenda/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<Agenda> agenda = repositoryAgenda.findById(id);
		Agenda ag = agenda.get();
		repositoryAgenda.delete(ag);
		return lista();
	}
	@PostMapping("/salvarAgenda")
	public ModelAndView salvar(@Valid Agenda agenda, BindingResult result ) {
		if(result.hasErrors()) {
		}
		repositoryAgenda.saveAndFlush(agenda);
		return lista();
	}
}
