package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Accueil {

	@RequestMapping(value="/accueil")	
	public String index() {
		
		return "index";
	}
}
