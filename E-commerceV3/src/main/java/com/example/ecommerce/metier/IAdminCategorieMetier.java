package com.example.ecommerce.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.Categorie;
import com.example.ecommerce.entities.Role;
import com.example.ecommerce.entities.SousCategorie;
import com.example.ecommerce.entities.User;

@Service

public interface IAdminCategorieMetier extends InterfaceAdminProduitMetier,IAdminSousCategorieMetier{

	public Long AjouterCategorie(Categorie c);
	public void SupprimerCategorie(Long idCat);
	public void modifierCategorie(Categorie c);
	public void AjouterUser(User u);
	public void AttribuerRole(Role R,Long userid);
	
	

}
