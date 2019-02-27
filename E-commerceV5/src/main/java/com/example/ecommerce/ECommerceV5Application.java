package com.example.ecommerce;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.example.ecommerce.controller.AdminCategoriesController;
import com.example.ecommerce.dao.LigneCommandeRepository;
import com.example.ecommerce.dao.PanierRepository;
import com.example.ecommerce.dao.ProduitRepositorie;
import com.example.ecommerce.dao.UserRepository;
import com.example.ecommerce.entities.Commande;
import com.example.ecommerce.entities.LigneCommande;
import com.example.ecommerce.entities.Panier;
import com.example.ecommerce.entities.Produits;
import com.example.ecommerce.entities.Users;

@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.example.ecommerce", "com.example.ecommerce.controller" })

@SpringBootApplication
public class ECommerceV5Application {
	@Autowired
	public LigneCommandeRepository ligneCommandeRepository;
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public PanierRepository panierRepository;
	@Autowired
	public ProduitRepositorie produitRepositorie;
		
	public static void main(String[] args) {
		// ConfigurableApplicationContext ctx=
		new File(AdminCategoriesController.uploadDirectory).mkdir();
		ResourceConfig d = new ResourceConfig();
		ApplicationContext ctx = SpringApplication.run(ECommerceV5Application.class, args);

		/*
		 * Ajout et recupereation d'une ligne de CMD
		 * 
		 */
		LigneCommandeRepository ligneCommandeRepository = ctx.getBean(LigneCommandeRepository.class);
		// ligneCommandeRepository.findLigneCmdAndProduct(1, 1);
		List<LigneCommande> cmd = ligneCommandeRepository.findAll();

		for (int i = 0; i < cmd.size(); i++) {
			System.out.println(cmd.toString());
		}
		// recuperation d'une commande particuliere
		String num = "3";
		Commande commande = new Commande();
		commande.setIdCommande(Long.parseLong(num));
		Produits produits = new Produits();
		produits.setIdProduit(Long.parseLong(num));

		List<LigneCommande> lc = ligneCommandeRepository.findByCommande(commande);
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("ligne de commande par Commande");
		System.out.println(lc.toString());
		// recuperation d'une commande particuliere et d'un produit
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("ligne de commande par produit et par commande");
		String num1 = "1";
		String num2 = "3";
		Commande commande1 = new Commande();
		commande1.setIdCommande(Long.parseLong(num2));
		Produits produits1 = new Produits();
		produits1.setIdProduit(Long.parseLong("2"));

		LigneCommande lc1 = ligneCommandeRepository.findLigneCmdAndProduct(commande1, produits1);

		System.out.println("par produit et par commande :" + lc1.toString());

		/*
		 * 
		 * Fin Ajout et recupereation d'une ligne de CMD
		 * 
		 * 
		 */

		/*
		 * 
		 * Ajouter une ligne de CMD
		 * 
		 * 
		 */

		Produits produits2 = null;
		Panier panier = new Panier();
		Commande commande2 = null;
		LigneCommande commande3 =new LigneCommande();
		Users users = new Users();
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		PanierRepository panierRepository = ctx.getBean(PanierRepository.class);
		// recuperation du panier d'un utilisateur specifique
		// 1.Recuperation de l'utilisateur
		users = userRepository.findByUsername("user1");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("utilisateur recuperer " +users.toString());
		
		//Long idUser=users.getIdUser();
		//2.recuperation du panier concernant cet utilisateurs
		panier=panierRepository.findByUsers(users);
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("id utilisateur pour un panier " +panier.toString());
		
		// Ajouter le produit pour le correspondre a cet utilisateur et a un panier qui le correpondre
		//3.recuperation du produit 1
		ProduitRepositorie produitRepositorie = ctx.getBean(ProduitRepositorie.class);

		produits=produitRepositorie.findByIdProd(Long.parseLong("1"));
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("produits 1 " +produits.toString());
		//4.Creation de la ligne de commande a partir de tout
		commande3.setPrix(produits.getPrix());
		Double total=produits.getQuantite()*produits.getPrix();
	}

	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver, SpringSecurityDialect sec) {
		final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.addDialect(sec); // Enable use of "sec"
		return templateEngine;
	}

}
