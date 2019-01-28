package com.example.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
