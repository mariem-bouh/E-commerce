package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce.metier.InternauteEcommerceMetier;

@Controller
@RequestMapping(value="/user")
public class InternauteEcommerceController {

	@Autowired
	private	InternauteEcommerceMetier internauteEcommerceMetier; 
	@RequestMapping(value="/index")
	public String Acceuil(Model model) {
		model.addAttribute("produit",internauteEcommerceMetier.listProduit());
		return "index";
	}


}
