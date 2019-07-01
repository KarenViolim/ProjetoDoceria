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

import com.Karen.ProjetoDoceria.models.Funcionario;
import com.Karen.ProjetoDoceria.repository.CidadeRepository;
import com.Karen.ProjetoDoceria.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
	@Autowired
	public FuncionarioRepository repositoryFunc;
	
	@Autowired
	public CidadeRepository repositoryCidade;
	
	@GetMapping("/listarFuncionario")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/funcionario");
		List<Funcionario> funcionario = repositoryFunc.findAll();
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	
	@GetMapping("/adicionarFuncionario")
	public ModelAndView add(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("/addfuncionario");
		mv.addObject("funcionario", funcionario);
		mv.addObject("cidade", repositoryCidade.findAll());
		return mv;
	}
	@GetMapping("/editarFuncionario/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<Funcionario> funcionario = repositoryFunc.findById(id);
		Funcionario func = funcionario.get();
		return add(func);
	}
	@GetMapping("/removerFuncionario/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<Funcionario> funcionario = repositoryFunc.findById(id);
		Funcionario func = funcionario.get();
		repositoryFunc.delete(func);
		return lista();
	}
	@PostMapping("/salvarFuncionario")
	public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult result ) {
		if(result.hasErrors()) {
		}
		repositoryFunc.saveAndFlush(funcionario);
		return lista();
	}
}
