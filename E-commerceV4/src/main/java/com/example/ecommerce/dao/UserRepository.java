package com.example.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
