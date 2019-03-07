package com.example.ecommerce.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class SousCategorie implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idsousCategorie;
	private String nomSousCategorie;
	@OneToMany(mappedBy="souscategorie",fetch=FetchType.EAGER)
	private Collection<Produits> produits;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idCategorie")
	
	private Categorie categorie;
	
	
	public SousCategorie() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Collection<Produits> getProduits() {
		return produits;
	}



	public void setProduits(Collection<Produits> produits) {
		this.produits = produits;
	}



	public Categorie getCategorie() {
		return categorie;
	}



	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}



	public Long getIdsousCategorie() {
		return idsousCategorie;
	}



	public void setIdsousCategorie(Long idsousCategorie) {
		this.idsousCategorie = idsousCategorie;
	}



	public String getNomSousCategorie() {
		return nomSousCategorie;
	}



	public void setNomSousCategorie(String nomSousCategorie) {
		this.nomSousCategorie = nomSousCategorie;
	}



	public SousCategorie(String nomSousCategorie) {
		super();
		this.nomSousCategorie = nomSousCategorie;
	}
	
}
