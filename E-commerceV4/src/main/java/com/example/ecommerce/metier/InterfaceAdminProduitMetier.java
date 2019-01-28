package com.example.ecommerce.metier;

import com.example.ecommerce.entities.Produits;

public interface InterfaceAdminProduitMetier extends InternauteEcommerceMetier {

	public Long AjouterProduit(Produits p, Long idCAT);
	public void supprimerProduit(Long idp);
	public void modifierProduit(Produits p);
}
