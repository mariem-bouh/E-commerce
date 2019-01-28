package com.example.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.entities.SousCategorie;

public interface SousCategorieRepository extends JpaRepository<SousCategorie, Long>{
	 @Query("select p from SousCategorie p where p.idsousCategorie like :x")
public	SousCategorie findByIdSousCAT(@Param("x") Long idcat);

	 
}
