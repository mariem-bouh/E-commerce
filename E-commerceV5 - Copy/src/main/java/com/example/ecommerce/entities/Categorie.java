package com.example.ecommerce.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
public class Categorie implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcategorie;
	@NotEmpty
	//@Size(min=4,max=20)
	private String nomCategorie;
	private String description;
	private String photo;
//	private Boolean boolean1;
	//dans la table produit il y'a un champ categorie
	@OneToMany(mappedBy="categorie",fetch=FetchType.EAGER)
	private Collection<SousCategorie> sousCategories;
	public Long getIdcategorie() {
		return idcategorie;
	}
	public void setIdcategorie(Long idcategorie) {
		this.idcategorie = idcategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public Collection<SousCategorie> getSousCategories() {
		return sousCategories;
	}
	public void setSousCategories(Collection<SousCategorie> sousCategories) {
		this.sousCategories = sousCategories;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String nomCategorie, String description, String photo) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.photo = photo;
	}
	
}
