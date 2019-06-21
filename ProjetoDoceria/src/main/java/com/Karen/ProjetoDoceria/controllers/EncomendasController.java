package com.Karen.ProjetoDoceria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncomendasController {
	@RequestMapping("/encomendas")
	public String encomendas() {
		return"encomendas";
	}
}
