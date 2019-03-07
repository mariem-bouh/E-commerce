package com.example.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	 @Query("select r from Role r where r.users.idUser like :x")
	public Role findByUserId(@Param("x")Long idUser);

}
