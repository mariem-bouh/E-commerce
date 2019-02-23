package com.example.ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class LigneCommande implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produits produit;
//	private double total;
	private int quantite;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	private double prix;
	
	private double total;
	
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;
	
	
	@ManyToOne
	@JoinColumn(name="idPanier")
	private Panier panier;
	
	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", produit=" + produit + ", quantite=" + quantite + ", prix=" + prix
				+ ", commande=" + commande + ", panier=" + panier + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produits getProduit() {
		return produit;
	}
	public void setProduit(Produits produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Commande getCommande() {
		return commande;
	}
	public LigneCommande(int quantite, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
}
