package com.example.ecommerce.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
public class EcommerceDAOImpl implements IEcommerceDAO {
	
	@Autowired
	private SousCategorieRepository sousCategorieRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private ProduitRepositorie produitRepositorie;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	

	
	@Override
	public Long AjouterCategorie(Categorie c) {
		Categorie categorie = categorieRepository.save(c);
		return categorie.getIdcategorie();
	}

	@Override
	public List<Categorie> listCategorie() {

		return categorieRepository.findAll();
	}

	@Override
	public Categorie getCategorie(Long idcat) {

		return categorieRepository.findByIdCat(idcat);
	}

	@Override
	public void SupprimerCategorie(Long idCat) {
		categorieRepository.deleteById(idCat);
	}

	// a revoir
	@Override
	public void modifierCategorie(Categorie c) {
		categorieRepository.findById(c.getIdcategorie());

	}

	// a revoir
	@Override
	public Long AjouterProduit(Produits p, Long idsousCAT) {
		SousCategorie c = new SousCategorie();
		c.setIdsousCategorie(idsousCAT);
		p.setSouscategorie(c);
		// p.setCategorie(c.);
		p.setSouscategorie(c);
		Produits produits = produitRepositorie.save(p);

		return produits.getIdProduit();
	}

	@Override
	public List<Produits> Listproduits() {

		return produitRepositorie.findAll();
	}

	@Override
	public List<Produits> produitsParMotcle(String mc) {

		return produitRepositorie.chercher(mc);
	}

	@Override
	//a revoir
	public List<Produits> produitParSousCategorie(Long idcat) {

	 return produitRepositorie.findBysouscategorie(idcat);
	
	}

	@Override
	public List<Produits> produitSelectonner() {
		// recherche de tout les produits qui sont selectionner
		return produitRepositorie.findBySelected(true);
	}

	@Override
	public Produits getProduit(Long idP) {
		// consultation d'un produit
		return produitRepositorie.findByIdProd(idP);
	}

	@Override
	public void supprimerProduit(Long idp) {
		produitRepositorie.deleteById(idp);

	}

	// a revoir
	@Override
	public void modifierProduit(Produits p) {

	}

	@Override
	public void AjouterUser(Users u) {
		userRepository.save(u);

	}

	// a revoir ce gerer pa spring security
	@Override
	public void AttribuerRole(Role R, Long userid) {
		Optional<Users> user = userRepository.findById(userid);

	}


	@Override
	public Long AjouterSousCategorie(SousCategorie c) {
		SousCategorie sousCategorie=sousCategorieRepository.save(c);
		return sousCategorie.getIdsousCategorie();
	}

	@Override
	public List<SousCategorie> listSousCategorie() {
		// TODO Auto-generated method stub
		return sousCategorieRepository.findAll();
	}

	@Override
	public SousCategorie getSousCategorie(Long idcat) {
	
		return sousCategorieRepository.findByIdSousCAT(idcat);
	}

	@Override
	public void SupprimerSousCategorie(Long idCat) {
		  sousCategorieRepository.deleteById(idCat);
		
	}

	@Override
	public void modifierSousCategorie(SousCategorie c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Commande enregistrerCommnde(Panier p, Users c) {
		/*		// on enregistre d'habord le client
		ClientRepository.save(c);
		// cration d'une commande
		Commande commande = new Commande();
		// definition des informations sur la commande
		commande.setDate(new Date());
		// recuperation de la liste et stockage dans la commande
		commande.setItems(p.getItem());
		// enregistrement des items
		for (LigneCommande lc : p.getItem()) {
           ligneCommandeRepository.save(lc);
		}
		//enregistrement de la commande
		commandeRepository.save(commande);
		return commande;
	*/
		return null;
	}

	@Override
	public LigneCommande get(Long id) {
		
		return ligneCommandeRepository.getOne(id);
	}

	@Override
	public boolean AjouterLigneCMD(LigneCommande ligneCommande) {
		ligneCommandeRepository.save(ligneCommande);
		return true;
	}

	@Override
	public boolean ModifierLigneCMD(LigneCommande ligneCommande) {
		ligneCommandeRepository.save(ligneCommande);
		return true;
	}

	@Override
	public boolean SupprimerLigneCMD(Long idligneCommande) {
		ligneCommandeRepository.deleteById(idligneCommande);
		return true;
	}

	@Override
	public List<LigneCommande> listCMD(Commande commande) {
		
		return ligneCommandeRepository.findByCommande(commande);
	}

	// a revoir
	@Override
	public LigneCommande getByCartAndProduct(Commande commande, Produits produit) {
		// 
		return ligneCommandeRepository.findLigneCmdAndProduct(commande,produit);
	}

	@Override
	public List<LigneCommande> listCMD(Long idCMD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneCommande getByCartAndProduct(Long idCMD, Long IDProduit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LigneCommande> findByPanier(Panier panier) {
		
		return ligneCommandeRepository.findByPanier(panier);
	}

	@Override
	public List<LigneCommande> findByCommande(Commande commande) {
		
		return ligneCommandeRepository.findByCommande(commande);
	}

}
