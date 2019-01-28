package com.example.ecommerce.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable{
//dictionnaire
	private Map<Long,LigneCommande> items=new HashMap<Long, LigneCommande>();

//ajouter un article
	//ajout d'un produit avec une quantite a la liste
	public void addArticle(Produits p,int quantite) {
		//verification pour savoir si le produit est dans la liste
		if (items.get(p.getIdProduit())==null) {
		LigneCommande lc=new LigneCommande();
		//id produit
		lc.setProduit(p);
		lc.setQuantite(quantite);
		lc.setPrix(p.getPrix());
		}else {
			//je recupere la ligne de commande et je modifie la quantite
			LigneCommande lc=items.get(p.getIdProduit());
			lc.setQuantite(lc.getQuantite()+quantite);
		}
		
		//consultation de la liste des lignes de commande
		
		
	}
	
	//recuperation de la collection de la ligne de commnade
	public Collection<LigneCommande> getItem()
	{
		return items.values();
		
	}
	
	//total au niveau du panier
	
	public double getTotal() {
		double total=0;
		for (LigneCommande lc : items.values()) {
			total+=lc.getPrix()*lc.getQuantite();
		}
		return total;
	}
	
	//nombre de produit dans un panier
	public int getSize() {
		return items.size();
	}
	
	
	//suprimer une ligne de panier
	public void deleteItems(Long idproduit) {
		//suppression de la clef
		items.remove(idproduit);
	}
}
