package com.example.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.entities.Categorie;
import com.example.ecommerce.entities.Produits;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	 @Query("select p from Categorie p where p.idcategorie like :x")
	public Categorie findByIdCat(@Param("x") Long idcat);


}
