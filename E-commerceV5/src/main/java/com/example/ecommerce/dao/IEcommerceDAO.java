package com.example.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.Categorie;
import com.example.ecommerce.entities.Commande;
import com.example.ecommerce.entities.LigneCommande;
import com.example.ecommerce.entities.Panier;
import com.example.ecommerce.entities.Produits;
import com.example.ecommerce.entities.Role;
import com.example.ecommerce.entities.SousCategorie;
import com.example.ecommerce.entities.Users;

@Service
public interface IEcommerceDAO {
	public Long AjouterCategorie(Categorie c);
	public List<Categorie> listCategorie();
	public Categorie getCategorie(Long idcat);
	public void SupprimerCategorie(Long idCat);
	public void modifierCategorie(Categorie c);

	public Long AjouterSousCategorie(SousCategorie c);
	public List<SousCategorie> listSousCategorie();
	public SousCategorie getSousCategorie(Long idcat);
	public void SupprimerSousCategorie(Long idCat);
	public void modifierSousCategorie(SousCategorie c);

	
	public Long AjouterProduit(Produits p, Long idCAT);
	public List<Produits> Listproduits();
	public List<Produits> produitsParMotcle(String mc);
	List<Produits> produitParSousCategorie(Long idcat);
	public List<Produits> produitSelectonner();
	public Produits getProduit(Long idP);
	public void supprimerProduit(Long idp);
	public void modifierProduit(Produits p);
	
	
	public void AjouterUser(Users u);
	public void AttribuerRole(Role R,Long userid);
	public Commande enregistrerCommnde(Panier p,Users c);
	
	public List<LigneCommande> findByCommande(Commande commande);
	public LigneCommande get(Long id);
	public boolean AjouterLigneCMD(LigneCommande ligneCommande);
	public boolean ModifierLigneCMD(LigneCommande ligneCommande);
	public boolean SupprimerLigneCMD(Long idligneCommande);
    public List<LigneCommande> listCMD(Long idCMD );
    public List<LigneCommande> listCMD(Commande commande);
public LigneCommande getByCartAndProduct(Long idCMD,Long IDProduit);
public LigneCommande getByCartAndProduct(Commande commande, Produits produit);
//public LigneCommande getByCartAndProduct(int idCMD, int IDProduit);
public List<LigneCommande> findByPanier(Panier panier);




	
}
