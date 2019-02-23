package com.example.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce.entities.LigneCommande;
import com.example.ecommerce.entities.Panier;
import com.example.ecommerce.entities.UserModel;
import com.example.ecommerce.metier.ILigneDeCommandeMetier;
import com.example.ecommerce.metier.InternauteEcommerceMetier;

@Controller
@RequestMapping(value="/user")
public class InternauteEcommerceController {

	@Autowired
	private	InternauteEcommerceMetier internauteEcommerceMetier;
	@Autowired
	private ILigneDeCommandeMetier LigneDeCommandeMetier;
	@Autowired
	private HttpSession session;
	@RequestMapping(value="/index")
	public String Acceuil(Model model) {
		model.addAttribute("produit",internauteEcommerceMetier.listProduit());
		return "index";
	}

	@RequestMapping(value="/panier")
	public String panier(Model model) {
		/*
		 *recuperation d'une ligne de commande de l'utilisateur courant
		 * 
		*/
		//1.recuperation du panier de l'utilisateur courant
		
		UserModel utilisateur=(UserModel) session.getAttribute("userModel");

		if (session.getAttribute("userModel")!=null) {
			System.out.println("recuperation du panier de l'utilisateur courant");
			
			System.out.println( utilisateur.toString());
			if(utilisateur.getPanier()==null) {
				model.addAttribute("ligneCommande",0);
			}else {
				//recuperation de l'id du panier
				Panier panier=utilisateur.getPanier();
				
				//liste des ligne de commande pour ce panier
				model.addAttribute("ligneCommandePanier",LigneDeCommandeMetier.findByPanier(panier));
				List<LigneCommande> ligneCommande =LigneDeCommandeMetier.findByPanier(panier);
				for (int i = 0; i < ligneCommande.size(); i++) {
					LigneCommande ligneCommande2=ligneCommande.get(i);
				System.out.println(" la desigantion des produits :"+  ligneCommande2.getProduit().getDesignation());
				}
				
				//total dans le panier pour l'utilisateur courant
				model.addAttribute("totalPanier",utilisateur.getPanier().getTotal());
				model.addAttribute("ligneCommande",1);
			}
				
		}else {
			//dans le cas uo il n'est pas connecter
			model.addAttribute("ligneCommande",0);
			
		}
		
		
		//model.addAttribute("ligneCommande",LigneDeCommandeMetier.listCMD(idCMD));
		
		return "panier";
	}

	
}
