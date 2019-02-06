package com.example.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	 @Query("select p from Users p where p.username like :x")
	public Users findByUsername(@Param("x")String name);

}
