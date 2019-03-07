package com.example.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.ecommerce.entities.LigneCommande;
import com.example.ecommerce.entities.Panier;
import com.example.ecommerce.entities.Produits;
import com.example.ecommerce.entities.UserModel;
import com.example.ecommerce.metier.IAdminCategorieMetier;
import com.example.ecommerce.metier.ILigneDeCommandeMetier;
import com.example.ecommerce.metier.InternauteEcommerceMetier;

@Controller
@RequestMapping(value="/user/panier/")
public class PanierEcommerceController {

	@Autowired
	private	InternauteEcommerceMetier internauteEcommerceMetier;
	@Autowired
	private ILigneDeCommandeMetier LigneDeCommandeMetier;
	@Autowired
	private IAdminCategorieMetier iAdminCategorieMetier; 
	@Autowired
	private HttpSession session;
	

	@RequestMapping(value="add{id_product}")
	public RedirectView jouterAuPanier(@RequestParam(value="id_product") String id_Prod ) {

RedirectView redirectView=new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl("add1?id_product="+id_Prod);
		return redirectView;
	}

	

	@RequestMapping("add1")
	public String outerAuPanier(Model model,@RequestParam(value="id_product") String id_Prod ) {

		/*
		 * Verifier que le produit que l'on tente d'ajouter n'existe pas deja dans le panier
		 */

		UserModel utilisateur=(UserModel) session.getAttribute("userModel");

		if (session.getAttribute("userModel")!=null) {
			//1.Recuperation de l'id du panier a partir de la session
			Panier panier=utilisateur.getPanier();
			
			System.out.println("Recuperation de l'id du panier a partir de la session");
			System.out.println("id_prod:"+id_Prod);			
			System.out.println("Panier:"+panier.toString());
			
		   //2.verification de l'existance de l'id panier et de l'id produit dans la ligne de CMD
			LigneCommande ligneCommande=LigneDeCommandeMetier.getByCartAndProduct(panier.getIdPanier(),Long.parseLong(id_Prod));
		    if (ligneCommande==null) {
				//ajout de la ligne de CMD
		    	LigneCommande ligneCommande2=new LigneCommande();
		    	//recuperation du produit
		    	Produits produits=iAdminCategorieMetier.getProduit(Long.parseLong(id_Prod));
		    	ligneCommande2.setPrix(produits.getPrix());
		    	ligneCommande2.setQuantite(1);
		    	ligneCommande2.setTotal(produits.getPrix());
		    	ligneCommande2.setPanier(panier);
		    	ligneCommande2.setProduit(produits);
		    	LigneDeCommandeMetier.AjouterLigneCMD(ligneCommande2);
		    //3.Modification du total du panier
		    	double GrandTotalCourant=panier.getTotal();
				double totalDeLaLigneDeCMD=ligneCommande2.getTotal();
		         //modification du total du panier
		         panier.setTotal(GrandTotalCourant+totalDeLaLigneDeCMD);
		         internauteEcommerceMetier.ModifTotalPanier(panier);
		         //4.modification de la session
		         utilisateur.setPanier(panier);
		

			}
		}
		
		
		/*
		 * Fin Verification
		 */
		
		
		
		//1.on enregistre la commande puis on recupere l'id
		
		//2.on enregistre dans la ligne de CMD id_CMD/id_Panier/id_produit/le prix =>total==prix()quantiter pa defaut 1
		//	model.addAttribute("produit",internauteEcommerceMetier.listProduit());
		
		return "redirect:../panierCMD";
	}

	
}
