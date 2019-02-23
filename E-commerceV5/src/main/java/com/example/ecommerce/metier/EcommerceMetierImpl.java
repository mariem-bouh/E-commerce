package com.example.ecommerce.metier;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dao.IEcommerceDAO;
import com.example.ecommerce.dao.LigneCommandeRepository;
import com.example.ecommerce.entities.Categorie;
import com.example.ecommerce.entities.Commande;
import com.example.ecommerce.entities.LigneCommande;
import com.example.ecommerce.entities.Panier;
import com.example.ecommerce.entities.Produits;
import com.example.ecommerce.entities.Role;
import com.example.ecommerce.entities.SousCategorie;
import com.example.ecommerce.entities.Users;
import com.example.ecommerce.entities.Users;

@Service
@Transactional
public class EcommerceMetierImpl implements IAdminCategorieMetier, ILigneDeCommandeMetier {
//contient la liste de toute les methodes
	@Autowired
	private IEcommerceDAO dao;

	// injection des dependances
	public void setDao(IEcommerceDAO dao) {
		this.dao = dao;
	}

	@Override
	public Long AjouterProduit(Produits p, Long idCAT) {
		// TODO Auto-generated method stub
		return dao.AjouterProduit(p, idCAT);
	}

	@Override
	public void supprimerProduit(Long idp) {
		dao.supprimerProduit(idp);
	}

	@Override
	public void modifierProduit(Produits p) {
		dao.modifierProduit(p);
	}

	@Override
	public List<Categorie> listCtegorie() {
		// TODO Auto-generated method stub
		return dao.listCategorie();
	}

	@Override
	public Categorie getCategorie(Long idcat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idcat);
	}

	@Override
	public List<Produits> listProduit() {
		// TODO Auto-generated method stub
		return dao.Listproduits();
	}

	@Override
	public List<Produits> produitParMotClef(String mc) {
		// TODO Auto-generated method stub
		return dao.produitsParMotcle(mc);
	}

	@Override
	public List<Produits> produitParCategorie(Long idcat) {
		// TODO Auto-generated method stub
		return dao.produitParSousCategorie(idcat);
	}

	@Override
	public List<Produits> produitSelectionner() {
		// TODO Auto-generated method stub
		return dao.produitSelectonner();
	}

	@Override
	public Produits getProduit(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProduit(idP);
	}

	@Override
	public Commande enregistrerCommnde(Panier p, Users c) {
		// TODO Auto-generated method stub
		return dao.enregistrerCommnde(p, c);
	}

	@Override
	public Long AjouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.AjouterCategorie(c);
	}

	@Override
	public void SupprimerCategorie(Long idCat) {
		dao.SupprimerCategorie(idCat);

	}

	@Override
	public void modifierCategorie(Categorie c) {
		dao.modifierCategorie(c);

	}

	@Override
	public void AjouterUser(Users u) {
		dao.AjouterUser(u);

	}

	@Override
	public void AttribuerRole(Role R, Long userid) {
		dao.AttribuerRole(R, userid);
	}

	@Override
	public Long AjouterSousCategorie(SousCategorie c) {
		// TODO Auto-generated method stub
		return dao.AjouterSousCategorie(c);
	}

	@Override
	public void SupprimerSousCategorie(Long idCat) {
		dao.SupprimerSousCategorie(idCat);

	}

	@Override
	public void modifierSousCategorie(SousCategorie c) {
		dao.modifierSousCategorie(c);

	}

	@Override
	public List<SousCategorie> ListSousCategory() {

		return dao.listSousCategorie();
	}

	@Override
	public SousCategorie getSousCategorie(Long idcat) {

		return dao.getSousCategorie(idcat);
	}

	@Override
	public LigneCommande get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean AjouterLigneCMD(LigneCommande ligneCommande) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ModifierLigneCMD(LigneCommande ligneCommande) {
		dao.ModifierLigneCMD(ligneCommande);
		return true;
	}

	@Override
	public boolean SupprimerLigneCMD(Long idligneCommande) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LigneCommande> listCMD(int idCMD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneCommande getByCartAndProduct(Long idCMD, Long IDProduit) {
		// TODO Auto-generated method stub
		return dao.getByCartAndProduct(idCMD, IDProduit);
	}

	@Override
	public List<LigneCommande> findByPanier(Panier panier) {
		// TODO Auto-generated method stub
		return dao.findByPanier(panier);
	}

}
