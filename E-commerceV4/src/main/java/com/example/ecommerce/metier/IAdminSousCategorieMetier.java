package com.example.ecommerce.metier;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.ecommerce.entities.Role;
import com.example.ecommerce.entities.SousCategorie;
import com.example.ecommerce.entities.Users;
@Service
public interface IAdminSousCategorieMetier extends InterfaceAdminProduitMetier{
	public Long AjouterSousCategorie(SousCategorie c);
	public void SupprimerSousCategorie(Long idCat);
	public List<SousCategorie> ListSousCategory();
	public void modifierSousCategorie(SousCategorie c);
	public SousCategorie getSousCategorie(Long idcat);
	public void AjouterUser(Users u);
	public void AttribuerRole(Role R,Long userid);

}
