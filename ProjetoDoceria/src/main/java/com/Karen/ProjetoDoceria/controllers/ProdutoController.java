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

import com.Karen.ProjetoDoceria.models.Produto;
import com.Karen.ProjetoDoceria.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	@Autowired
	public ProdutoRepository repositoryProduto;
	
	@GetMapping("/listarProduto")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/produto");
		List<Produto> produto = repositoryProduto.findAll();
		mv.addObject("produto", produto);
		return mv;
	}
	
	@GetMapping("/adicionarProduto")
	public ModelAndView add(Produto produto) {
		ModelAndView mv = new ModelAndView("/addproduto");
		mv.addObject("produto", produto);
		return mv;
	}
	@GetMapping("/editarProduto/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<Produto> produto = repositoryProduto.findById(id);
		Produto prod = produto.get();
		return add(prod);
	}
	@GetMapping("/removerProduto/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<Produto> produto = repositoryProduto.findById(id);
		Produto prod = produto.get();
		repositoryProduto.delete(prod);
		return lista();
	}
	@PostMapping("/salvarProduto")
	public ModelAndView salvar(@Valid Produto produto, BindingResult result ) {
		if(result.hasErrors()) {
		}
		repositoryProduto.saveAndFlush(produto);
		return lista();
	}
}
