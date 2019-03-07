package com.example.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.entities.Panier;
import com.example.ecommerce.entities.Role;
import com.example.ecommerce.entities.Users;

public interface PanierRepository extends JpaRepository<Panier, Long>{
	 @Query("select p from Panier p where p.users.idUser like :x")
	public Panier findByUserIdPanier(@Param("x")Long idUser);

	public Panier findByUsers(Users users);

}
