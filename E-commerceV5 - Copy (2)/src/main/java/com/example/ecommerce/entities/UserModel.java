package com.example.ecommerce.entities;

import java.io.Serializable;
import java.util.Collection;

public class UserModel implements Serializable{

	private Long id;
	private String fullname;
	private String email;
	private String role;
	private Panier panier;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fullname=" + fullname + ", email=" + email + ", role=" + role + ", panier="
				+ panier + "]";
	}	
	
}
