package com.example.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
