package com.example.ecommerce.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.Commande;
import com.example.ecommerce.entities.LigneCommande;
import com.example.ecommerce.entities.Panier;

@Service
public interface ILigneDeCommandeMetier extends InternauteEcommerceMetier{

	public LigneCommande get(int id);
	public boolean AjouterLigneCMD(LigneCommande ligneCommande);
	public boolean ModifierLigneCMD(LigneCommande ligneCommande);
	public boolean SupprimerLigneCMD(Long idligneCommande);
    public List<LigneCommande> listCMD(int idCMD);
    //public List<LigneCommande> listLigneCMD();
    public List<LigneCommande> findByPanier(Panier Panier);
//public LigneCommande getByCartAndProduct(int idCMD,int IDProduit);
  public LigneCommande getByCartAndProduct(Long idCMD,Long IDProduit);
public LigneCommande findById(Long id);

}
