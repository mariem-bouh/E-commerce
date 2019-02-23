package com.example.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.entities.Commande;
import com.example.ecommerce.entities.LigneCommande;
import com.example.ecommerce.entities.Panier;
import com.example.ecommerce.entities.Produits;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long>{


	 @Query("select lc from LigneCommande lc where lc.commande = :x AND lc.produit = :p ")
	//public LigneCommande findLigneCmdAndProducts(@Param("x")Long long1,@Param("p") Long long2); 
	 public LigneCommande findLigneCmdAndProduct(@Param("x")Commande commande,@Param("p") Produits produit);
	 
	// @Query("select lc from LigneCommande lc where lc.commande.idCommande = :d")
//	public List<LigneCommande> findByCommande(@Param("d")Long idCMD);
	 
	public List<LigneCommande> findByCommande(Commande commande);

	public List<LigneCommande> findByPanier(Panier panier);


//	public LigneCommande findLigneCmdAndProduct(int idCMD, int iDProduit);

	//public void findLigneCmdAndProduct(int i, int iDProduit);

}
