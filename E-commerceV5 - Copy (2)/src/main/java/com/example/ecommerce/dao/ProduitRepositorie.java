package com.example.ecommerce.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.ecommerce.entities.Produits;

public interface ProduitRepositorie extends JpaRepository<Produits, Long>{
	 @Query("select p from Produits p where p.designation like :x")
		public List<Produits> chercher(@Param("x")String mc);
	 @Query("select p from Produits p where p.idProduit like :s")
		public Produits findByIdProd(@Param("s") Long idP);
	//public List<Produits> findByCategorie(Long idcat);

	public List<Produits> findBySelected(boolean b);

	public List<Produits> findBysouscategorie(Long idcat);


}

