package com.example.ecommerce.metier;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.Categorie;
import com.example.ecommerce.entities.Role;

import com.example.ecommerce.entities.Users;

@Service

public interface IAdminCategorieMetier extends InterfaceAdminProduitMetier,IAdminSousCategorieMetier{

	public Long AjouterCategorie(Categorie c);
	public void SupprimerCategorie(Long idCat);
	public void modifierCategorie(Categorie c);
	public void AjouterUser(Users u);
	public void AttribuerRole(Role R,Long userid);
	public Users findByUsername(String name);
	

}
