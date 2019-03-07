package com.example.ecommerce.controller;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecommerce.entities.LigneCommande;
import com.example.ecommerce.entities.Panier;
import com.example.ecommerce.entities.UserModel;
import com.example.ecommerce.entities.Users;
import com.example.ecommerce.metier.IAdminCategorieMetier;
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
	private IAdminCategorieMetier iAdminCategorieMetier; 
	@Autowired
	private HttpSession session;
	@RequestMapping(value="/index")
	public String Acceuil(Model model) {
		model.addAttribute("produit",internauteEcommerceMetier.listProduit());
		return "index";
	}

	@RequestMapping(value="/deleteCMD",method=RequestMethod.GET)
	public String deleteCMD(Long id) {
		System.out.println("a supprimer " +id);
		
		double GrandTotalCourant=0;
		double totalDeLaLigneDeCMD=0;

		UserModel utilisateur=(UserModel) session.getAttribute("userModel");

		if (session.getAttribute("userModel")!=null) {
			GrandTotalCourant=utilisateur.getPanier().getTotal();
			// modification du grand total
			
			LigneCommande ligneCommande=LigneDeCommandeMetier.findById(id);
			totalDeLaLigneDeCMD=ligneCommande.getTotal();
			double GrandTotal=GrandTotalCourant-totalDeLaLigneDeCMD;
			
			
			Panier panier=ligneCommande.getPanier();
	       
	       
	         //modification du total du panier
	         panier.setTotal(GrandTotal);
	         internauteEcommerceMetier.ModifTotalPanier(panier);
	
		}
			        
		LigneDeCommandeMetier.SupprimerLigneCMD(id);
		
		return "redirect:panierCMD";
	}
	@RequestMapping(value="/panierCMD")
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
				
		         /*
		          * total dans le panier pour l'utilisateur courant
		          */
				UserModel userModel= (UserModel) session.getAttribute("userModel");
				//1.recuperation de l'uttilisateur
				Users users = users=iAdminCategorieMetier.findByUsername(userModel.getFullname());
				//2.recuperation du panier concernant cet utilisateurs
				Panier panier2 =internauteEcommerceMetier.findByUser(users);
				userModel.getPanier().setTotal(panier2.getTotal());
				//System.out.println("GrandTotal"+GrandTotal);
		         /*
		          * fin total dans le panier pour l'utilisateur courant
		          */
				
				model.addAttribute("totalPanier",utilisateur.getPanier().getTotal());
				System.out.println("le grand total" + utilisateur.getPanier().getTotal());
				model.addAttribute("ligneCommande",1);
			}
				
		}else {
			//dans le cas uo il n'est pas connecter
			model.addAttribute("ligneCommande",0);
			
		}
		
		
		//model.addAttribute("ligneCommande",LigneDeCommandeMetier.listCMD(idCMD));
		System.out.println("ssssssssss");
				
		return "panier";
	}
	@PostMapping(value="ActuLigneCMD")
	public String ActuLigneCMD(Model model,@RequestParam("quantiter")int quantiter,@RequestParam("Acutualiser")Long IDligneCMD) {
		System.out.println("dddddddddddddddddd");
		System.out.println(quantiter);
		System.out.println(IDligneCMD);
		
		LigneCommande ligneCommande=LigneDeCommandeMetier.findById(IDligneCMD);
		System.out.println("LCMD"+ligneCommande.toString());
		ligneCommande.setQuantite(quantiter);
		//modification du total
		double Total=ligneCommande.getQuantite()*ligneCommande.getPrix();
		ligneCommande.setTotal(Total);
		//Enregistrement de la modification
		LigneDeCommandeMetier.AjouterLigneCMD(ligneCommande);
		
		
		// modification du grand total
		Panier panier=ligneCommande.getPanier();
         List<LigneCommande> ligneCommande2= LigneDeCommandeMetier.findByPanier(panier);
         double GrandTotal=0;
         for (int i = 0; i < ligneCommande2.size(); i++) {
			GrandTotal+=ligneCommande2.get(i).getTotal();
		}
       
         //modification du total du panier
         panier.setTotal(GrandTotal);
         internauteEcommerceMetier.ModifTotalPanier(panier);
         
         /*
          * total dans le panier pour l'utilisateur courant
          */
       //
			UserModel userModel= (UserModel) session.getAttribute("userModel");
			//1.recuperation de l'uttilisateur
			Users users = users=iAdminCategorieMetier.findByUsername(userModel.getFullname());
			//2.recuperation du panier concernant cet utilisateurs
			Panier panier2 =internauteEcommerceMetier.findByUser(users);
			userModel.getPanier().setTotal(panier2.getTotal());
	         /*
	          * fin total dans le panier pour l'utilisateur courant
	          */
			return "redirect:index";
	
	}
	
		
}
