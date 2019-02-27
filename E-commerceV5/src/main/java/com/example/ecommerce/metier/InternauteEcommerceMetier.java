package com.example.ecommerce.metier;

import java.util.List;
import java.util.Optional;

import com.example.ecommerce.entities.Categorie;
import com.example.ecommerce.entities.Commande;
import com.example.ecommerce.entities.Panier;
import com.example.ecommerce.entities.Produits;
import com.example.ecommerce.entities.Users;

public interface InternauteEcommerceMetier {

	
	public List<Categorie> listCtegorie();
	public Categorie getCategorie(Long idcat);
	public List<Produits> listProduit();
	public List<Produits> produitParMotClef(String mc);
	public List<Produits> produitParCategorie(Long idcat);
	public List<Produits> produitSelectionner();
	public Produits getProduit(Long idP);
	public Commande enregistrerCommnde(Panier p,Users c);
	public Panier ModifTotalPanier(Panier panier);
	public Panier findByUser(Users users);

}
