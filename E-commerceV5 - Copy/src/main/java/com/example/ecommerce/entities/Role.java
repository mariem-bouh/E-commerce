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
public class Role implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long idRole;
 private String roleName;
 
 @ManyToOne
 @JoinColumn(name="iduser")
 private Users users;
 
public Long getIdRole() {
	return idRole;
}
public void setIdRole(Long idRole) {
	this.idRole = idRole;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public Role() {
	super();
	// TODO Auto-generated constructor stub
}
public Role(String roleName) {
	super();
	this.roleName = roleName;
}
  
}
