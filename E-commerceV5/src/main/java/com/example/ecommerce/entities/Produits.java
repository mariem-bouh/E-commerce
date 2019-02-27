package com.example.ecommerce.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Produits implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
    @NotEmpty
   // @Size(min=4,max=15)
	private String designation;
    private String description;
	private double prix;
	private Boolean selected;
	private String photo;
	private int quantite;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idSousCategorie")
	private SousCategorie souscategorie;
	public Produits() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdProduit() {
		return idProduit;
	}
	
	@Override
	public String toString() {
		return "Produits [idProduit=" + idProduit + ", designation=" + designation + ", description=" + description
				+ ", prix=" + prix + ", selected=" + selected + ", photo=" + photo + ", quantite=" + quantite
				+ ", souscategorie=" + souscategorie + "]";
	}
	public Produits(String designation, String description, double prix, String photo, int quantite) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.photo = photo;
		this.quantite = quantite;

	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public SousCategorie getSouscategorie() {
		return souscategorie;
	}
	public void setSouscategorie(SousCategorie souscategorie) {
		this.souscategorie = souscategorie;
	}

	

}
