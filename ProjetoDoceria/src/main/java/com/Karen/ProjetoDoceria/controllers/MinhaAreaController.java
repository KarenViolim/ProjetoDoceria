package com.Karen.ProjetoDoceria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MinhaAreaController {
	@RequestMapping("/minhaarea")
	public String minhaarea() {
		return"minhaarea";
	}

}
