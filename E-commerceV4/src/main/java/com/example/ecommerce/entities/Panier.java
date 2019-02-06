package com.example.ecommerce.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Panier implements Serializable{
@Id

@GeneratedValue
private Long idPanier;

private double total;

@OneToOne(fetch=FetchType.EAGER)
private Users users;

@OneToMany(mappedBy="panier")
private Collection<LigneCommande> ligneCommandes;

public Panier() {
	super();
	// TODO Auto-generated constructor stub
}
public Panier(double total) {
	super();
	this.total = total;
}
public Long getIdPanier() {
	return idPanier;
}
public void setIdPanier(Long idPanier) {
	this.idPanier = idPanier;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}

public Users getUsers() {
	return users;
}
public void setUsers(Users users) {
	this.users = users;
}
public Collection<LigneCommande> getLigneCommandes() {
	return ligneCommandes;
}
public void setLigneCommandes(Collection<LigneCommande> ligneCommandes) {
	this.ligneCommandes = ligneCommandes;
}
	
	
}
