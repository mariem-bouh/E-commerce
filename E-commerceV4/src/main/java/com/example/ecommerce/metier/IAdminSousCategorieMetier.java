package com.example.ecommerce.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.Categorie;
import com.example.ecommerce.entities.Role;
import com.example.ecommerce.entities.SousCategorie;
import com.example.ecommerce.entities.User;
@Service
public interface IAdminSousCategorieMetier extends InterfaceAdminProduitMetier{
	public Long AjouterSousCategorie(SousCategorie c);
	public void SupprimerSousCategorie(Long idCat);
	public List<SousCategorie> ListSousCategory();
	public void modifierSousCategorie(SousCategorie c);
	public SousCategorie getSousCategorie(Long idcat);
	public void AjouterUser(User u);
	public void AttribuerRole(Role R,Long userid);

}
