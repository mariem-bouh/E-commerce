package com.example.ecommerce.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long iduser;
 private String username;
 private String password;
 private boolean actived;
 @OneToMany()
 @JoinColumn(name="user_id")
 private Collection<Role>roles;
public Long getIduser() {
	return iduser;
}
public void setIduser(Long iduser) {
	this.iduser = iduser;
}
public String getUserName() {
	return username;
}
public void setUserName(String userName) {
	this.username = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isActived() {
	return actived;
}
public void setActived(boolean actived) {
	this.actived = actived;
}
public Collection<Role> getRoles() {
	return roles;
}
public void setRoles(Collection<Role> roles) {
	this.roles = roles;
}
public User(String userName, String password, boolean actived) {
	super();
	this.username = userName;
	this.password = password;
	this.actived = actived;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}

}
